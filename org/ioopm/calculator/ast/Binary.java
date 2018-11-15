package org.ioopm.calculator.ast;

public abstract class Binary extends Assignment{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Binary(String operator, SymbolicExpression lhs, SymbolicExpression rhs) {
		super(operator, lhs, rhs);
	}
	
	public String toString() {
		return this.lhs.toString() + " " + this.getName() + " " + this.rhs.toString();
	}
}