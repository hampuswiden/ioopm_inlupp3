package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Multiplication", lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getName() {
 		return "*";
	}

	public int getPriority() {
    	return 8;
  	}
}