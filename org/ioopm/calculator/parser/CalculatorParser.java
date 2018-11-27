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
		this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :) 
		this.st.ordinaryChar('/');
        this.st.eolIsSignificant(true);
	}

	public SymbolicExpression statement() throws IOException {
		this.st.nextToken(); 										// +1
		if (this.st.ttype == this.st.TT_WORD) {
			if (this.st.sval.equals("vars")) {
				Vars cmd = Vars.instance();
			}
			else if (this.st.sval.equals("quit")) {
				// Fixme 
				// return new Quit.instance();
				Quit cmd = Quit.instance();
			}
		}
		this.st.pushBack();
		return assignment();
			
	}

	public SymbolicExpression assignment() throws IOException {
		// Calculate AST for LHS and assign to RHS if RHS exists!
		
		//LHS
		SymbolicExpression result = expression();

		//RHS
		this.st.nextToken();
		
		while (this.st.ttype == '=') {
			this.st.nextToken();
			SymbolicExpression identifier = new Variable(this.st.sval);
			result = new Assignment(result, identifier);
			this.st.nextToken();
		}
		this.st.pushBack();

		return result;
	}

	public SymbolicExpression expression() throws IOException {
		/// Read a term and make it the current sum 
        SymbolicExpression lhs = term();
        /// Read the next token and put it in sval/nval/ttype depending on the token
        this.st.nextToken();
        /// If the token read was + or -, go into the loop 
        while (this.st.ttype == '+' || this.st.ttype == '-') {

            if(this.st.ttype == '+'){
                /// If we are adding things, read a term and add it to the current sum
                operatorCheck();
            	SymbolicExpression rhs = term();
                lhs = new Addition(lhs,rhs);
            } else {
                /// If we are adding things, read a term and subtract it from the current sum
                operatorCheck();
            	SymbolicExpression rhs = term();
                lhs = new Subtraction(lhs,rhs);
            }
            /// Read the next token into sval/nval/ttype so we can go back in the loop again
            this.st.nextToken();
        }
        /// If we came here, we read something which was not a + or -, so we need to put
        /// that back again (whatever it was) so that we did not accidentally ate it up!
        this.st.pushBack();
        /// We are done, return sum
        return lhs;
    }

    public SymbolicExpression term() throws IOException {
		/// Read a term and make it the current sum 
        SymbolicExpression lhs = primary();
        /// Read the next token and put it in sval/nval/ttype depending on the token
        this.st.nextToken();
        /// If the token read was + or -, go into the loop 
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
        /// If we came here, we read something which was not a + or -, so we need to put
        /// that back again (whatever it was) so that we did not accidentally ate it up!
        this.st.pushBack();
        /// We are done, return sum
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
}