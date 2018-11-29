package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Constant extends Atom {
	/**
	 * The double value of the Constant.
	 */
	private double value;
	
	/**
	 * Constructor for Constant.
	 * @param value double for expression the Constant's value.
	 * @since  1.0
	 */
	public Constant(double value) {
		this.value = value;
	}

	/**
	 * Checks if expression is of type Constant.
	 * @return  true.
	 * @since  1.0
	 */
	public boolean isConstant() {
		return true;
	}

	/**
	 * Gets the value of the Constant.
	 * @return double, the value of the Constant.  
	 * @since  1.0
	 */
	public double getValue() {
    	return this.value;
  	}
	
	/**
	 * Converts the expression to a string.
	 * @return String, the expression in string format.
	 * @since  1.0
	 */
	public String toString() {
		return "" + this.value;
	}
	
	/**
	 * Gets the name of the expression.
	 * @return String, the name of the expression.
	 * @since  1.0
	 */
	public String getName() {
		return "constant";
	}
	
	/**
	 * Checks for equlity between the input expresison and Constant.
	 * @param other Object to check equality for.
	 * @return true if argument is of type Constant, and has the same value.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Constant) {
	        return this.equals((Constant) other);
	    } else {
	        return false;
	    }
	}

	/**
	 * Checks for equlity between the input expresison and Constant.
	 * @param other Object to checks equality for.
	 * @return true if argument has the same value.
	 * @since  1.0
	 */
	public boolean equals(Constant other) {
	    return this.value == other.value;
	}
	
	/**
	 * Evaluates the expression.
	 * @param vars Evironment where all variables are saved.
	 * @return SymbolicExpression that holds the evaluated expression.
	 * @since  1.0
	 */
	public SymbolicExpression eval(Environment vars) { 
		return new Constant(this.getValue());
	}
}