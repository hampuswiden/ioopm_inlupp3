package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		String returnString = "";
		
		if(this.lhs.getPriority() < 10)
			returnString += "(" + this.lhs.toString() + ") ";
		else {
			returnString += this.lhs.toString() + " ";
		}
		
		returnString += this.getName() + " ";
		
		if(this.rhs.getPriority() < 10)
			returnString += "(" + this.rhs.toString() + ")";
		else {
			returnString += this.rhs.toString();
		}
		return returnString;
	}
}