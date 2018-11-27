import org.ioopm.calculator.ast.*;
import java.util.HashMap;

public class Test {
	Environment vars = new Environment();

	public void ast_constant() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		boolean result1 = c1.equals(c1);
		boolean result2 = c1.equals(c2);
		assert result1;
		assert result2;

	}



	public static void main(String[] args) {
		Environment vars = new Environment();

		




		////////////////////
		////// Parser //////
		////////////////////













		///////////////////
		/////// AST ///////
		///////////////////


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
		m1.testEvaluating(c2, vars);
		sin.testEvaluating(sin, vars);
		a3.testEvaluating(c3, vars);


		
		//Eval()
		Assignment as1 = new Assignment(a3, x);
		as1.testEvaluating(c3, vars);
		y.testEvaluating(c3, vars);



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
		t18.testEvaluating(t19, vars);

		// Double assignment

		Constant t20 = new Constant(5.0);
		Variable t21 = new Variable("N");
		Variable t22 = new Variable("M");
		Assignment t23 = new Assignment(t20, t21);
		Assignment t24 = new Assignment(t23, t22);
		t24.testEvaluating(t23, vars);


		Variable a = new Variable("q");
		Variable b = new Variable("q");
		System.out.println("a = " + a.hashCode() + "\nb = " + b.hashCode());


		
	}
}