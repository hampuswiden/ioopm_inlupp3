//package org.ioopm.calculator.ast;

public abstract class Binary extends Assignment{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
	}
}