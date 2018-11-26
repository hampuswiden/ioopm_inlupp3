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
		this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :) 
        this.st.eolIsSignificant(true);
	}
	
	public void parse(String inputString) {
		this.st = new StreamTokenizer(new StringReader("45 + 10"));
	}

	public SymbolicExpression statement() throws IOException {
		this.st.nextToken();

		if (this.st.TT_EOL == 1) {
			// Fixme
			return new Constant(1);
		}

		if (this.st.ttype == this.st.TT_WORD) {
			if (this.st.sval.equals("vars")) {
				// Fixme 
				// return new Vars.instance();
				return new Constant(1);
			}
			else if (this.st.sval.equals("quit")) {
				// Fixme 
				// return new Quit.instance();
				return new Constant(1);
			}
		} else {
			return assignment();
		}
		return new Constant(1337);
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
        	SymbolicExpression rhs = term();
            if(this.st.ttype == '+'){
                /// If we are adding things, read a term and add it to the current sum
                lhs = new Addition(lhs,rhs);
            } else {
                /// If we are adding things, read a term and subtract it from the current sum
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
        	SymbolicExpression rhs = primary();
            if(this.st.ttype == '*'){
                /// If we are adding things, read a term and add it to the current sum
                lhs = new Multiplication(lhs,rhs);
            } else {
                /// If we are adding things, read a term and subtract it from the current sum
                lhs = new Division(lhs,rhs);
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
    	this.st.nextToken();
		SymbolicExpression primary = primary();
		this.st.pushBack();
		if (this.st.ttype == this.st.TT_WORD) {
			if (this.st.sval.equals("exp")) {
				result = new Exp(primary);
			} else if (this.st.sval.equals("log")) {
				result = new Log(primary);
			} else if (this.st.sval.equals("sin")) {
				result = new Sin(primary);
			} else if ((this.st.sval.equals("cos"))) {
				result = new Cos(primary);
			}
		} else { // Negation
			result = new Negation(primary);
		}
		this.st.nextToken();
		return result;
    }

    public SymbolicExpression identifier() throws IOException {
    	return new Variable(this.st.sval);
    }

    public SymbolicExpression number() throws IOException {
    	return new Constant(this.st.nval);
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