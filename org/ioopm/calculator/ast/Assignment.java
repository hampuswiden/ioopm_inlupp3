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
	
	public int getPriority() {
		return 11;
	}
	
	public String getName() {
		return "=";
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
	
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    vars.put((Variable) rhs, lhs);
	    return new Assignment(lhs, rhs);
	}
}