package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Subtraction", lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getName() {
 		return "-";
	}

	public int getPriority() {
    	return 4;
  	}
	
	public boolean equals(Object other) {
	    if (other instanceof Subtraction) {
	        return this.equals((Subtraction) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Subtraction other) {
	    /// access a private field of other!
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    SymbolicExpression rhs = this.rhs.eval(vars);
	    if (lhs.isConstant() && rhs.isConstant()) {
	    	return new Constant(lhs.getValue() - rhs.getValue());
	    } else {
	        return new Subtraction(lhs, rhs);
	    }
	}
}