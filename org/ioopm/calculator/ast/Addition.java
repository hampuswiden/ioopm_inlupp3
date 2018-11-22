package org.ioopm.calculator.ast;

public class Addition extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getName() {
 		return "+";
	}

	public int getPriority() {
    	return 4;
  	}
	
	public boolean equals(Object other) {
	    if (other instanceof Addition) {
	        return this.equals((Addition) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Addition other) {
	    /// access a private field of other!
		/// Checks both sides, since multiplication can be written two ways with same result
	    boolean[] sideCheck = {false, false};
	    
	    if(this.lhs.equals(other.lhs)) {
	    	sideCheck[0] = true;
	    }
	    else if(this.lhs.equals(other.rhs)) {
	    	sideCheck[1] = true;
	    }
	    
	    if(this.rhs.equals(other.lhs) && sideCheck[0]==false) {
	    	sideCheck[0] = true;
	    }
	    else if(this.rhs.equals(other.rhs) && sideCheck[1]==false) {
	    	sideCheck[1] = true;
	    }
	    
	    return sideCheck[0] && sideCheck[1]; 
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    SymbolicExpression rhs = this.rhs.eval(vars);
	    if (lhs.isConstant() && rhs.isConstant()) {
	    	return new Constant(lhs.getValue() + rhs.getValue());
	    } else {
	        return new Addition(lhs, rhs);
	    }
	}
}