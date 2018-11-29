import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Test {
	/**
	 * Environment that hold all variables and it's values.
	 */
	Environment vars;
	
	/**
	 * Constructor for Test.
	 * @since  1.0
	 */
	public Test() {
		this.vars = new Environment();
	};
	
	/**
	 * Tests the classes and methods of the abstract syntax tree package, ast.
	 */
	public void astTest() {
		this.astConstant();
		this.astVariable();
		this.astAddition();
		this.astSubtraction();
		this.astMultiplication();
		this.astDivision();
		this.astAssignment();
		this.astCos();
		this.astSin();
		this.astExp();
		this.astLog();
		this.astNegation();
	}
	
	/**
	 * Tests the classes and methods of the parser package.
	 */
	public void parseTest() {
		this.astTest();
		this.parseBinary();
		this.parseUnary();
		this.parseCommand();
		this.parseAtom();
		this.parseGeneral();
	}

	
	
	 ///////////////////
	//// AST TESTS ////
   ///////////////////

	/**
	 * Tests the Constant Class in the ast package.
	 */
	public void astConstant() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		boolean result1 = c1.equals(c1);
		boolean result2 = c1.equals(c2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Variable Class in the ast package.
	 */
	public void astVariable() {
		Variable v1 = new Variable("X");
		Variable v2 = new Variable("Y");
		boolean result1 = v1.equals(v1);
		boolean result2 = v1.equals(v2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Addition Class in the ast package.
	 */
	public void astAddition() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Addition a1 = new Addition(c1, c2);
		Addition a2 = new Addition(c2, c1);
		Addition a3 = new Addition(c1, c3);
		boolean result1 = a1.equals(a1);
		boolean result2 = a1.equals(a2);
		boolean result3 = a1.equals(a3);
		assert result1;
		assert result2;
		assert !result3;
	}
	
	/**
	 * Tests the Subtraction Class in the ast package.
	 */
	public void astSubtraction() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Subtraction s1 = new Subtraction(c1, c2);
		Subtraction s2 = new Subtraction(c2, c1);
		Subtraction s3 = new Subtraction(c1, c3);
		boolean result1 = s1.equals(s1);
		boolean result2 = s1.equals(s2);
		boolean result3 = s1.equals(s3);
		assert result1;
		assert !result2;
		assert !result3;
	}
	
	/**
	 * Tests the Multiplication Class in the ast package.
	 */
	public void astMultiplication() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Multiplication m1 = new Multiplication(c1, c2);
		Multiplication m2 = new Multiplication(c2, c1);
		Multiplication m3 = new Multiplication(c1, c3);
		boolean result1 = m1.equals(m1);
		boolean result2 = m1.equals(m2);
		boolean result3 = m1.equals(m3);
		assert result1;
		assert result2;
		assert !result3;
	}
	
	/**
	 * Tests the Division Class in the ast package.
	 */
	public void astDivision() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Division d1 = new Division(c1, c2);
		Division d2 = new Division(c2, c1);
		Division d3 = new Division(c1, c3);
		boolean result1 = d1.equals(d1);
		boolean result2 = d1.equals(d2);
		boolean result3 = d1.equals(d3);
		assert result1;
		assert !result2;
		assert !result3;
	}
	
	/**
	 * Tests the Assignment Class in the ast package.
	 */
	public void astAssignment() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Variable v1 = new Variable("X");
		Variable v2 = new Variable("Y");
		Assignment a1 = new Assignment(c1, v1);
		Assignment a2 = new Assignment(c2, v1);
		Assignment a3 = new Assignment(c1, v2);
		boolean result1 = a1.equals(a1);
		boolean result2 = a1.equals(a2);
		boolean result3 = a1.equals(a3);
		assert result1;
		assert !result2;
		assert !result3;
	}
	
	/**
	 * Tests the Cos Class in the ast package.
	 */
	public void astCos() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Cos cos1 = new Cos(c1);
		Cos cos2 = new Cos(c2);
		boolean result1 = cos1.equals(cos1);
		boolean result2 = cos1.equals(cos2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Sin Class in the ast package.
	 */
	public void astSin() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Sin sin1 = new Sin(c1);
		Sin sin2 = new Sin(c2);
		boolean result1 = sin1.equals(sin1);
		boolean result2 = sin1.equals(sin2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Exp Class in the ast package.
	 */
	public void astExp() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Exp exp1 = new Exp(c1);
		Exp exp2 = new Exp(c2);
		boolean result1 = exp1.equals(exp1);
		boolean result2 = exp1.equals(exp2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Log Class in the ast package.
	 */
	public void astLog() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Log log1 = new Log(c1);
		Log log2 = new Log(c2);
		boolean result1 = log1.equals(log1);
		boolean result2 = log1.equals(log2);
		assert result1;
		assert !result2;
	}
	
	/**
	 * Tests the Negation Class in the ast package.
	 */
	public void astNegation() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Negation n1 = new Negation(c1);
		Negation n2 = new Negation(c2);
		boolean result1 = n1.equals(n1);
		boolean result2 = n1.equals(n2);
		assert result1;
		assert !result2;
	}
	
	
	
	 //////////////////////
	//// PARSER TESTS ////
   //////////////////////
	
	/**
	 * Tests the Atom class and its sublcasses in the ast package, used by the parser.
	 */
	public void parseAtom() {
		Constant c1 = new Constant(1);
		Variable v1 = new Variable("x");
		NamedConstant n1 = new NamedConstant("pi");
		
		CalculatorParser p = new CalculatorParser();
		
		String s1 = "1";
		String s2 = "x";
		
		SymbolicExpression r1 = new Variable("Error");
		SymbolicExpression r2 = new Variable("Error");
		
		try {
			p.parse(s1);
			r1 = p.statement();
			
			p.parse(s2);
			r2 = p.statement();
			
		 } catch(CalculatorParser.SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	     } catch(IOException e) {
	            System.err.println("IO Exception!");
	     }
		
		boolean constantResult = r1.equals(c1);
		boolean variableResult = r2.equals(v1);
		boolean namedConstantResult = n1.getName().equals("named constant");
		
		assert constantResult;
		assert variableResult;
		assert namedConstantResult;
	}
	
	/**
	 * Tests the Binary class, its sublcasses and the Assignment class in the ast package, used by the parser.
	 */
	public void parseBinary() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Variable v1 = new Variable("x");
		Addition add1 = new Addition(c1, c2);
		Subtraction sub1 = new Subtraction(c2, c1);
		Multiplication mult1 = new Multiplication(c1, c2);
		Division div1 = new Division(c3, c2);
		Assignment ass1 = new Assignment(c2, v1);
		
		CalculatorParser p = new CalculatorParser();
		
		String s1 = "1 + 2";
		String s2 = "2 - 1";
		String s3 = "1 * 2";
		String s4 = "3 / 2";
		String s5 = "2 = x";
		
		SymbolicExpression r1 = new Variable("Error");
		SymbolicExpression r2 = new Variable("Error");
		SymbolicExpression r3 = new Variable("Error");
		SymbolicExpression r4 = new Variable("Error");
		SymbolicExpression r5 = new Variable("Error");
		
		try {
			p.parse(s1);
			r1 = p.statement();
			
			p.parse(s2);
			r2 = p.statement();
			
			p.parse(s3);
			r3 = p.statement();
			
			p.parse(s4);
			r4 = p.statement();
			
			p.parse(s5);
			r5 = p.statement();
			
		 } catch(CalculatorParser.SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	     } catch(IOException e) {
	            System.err.println("IO Exception!");
	     }
		
		boolean addResult = r1.equals(add1);
		boolean subResult = r2.equals(sub1);
		boolean multResult = r3.equals(mult1);
		boolean divResult = r4.equals(div1);
		boolean assResult = r5.equals(ass1);
		
		assert addResult;
		assert subResult;
		assert multResult;
		assert divResult;
		assert assResult;
	}
	
	/**
	 * Tests the Unary class and its sublcasses in the ast package, used by the parser.
	 */
	public void parseUnary() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Cos cos1 = new Cos(c1);
		Sin sin1 = new Sin(c2);
		Exp exp1 = new Exp(c1);
		Log log1 = new Log(c2);
		Negation n1 = new Negation(c2);
		
		CalculatorParser p = new CalculatorParser();
		
		String s1 = "cos 1";
		String s2 = "sin 2";
		String s3 = "exp 1";
		String s4 = "log 2";
		String s5 = "-2";
		
		SymbolicExpression r1 = new Variable("Error");
		SymbolicExpression r2 = new Variable("Error");
		SymbolicExpression r3 = new Variable("Error");
		SymbolicExpression r4 = new Variable("Error");
		SymbolicExpression r5 = new Variable("Error");
		
		try {
			p.parse(s1);
			r1 = p.statement();
			
			p.parse(s2);
			r2 = p.statement();
			
			p.parse(s3);
			r3 = p.statement();
			
			p.parse(s4);
			r4 = p.statement();
			
			p.parse(s5);
			r5 = p.statement();
			
		 } catch(CalculatorParser.SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	     } catch(IOException e) {
	            System.err.println("IO Exception!");
	     }
		
		boolean cosResult = r1.equals(cos1);
		boolean sinResult = r2.equals(sin1);
		boolean expResult = r3.equals(exp1);
		boolean logResult = r4.equals(log1);
		boolean negationResult = r5.equals(n1);
		
		assert cosResult;
		assert sinResult;
		assert expResult;
		assert logResult;
		assert negationResult;
	}
	
	/**
	 * A set of general tests for the parser.
	 */
	public void parseGeneral() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		Variable v1 = new Variable("x");
		Variable v2 = new Variable("y");
		
		Addition add1 = new Addition(c1, c2);
		Subtraction sub1 = new Subtraction(c2, c1);
		Multiplication mult1 = new Multiplication(c1, c2);
		Division div1 = new Division(c3, c2);
		Cos cos1 = new Cos(c1);
		Sin sin1 = new Sin(c2);
		Exp exp1 = new Exp(c1);
		Log log1 = new Log(c2);
		Negation n1 = new Negation(c2);
		Assignment ass1 = new Assignment(c2, v1);
		
		Addition add2 = new Addition(log1, div1);
		Subtraction sub2 = new Subtraction(exp1, sin1);
		Multiplication mult2 = new Multiplication(v1, sub1);
		Division div2 = new Division(sub2, c3);
		Cos cos2 = new Cos(v2);
		Sin sin2 = new Sin(add1);
		Exp exp2 = new Exp(cos1);
		Log log2 = new Log(mult1);
		Negation n2 = new Negation(n1);
		Assignment ass2 = new Assignment(log2, v1);
		
		
		Addition add3 = new Addition(log1, mult2);
		Subtraction sub3 = new Subtraction(v1, cos2);
		Multiplication mult3 = new Multiplication(c1, log2);
		Division div3 = new Division(n2, n1);
		Cos cos3 = new Cos(add2);
		Sin sin3 = new Sin(cos2);
		Exp exp3 = new Exp(div3);
		Log log3 = new Log(n2);
		Negation n3 = new Negation(c2);
		Assignment ass3 = new Assignment(ass1, v2);
		
		CalculatorParser p = new CalculatorParser();
		
		String s1 = "--2 / -2"; //div3
		String s2 = "log(2) + x * (2-1)"; //add3
		String s3 = "x - cos(y)"; // sub3
		String s4 = "1 * log(1 * 2)"; // mult3
		String s5 = "2 = x = y"; // ass3
		
		SymbolicExpression r1 = new Variable("Error");
		SymbolicExpression r2 = new Variable("Error");
		SymbolicExpression r3 = new Variable("Error");
		SymbolicExpression r4 = new Variable("Error");
		SymbolicExpression r5 = new Variable("Error");
		
		try {
			p.parse(s1);
			r1 = p.statement();
			
			p.parse(s2);
			r2 = p.statement();
			
			p.parse(s3);
			r3 = p.statement();
			
			p.parse(s4);
			r4 = p.statement();
			
			p.parse(s5);
			r5 = p.statement();
			
		 } catch(CalculatorParser.SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	     } catch(IOException e) {
	            System.err.println("IO Exception!");
	     }
		
		boolean result1 = r1.equals(div3);
		boolean result2 = r2.equals(add3);
		boolean result3 = r3.equals(sub3);
		boolean result4 = r4.equals(mult3);
		boolean result5 = r5.equals(ass3);
		
		assert result1;
		assert result2;
		assert result3;
		assert result4;
		assert result5;
	}
	/**
	 * Tests the Command class and its sublcasses in the ast package, used by the parser.
	 */
	public void parseCommand() {
		
		Vars v1 = Vars.instance();
		Quit q1 = Quit.instance();
		Clear c1 = Clear.instance();
		
		CalculatorParser p = new CalculatorParser();
		
		String s1 = "vars";
		String s2 = "quit";
		String s3 = "clear";
		
		SymbolicExpression r1 = new Variable("Error");
		SymbolicExpression r2 = new Variable("Error");
		SymbolicExpression r3 = new Variable("Error");
		
		try {
			p.parse(s1);
			r1 = p.statement();
			
			p.parse(s2);
			r2 = p.statement();
			
			p.parse(s3);
			r3 = p.statement();
			
		 } catch(CalculatorParser.SyntaxErrorException e) {
	            System.out.print("Syntax Error: ");
	            System.out.println(e.getMessage());
	     } catch(IOException e) {
	            System.err.println("IO Exception!");
	     }
		
		boolean varsResult = r1.equals(v1);
		boolean quitResult = r2.equals(q1);
		boolean clearResult = r3.equals(c1);
		
		assert varsResult;
		assert quitResult;
		assert clearResult;
	}

	/**
	 * The main method. Runs the ast test and parser test.
	 */
	public static void main(String[] args) {
		Test test = new Test();
		test.astTest();
		test.parseTest();
	}
}