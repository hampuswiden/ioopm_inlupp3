import org.ioopm.calculator.ast.*;
import java.util.HashMap;

public class Test {
	
	public static void main(String[] args) {
		HashMap<Variable, SymbolicExpression> vars = new HashMap<>();

		Constant c1 = new Constant(5);
		Constant c2 = new Constant(2);
		Variable v = new Variable("x");
		Addition a1 = new Addition(c1, v);
		Addition a2 = new Addition(v, c1);
		Multiplication m1 = new Multiplication(a1, c2);
		Multiplication m2 = new Multiplication(c2, a1);
		Sin sin = new Sin(c2);

		c1.testPrinting("5.0");
		v.testPrinting("x");
		m1.testPrinting("(5.0 + x) * 2.0");

		System.out.println(c1);
		System.out.println(v);
		System.out.println(a1);
		System.out.println(m1);



		m1.testEvaluating(c2);
		sin.testEvaluating(sin);


		boolean result1 = c1.equals(c2);
		boolean result2 = a1.equals(a2);
		boolean result3 = m1.equals(m2);
		boolean result4 = sin.equals(sin);

		System.out.println("c1.equals(c2): " + result1);
		System.out.println("a1.equals(a2): " + result2);
		System.out.println("m1.equals(m2): " + result3);
		System.out.println("sin.equals(sin): " + result4);
	}
}