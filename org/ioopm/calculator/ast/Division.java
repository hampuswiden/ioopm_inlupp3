package org.ioopm.calculator.ast;

public class Division extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Division",lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getName() {
 		return "/";
	}

	public int getPriority() {
    	return 8;
  	}
	
	public boolean equals(Object other) {
	    if (other instanceof Division) {
	        return this.equals((Division) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Division other) {
	    /// access a private field of other!
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
	}

	public String toString() {
		return super.toString();
	}
}