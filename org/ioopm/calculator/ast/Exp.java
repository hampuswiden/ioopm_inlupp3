package org.ioopm.calculator.ast;

public class Exp extends Unary{
	private SymbolicExpression arg;	
	
	public Exp(SymbolicExpression arg) {
		super("Exp" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "exp";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Exp) {
	        return this.equals((Exp) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Exp other) {
	    /// access a private field of other!
	    return this.arg.equals(other.arg);
	}
}