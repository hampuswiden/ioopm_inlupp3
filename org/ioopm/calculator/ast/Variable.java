package org.ioopm.calculator.ast;

public class Variable extends Atom {
	private String value;
	
	public Variable(String value) {
		super(value);
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Variable) {
	        return this.equals((Variable) other);
	    } else {
	        return false;
	    }
	}

	// använda == eller equals?
	public boolean equals(Variable other) {
	    /// access a private field of other!
	    return this.value.equals(other.value);
	}
}