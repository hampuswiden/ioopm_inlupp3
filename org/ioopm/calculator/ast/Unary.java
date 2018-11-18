package org.ioopm.calculator.ast;

public abstract class Unary extends Assignment{
	private SymbolicExpression arg;
	
	public Unary(String function, SymbolicExpression arg) {
		super(function, arg);
		this.arg = arg;
	}
	
	public String toString() {
		return this.arg.getName() + "(" + this.arg.toString() + ")";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Unary) {
	        return this.equals((Unary) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Unary other) {
	    /// access a private field of other!
		//kanske kan ta bort name check?
		if (this.arg.equals(other.arg) && this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}
}