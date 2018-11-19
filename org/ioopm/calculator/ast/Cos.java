package org.ioopm.calculator.ast;

public class Cos extends Unary{
	private SymbolicExpression arg;	
	
	public Cos(SymbolicExpression arg) {
		super("Cos" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "cos";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Cos) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
	}

	public String toString() {
		return super.toString();
	}
}