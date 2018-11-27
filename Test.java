import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;

import java.io.IOException;
import java.util.HashMap;


//import CalculatorParser.SyntaxErrorException;

public class Test {
	Environment vars;
	
	public Test() {
		this.vars = new Environment();
	};
	
	
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

	public void astConstant() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		boolean result1 = c1.equals(c1);
		boolean result2 = c1.equals(c2);
		assert result1;
		assert !result2;
	}
	
	public void astVariable() {
		Variable v1 = new Variable("X");
		Variable v2 = new Variable("Y");
		boolean result1 = v1.equals(v1);
		boolean result2 = v1.equals(v2);
		assert result1;
		assert !result2;
	}
	
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

	public static void main(String[] args) {
		Test test = new Test();
		test.astTest();
		test.parseTest();
		

		




		////////////////////
		////// Parser //////
		////////////////////













		///////////////////
		/////// AST ///////
		///////////////////
/*

		//Created Expressions
		Constant c1 = new Constant(5.0);
		Constant c2 = new Constant(2.0);
		Constant c3 = new Constant(7.0);
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Addition a1 = new Addition(c1, x);
		Addition a2 = new Addition(x, c1);
		Addition a3 = new Addition(c1, c2);
		Multiplication m1 = new Multiplication(a1, c2);
		Multiplication m2 = new Multiplication(c2, a1);
		Sin sin = new Sin(c2);

		//testPrinting && equals
		c1.testPrinting("5.0");
		x.testPrinting("x");
		m1.testPrinting("(5.0 + x) * 2.0");

		System.out.println(c1);
		System.out.println(x);
		System.out.println(a1);
		System.out.println(m1);


		//testEval
		m1.testEvaluating(c2, test.vars);
		sin.testEvaluating(sin, test.vars);
		a3.testEvaluating(c3, test.vars);


		
		//Eval()
		Assignment as1 = new Assignment(a3, x);
		as1.testEvaluating(c3, test.vars);
		y.testEvaluating(c3, test.vars);



		// Mega test

		Constant t1 = new Constant(1.0);
		Constant t2 = new Constant(2.0);
		Constant t3 = new Constant(3.0);

		Multiplication t4 = new Multiplication(t3, t2);
		Addition t5 = new Addition(t2, t1);
		Division t6 = new Division(t4, t5);
		Cos t7 = new Cos(t6);
		Division t8 = new Division(t2, t7);

		Constant t9 = new Constant(5.1);
		Exp t10 = new Exp(t3);
		Multiplication t11 = new Multiplication(t9, t10);
		Subtraction t12 = new Subtraction(t8, t11);

		Negation t13 = new Negation(t1);
		Log t14 = new Log(t2);
		Multiplication t15 = new Multiplication(t13, t14);
		Addition t16 = new Addition(t12, t15);

		Variable t17 = new Variable("z");
		Assignment t18 = new Assignment(t16, t17);

		Constant t19 = new Constant(-106.189);
		t18.testEvaluating(t19, test.vars);

		// Double assignment

		Constant t20 = new Constant(5.0);
		Variable t21 = new Variable("N");
		Variable t22 = new Variable("M");
		Assignment t23 = new Assignment(t20, t21);
		Assignment t24 = new Assignment(t23, t22);
		t24.testEvaluating(t23, test.vars);


		Variable a = new Variable("q");
		Variable b = new Variable("q");
		System.out.println("a = " + a.hashCode() + "\nb = " + b.hashCode());
*/

		
	}
}