package org.ioopm.calculator;

import java.io.IOException;
import java.util.Scanner;

import org.ioopm.calculator.parser.*;
import org.ioopm.calculator.ast.*;


import org.ioopm.calculator.parser.CalculatorParser.SyntaxErrorException;

public class Calculator {
	
	
	public static void main(String[] args) {
		final CalculatorParser p = new CalculatorParser();
		final Environment env = new Environment();

		int expressions = 0;
	    int evaluatedExpressions = 0;
	    int variableExpressions = 0;
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

