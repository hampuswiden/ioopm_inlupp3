package org.ioopm.calculator.ast;

public abstract class Unary extends Assignment{
	private SymbolicExpression arg;
	
	public Unary(String function, SymbolicExpression arg) {
		super(function, arg);
	}
}