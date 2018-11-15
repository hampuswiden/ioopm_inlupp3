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
}