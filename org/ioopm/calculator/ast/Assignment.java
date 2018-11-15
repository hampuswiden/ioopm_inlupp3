package org.ioopm.calculator.ast;

public class Assignment extends SymbolicExpression{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Assignment", lhs, rhs);
	}
	
	public Assignment(SymbolicExpression arg) {
		super("Assignment", arg);
	}
	
}