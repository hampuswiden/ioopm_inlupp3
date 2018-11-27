package org.ioopm.calculator.ast;

public class Assignment extends SymbolicExpression{
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Assignment(SymbolicExpression expression, SymbolicExpression identifier) {
		// Expression = Identifier
		this.lhs = expression;
		this.rhs = identifier;
	}
	
	public int getPriority() {
		return 11;
	}
	
	public String getName() {
		return "=";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Assignment) {
	        return this.equals((Assignment) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Assignment other) {
	    /// access a private field of other!
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
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
	    vars.put((Variable) this.rhs, lhs);
	    return lhs;
	}
}