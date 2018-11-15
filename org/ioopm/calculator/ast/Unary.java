package org.ioopm.calculator.ast;

public abstract class Unary extends Assignment{
	private SymbolicExpression arg;
	
	public Unary(SymbolicExpression arg) {
		super(arg);
	}
}