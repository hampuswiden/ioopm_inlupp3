package org.ioopm.calculator;

import java.io.IOException;
import java.util.Scanner;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
import org.ioopm.calculator.parser.CalculatorParser.SyntaxErrorException;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Calculator {

	/**
 	* Main function which handles the I/O part of the calculator.
 	* <p>
 	* The main method handles the user I/O by the use of an event loop and 
 	* sending the user's input to the parser for parsing/evaluating.
 	* It has functionality for printing/clearing the variables stored by typing
 	* "vars" or "clear" respectively. As well as quitting by typing "quit".
 	* Once the user quits the calculator a message with some statistics will
 	* be displayed for the user, and then the program terminates.
 	* </p>
 	* @param  args string arguments (default signature for main method, not used)
 	*/
	public static void main(String[] args) {
		/**
		* The parser which will parse any input from the user.
		*/
		final CalculatorParser p = new CalculatorParser();

		/**
		* the environment where all variables are stored.
		*/
		final Environment env = new Environment();

		/**
		* the no. expressions typed into the calculator.
		*/
		int expressions = 0;

		/**
		* the no. expressions typed into the calculator which were valuated.
		*/
	    int evaluatedExpressions = 0;

	    /**
		* the no. expressions typed into the calculator which could be evaluted (variables).
		*/
	    int variableExpressions = 0;

	    /**
		* boolean the event loop
		*/
		boolean loop = true;

        System.out.println("Welcome to the parser!");
		while(loop) {
	        System.out.print("Please enter an expression: ");
	        String input = System.console().readLine();
	
	        try {
	        	p.parse(input);
	            SymbolicExpression result = p.statement();

	            if (result.equals(Quit.instance())) {
	            	loop = false;
	            } else if (result.equals(Vars.instance())) {
	            	for (Object key : env.keySet()) {
	            		System.out.println(key + " = " + env.get(key));
	            	}
	            } else if (result.equals(Clear.instance())) {
	            	env.clear();
	            } else {
	            	expressions += 1;
		            System.out.println("result: " + result);
		            SymbolicExpression eval = result.eval(env);
		            System.out.println("result: " + eval);
		            if (eval.isConstant()) {
		            	evaluatedExpressions += 1;
		            }
		            else {
		            	variableExpressions += 1;
		            }
	            }
	            
	        } catch(SyntaxErrorException e) {
	        	expressions += 1;
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	        } catch(IOException e) {
	        	expressions += 1;
	            System.err.println("IO Exception!");
	        } 
		}
		System.out.println("No. expressions: " + expressions);
        System.out.println("No. evaluated expressions: " + evaluatedExpressions);
        System.out.println("No. variable expressions: " + variableExpressions);
    }
}