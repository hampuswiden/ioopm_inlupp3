package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class NamedConstant extends Atom {
	/**
	* the name of the constant
	*/
	private String value;

	/**
	* the hashmap where all (constant, value) pairs are stored
	*/
	public static final HashMap<String, Double> namedConstants = new HashMap<>();
	
	/**
  	* Inserts some constants into the hashmap
  	*/
	static {
		NamedConstant.namedConstants.put("pi", Math.PI);
		NamedConstant.namedConstants.put("e", Math.E);
		NamedConstant.namedConstants.put("Answer", (double)42);
		NamedConstant.namedConstants.put("L", 6.022140857*Math.pow(10, 23));
	}
	
	/**
 	* The constructor for NamedConstant
 	* @param value name of the constant
 	*/
	public NamedConstant(String value) {
		this.value = value;
	}
	
	/**
 	* Check whether the class/instance is constant.
 	* @return whether it is constant.
  	*/
	@Override
	public boolean isConstant() {
		return true;
	}
	
	/**
 	* toString method for the class
 	* @return string format of the instance
 	*/
	@Override
	public String toString() {
		return this.value;
	}
	
	/**
  	* Gets the name of the class.
  	* @return returns the name of the class.
  	*/
  	@Override
	public String getName() {
		return "named constant";
	}
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	    if (other instanceof NamedConstant) {
	        return this.equals((NamedConstant) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of NamedConstant are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of NamedConstant are equal.
 	*/
	public boolean equals(NamedConstant other) {
	    return this.value.equals(other.value);
	}
	
	/**
 	* Evaluates the SymbolicExpression of type NamedConstant.
 	* @param vars the environment where all variables are saved.
 	* @return the evaluated value
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
		return new Constant(NamedConstant.namedConstants.get(this.value));
	}

	/**
 	* Calculates a hashcode for the instance.
 	* @return the hashcode
 	*/
	@Override
	public int hashCode() {
		return this.value.hashCode();
	} 
}