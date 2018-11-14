//package org.ioopm.calculator.ast;

public class Binary extends Assignment{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
	}
}