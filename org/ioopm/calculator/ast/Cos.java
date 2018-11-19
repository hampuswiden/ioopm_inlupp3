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
	        return this.equals((Cos) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Cos other) {
	    /// access a private field of other!
		return this.arg.equals(other.arg);
	}
}