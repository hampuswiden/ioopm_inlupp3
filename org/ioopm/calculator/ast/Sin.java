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
	        return this.equals((Sin) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Sin other) {
	    /// access a private field of other!
	    return this.arg.equals(other.arg);
	}
}