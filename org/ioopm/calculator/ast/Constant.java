package org.ioopm.calculator.ast;

public class Constant extends Atom{
	private double value;
	
	public Constant(double value) {
		super(value);
		this.value = value;
	}

	public Boolean isConstant() {
		return true;
	}

	public Double getValue() {
    	return this.value;
  	}
	
	public String toString() {
		return "" + this.value;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Constant) {
	        return this.equals((Constant) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Constant other) {
	    /// access a private field of other!
	    return this.value == other.value;
	}
}