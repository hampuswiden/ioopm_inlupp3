package org.ioopm.calculator.parser;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.IOException;
import java.util.Scanner;
import org.ioopm.calculator.ast.*;

public class CalculatorParser {
	private StreamTokenizer st;
	
	public CalculatorParser() {
		this.st = new StreamTokenizer(new StringReader(""));
	}
	
	public void parse(String inputString) {
		this.st = new StreamTokenizer(new StringReader(inputString));
		this.st.ordinaryChar('-');
		this.st.ordinaryChar('/');
        this.st.eolIsSignificant(true);
	}

	public SymbolicExpression statement() throws IOException {
		this.st.nextToken(); 
		if (this.st.ttype == this.st.TT_WORD) {
			if (this.st.sval.equals("vars")) {
				Vars cmd = Vars.instance();
				return cmd;
			} else if (this.st.sval.equals("quit")) {
				Quit cmd = Quit.instance();
				return cmd;
			} else if (this.st.sval.equals("clear")) {
				Clear cmd = Clear.instance();
				return cmd;
			}
		}
		this.st.pushBack();
		return assignment();
			
	}

	public SymbolicExpression assignment() throws IOException {
		
		//LHS
		SymbolicExpression result = expression();

		//RHS
		this.st.nextToken();
		
		while (this.st.ttype == '=') {
			this.st.nextToken();
			if (this.st.sval.equals("pi") || this.st.sval.equals("Answer") || this.st.sval.equals("L") || this.st.sval.equals("e")) {
	    		throw new IllegalExpressionException("Cannot redefine named constant " + this.st.sval);
	    	}
			SymbolicExpression identifier = new Variable(this.st.sval);
			result = new Assignment(result, identifier);
			this.st.nextToken();
		}
		this.st.pushBack();

		return result;
	}

	public SymbolicExpression expression() throws IOException {
        SymbolicExpression lhs = term();
        this.st.nextToken();
        while (this.st.ttype == '+' || this.st.ttype == '-') {

            if(this.st.ttype == '+'){
                operatorCheck();
            	SymbolicExpression rhs = term();
                lhs = new Addition(lhs,rhs);
            } else {
                operatorCheck();
            	SymbolicExpression rhs = term();
                lhs = new Subtraction(lhs,rhs);
            }
            this.st.nextToken();
        }
        this.st.pushBack();
        return lhs;
    }

    public SymbolicExpression term() throws IOException {
        SymbolicExpression lhs = primary();
        this.st.nextToken();
        while (this.st.ttype == '*' || this.st.ttype == '/') {

            if(this.st.ttype == '*'){
            	operatorCheck();
            	SymbolicExpression rhs = primary();
                lhs = new Multiplication(lhs,rhs);
            } else {
            	operatorCheck();
            	SymbolicExpression rhs = primary();
                lhs = new Division(lhs,rhs);
            }

            this.st.nextToken();
        }
        this.st.pushBack();
        return lhs;
    }

    public SymbolicExpression primary() throws IOException {
    	this.st.nextToken();
    	SymbolicExpression result;

    	if (this.st.ttype == '(') {
    		result = assignment();

    		if (this.st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
            }

    	} else if (this.st.ttype == this.st.TT_WORD) {
    		if (this.st.sval.equals("exp") || this.st.sval.equals("log") || this.st.sval.equals("sin") || this.st.sval.equals("cos")) {
    			result = unary();
    		} else if (this.st.sval.equals("pi") || this.st.sval.equals("Answer") || this.st.sval.equals("L") || this.st.sval.equals("e")){
    			result = namedConstant();
    		} else { //Variable
    			result = identifier();
    		}
    	} else if (this.st.ttype == '-') {
    		result = unary();
    	} else {
    		result = number();
    	}
    	return result;
    }

    public SymbolicExpression unary() throws IOException {
    	SymbolicExpression result = new Constant(1337);
    	String tmpFunction = null;
    	if (this.st.ttype == this.st.TT_WORD) {
    		tmpFunction = this.st.sval;
    	}
    	operatorCheck();
		SymbolicExpression primary = primary();
		if (tmpFunction != null) {
			if (tmpFunction.equals("exp")) {
				result = new Exp(primary);
			} else if (tmpFunction.equals("log")) {
				result = new Log(primary);
			} else if (tmpFunction.equals("sin")) {
				result = new Sin(primary);
			} else if ((tmpFunction.equals("cos"))) {
				result = new Cos(primary);
			}
		} else { // Negation
			result = new Negation(primary);
		}
		return result;
    }
    
    public SymbolicExpression namedConstant() throws IOException {
    	return new NamedConstant(this.st.sval);
    }

    public SymbolicExpression identifier() throws IOException {
    	return new Variable(this.st.sval);
    }

    public SymbolicExpression number() throws IOException {
    	return new Constant(this.st.nval);
    }

    public void operatorCheck() throws IOException {
    	this.st.nextToken();
    	if (this.st.ttype == '+' || this.st.ttype == '*' || this.st.ttype == '/') {
        	throw new SyntaxErrorException("error: consecutive operators");
        }
        this.st.pushBack();
    }


	public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: ");
        String s = in.nextLine();

        try {
        	p.parse(s);
            SymbolicExpression result = p.statement();
            System.out.println("result: " + result);
        } catch(SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.err.println("IO Exception!");
        }
    }


	public class SyntaxErrorException extends RuntimeException {
	    public SyntaxErrorException() {
	        super();
	    }
	    public SyntaxErrorException(String msg) {
	        super(msg);
	    }
	}
	
	public class IllegalExpressionException extends RuntimeException {
	    public IllegalExpressionException() {
	        super();
	    }
	    public IllegalExpressionException(String msg) {
	        super(msg);
	    }
	}
}