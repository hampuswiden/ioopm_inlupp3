package org.ioopm.calculator.ast;
import java.util.HashMap;

public class NamedConstant extends Atom {
	private String value;
	public static final HashMap<String, Double> namedConstants = new HashMap<>();
	
	static {
		NamedConstant.namedConstants.put("pi", Math.PI);
		NamedConstant.namedConstants.put("e", Math.E);
		NamedConstant.namedConstants.put("Answer", (double)42);
		NamedConstant.namedConstants.put("L", 6.022140857*Math.pow(10, 23));
	}
	
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
		return new Constant(NamedConstant.namedConstants.get(this.value));
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	} 
}