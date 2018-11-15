package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Subtraction", lhs, rhs);
	}

	public String getName() {
 		return "-";
	}

	public int getPriority() {
    	return 4;
  	}
}