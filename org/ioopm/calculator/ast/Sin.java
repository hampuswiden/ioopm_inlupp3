package org.ioopm.calculator.ast;

public class Sin extends Unary{
	private SymbolicExpression arg;	
	
	public Sin(SymbolicExpression arg) {
		super("Sin" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "sin";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Sin) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
	}

	public String toString() {
		return super.toString();
	}
}