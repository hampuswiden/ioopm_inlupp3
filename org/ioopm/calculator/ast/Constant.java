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
}