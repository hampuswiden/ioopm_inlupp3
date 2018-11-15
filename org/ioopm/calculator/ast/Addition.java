package org.ioopm.calculator.ast;

public class Addition extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
	}

	public String getName() {
 		return "+";
	}

	public int getPriority() {
    	return 4;
  	}
}