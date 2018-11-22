package org.ioopm.calculator.ast;

public class Constant extends Atom {
	private double value;
	
	public Constant(double value) {
		this.value = value;
	}

	public boolean isConstant() {
		return true;
	}

	public double getValue() {
    	return this.value;
  	}
	
	public String toString() {
		return "" + this.value;
	}
	
	public String getName() {
		return "constant";
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
	
	public SymbolicExpression eval(Environment vars) { 
		return new Constant(this.getValue());
	}
}