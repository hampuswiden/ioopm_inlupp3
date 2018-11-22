package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression{
	private SymbolicExpression arg;
	
	public Unary(SymbolicExpression arg) {
		this.arg = arg;
	}
	
	public String toString() {
		return this.getName() + "(" + this.arg.toString() + ")";
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