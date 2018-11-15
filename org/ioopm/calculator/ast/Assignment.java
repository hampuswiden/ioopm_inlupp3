package org.ioopm.calculator.ast;

public class Assignment extends SymbolicExpression{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Assignment(String operator, SymbolicExpression lhs, SymbolicExpression rhs) {
		super(operator, lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Assignment(String function, SymbolicExpression lhs) {
		super(function, lhs);
		this.lhs = lhs;
		this.rhs = null;
	}
	
}