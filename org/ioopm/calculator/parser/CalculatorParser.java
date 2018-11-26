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
		this.st = new StreamTokenizer(new StringReader("vars"));
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
			return this.addition();
		}
		return new Constant(1337);
	}

	public SymbolicExpression addition() throws IOException {
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