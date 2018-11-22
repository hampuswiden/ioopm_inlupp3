package org.ioopm.calculator.ast;

public class Variable extends Atom {
	private String value;
	
	public Variable(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public String getName() {
		return "variable";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Variable) {
	        return this.equals((Variable) other);
	    } else {
	        return false;
	    }
	}

	// använda == eller equals?
	public boolean equals(Variable other) {
	    /// access a private field of other!
	    return this.value.equals(other.value);
	}
	
	public SymbolicExpression eval(Environment vars) {
		SymbolicExpression value =  vars.get(this);
		if (value instanceof SymbolicExpression)
		{
			return value;
		}
		return new Variable(this.value);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	} 
}