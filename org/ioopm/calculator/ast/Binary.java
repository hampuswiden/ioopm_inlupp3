package org.ioopm.calculator.ast;

public abstract class Binary extends Assignment{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Binary(String operator, SymbolicExpression lhs, SymbolicExpression rhs) {
		super(operator, lhs, rhs);
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