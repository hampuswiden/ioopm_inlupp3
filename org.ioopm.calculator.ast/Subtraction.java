//package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
	}
}