//package org.ioopm.calculator.ast;

public class Division extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
	}
}