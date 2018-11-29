package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Variable extends Atom {
	/**
 	* The name of the variable
 	*/
	private String value;
	
	/**
 	* The constructor for Variable
 	* @param value name of the new Variable instance.
 	*/
	public Variable(String value) {
		this.value = value;
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
		return "variable";
	}
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
	public boolean equals(Object other) {
	    if (other instanceof Variable) {
	        return this.equals((Variable) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of Variable are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of Variable are equal.
 	*/
	public boolean equals(Variable other) {
	    return this.value.equals(other.value);
	}
	
	/**
 	* Evaluates the SymbolicExpression of type Variable.
 	* @param vars the environment where all variables are saved.
 	* @return the evaluated value
 	*/
	public SymbolicExpression eval(Environment vars) {
		SymbolicExpression value =  vars.get(this);
		if (value instanceof SymbolicExpression)
		{
			return value;
		}
		return new Variable(this.value);
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