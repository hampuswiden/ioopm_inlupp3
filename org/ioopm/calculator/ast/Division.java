package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Division extends Binary {
	/**
	 * The left hand side expression.
	 */
	private SymbolicExpression lhs;
	
	/**
	 * The right hand side expression.
	 */
	private SymbolicExpression rhs;
	
	/**
	 * Constructor for Division.
	 * @param lhs SymbolicExpression for the expressions left hand side.
	 * @param rhs SymbolicExpression for the expressions right hand side.
	 * @since  1.0
	 */
	public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/**
	 * Gets the name of the expression.
	 * @return String, the name of the expression.
	 * @since  1.0
	 */
	public String getName() {
 		return "/";
	}

	/**
	 * Gets the priority of the expression.
	 * @return Int, the priority of the expression.
	 * @since  1.0
	 */
	public int getPriority() {
    	return 8;
  	}
	
	/**
	 * Checks for equlity between the input expresison and Division.
	 * @param other Object to check equality for.
	 * @return true if argument is of type Division, and has the same sub-expressions on the same side.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Division) {
	        return this.equals((Division) other);
	    } else {
	        return false;
	    }
	}

	/**
	 * Checks for equlity between the input expresison and Division.
	 * @param other Object to checks equality for.
	 * @return true if argument has the same sub-expressions on the same side.
	 * @since  1.0
	 */
	public boolean equals(Division other) {
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
	}

	/**
	 * Converts the expression to a string.
	 * @return String, the expression in string format.
	 * @since  1.0
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * Evaluates the expression.
	 * @param vars Evironment where all variables are saved.
	 * @return SymbolicExpression that holds the evaluated expression.
	 * @since  1.0
	 */
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    SymbolicExpression rhs = this.rhs.eval(vars);
	    if (lhs.isConstant() && rhs.isConstant()) {
	    	return new Constant(lhs.getValue() / rhs.getValue());
	    } else {
	        return new Division(lhs, rhs);
	    }
	}
}