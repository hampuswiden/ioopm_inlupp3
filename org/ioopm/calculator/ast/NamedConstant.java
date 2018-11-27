package org.ioopm.calculator.ast;

public class NamedConstant extends Atom {
	private String value;
	
	public NamedConstant(String value) {
		this.value = value;
	}
	
	public boolean isConstant() {
		return true;
	}
	
	public String toString() {
		return this.value;
	}
	
	public String getName() {
		return "named constant";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof NamedConstant) {
	        return this.equals((NamedConstant) other);
	    } else {
	        return false;
	    }
	}

	// använda == eller equals?
	public boolean equals(NamedConstant other) {
	    /// access a private field of other!
	    return this.value.equals(other.value);
	}
	
	public SymbolicExpression eval(Environment vars) {
		SymbolicExpression value =  vars.get(this);
		if (value instanceof SymbolicExpression)
		{
			return value;
		}
		return new NamedConstant(this.value);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	} 
}