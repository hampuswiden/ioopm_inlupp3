package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public abstract class Unary extends SymbolicExpression{
	/**
 	* The argument to the unary function/operator
 	*/
	private SymbolicExpression arg;

	/**
 	* The constructor for Unary
 	* @param arg argument to the unary function
 	*/
	public Unary(SymbolicExpression arg) {
		this.arg = arg;
	}
	
	/**
 	* toString method for the class
 	* @return string format of the instance
 	*/
	@Override
	public String toString() {
		return this.getName() + "(" + this.arg.toString() + ")";
	}
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	    if (other instanceof Unary) {
	        return this.equals((Unary) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of Variable are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of Unary are equal.
 	*/
	public boolean equals(Unary other) {
		if (this.arg.equals(other.arg) && this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}
}