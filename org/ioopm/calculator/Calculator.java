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
		
		while(true) {
	        //Scanner in = new Scanner(System.in);
	        System.out.println("Welcome to the parser!");
	        System.out.print("Please enter an expression: ");
	        //String s = in.nextLine();
	        String input = System.console().readLine();
	
	        try {
	        	p.parse(input);
	            SymbolicExpression result = p.statement();
	            System.out.println("result: " + result);
	            
	            result = result.eval(env);
	            System.out.println("result: " + result);
	            
	        } catch(SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	        } catch(IOException e) {
	            System.err.println("IO Exception!");
	        }
	        
		}
    }
}

