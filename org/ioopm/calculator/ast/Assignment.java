package org.ioopm.calculator.ast;

public class Assignment extends SymbolicExpression{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Assignment(SymbolicExpression expression, SymbolicExpression identifier) {
		// Expression = Identifier
		super("Assignment", expression, identifier);
		this.lhs = expression;
		this.rhs = identifier;
	}
}