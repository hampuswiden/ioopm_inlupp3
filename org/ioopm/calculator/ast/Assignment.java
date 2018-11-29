package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Assignment extends SymbolicExpression{
	/**
	 * The left hand side expression.
	 */
	private SymbolicExpression lhs;
	
	/**
	 * The right hand side expression.
	 */
	private SymbolicExpression rhs;
	
	/**
	 * Constructor for Assignment.
	 * @param expression SymbolicExpression for the expressions left hand side.
	 * @param identifier SymbolicExpression for the expressions right hand side.
	 * @since  1.0
	 */
	public Assignment(SymbolicExpression expression, SymbolicExpression identifier) {
		this.lhs = expression;
		this.rhs = identifier;
	}
	
	/**
	 * Gets the priority of the expression.
	 * @return Int, the priority of the expression.
	 * @since  1.0
	 */
	public int getPriority() {
		return 11;
	}
	
	/**
	 * Gets the name of the expression.
	 * @return String, the name of the expression.
	 * @since  1.0
	 */
	public String getName() {
		return "=";
	}
	
	/**
	 * Checks for equlity between the input expresison and Assignment.
	 * @param other Object to check equality for.
	 * @return true if argument is of type Assignment, and has the same sub-expressions on the same side.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Assignment) {
	        return this.equals((Assignment) other);
	    } else {
	        return false;
	    }
	}

	/**
	 * Checks for equlity between the input expresison and Assignment.
	 * @param other Object to checks equality for.
	 * @return true if argument has the same sub-expressions on the same side.
	 * @since  1.0
	 */
	public boolean equals(Assignment other) {
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
	}
	
	/**
	 * Converts the expression to a string.
	 * @return String, the expression in string format.
	 * @since  1.0
	 */
	public String toString() {
		String returnString = "";
		
		if(this.lhs.getPriority() < 10)
			returnString += "(" + this.lhs.toString() + ") ";
		else {
			returnString += this.lhs.toString() + " ";
		}
		
		returnString += this.getName() + " ";
		
		if(this.rhs.getPriority() < 10)
			returnString += "(" + this.rhs.toString() + ")";
		else {
			returnString += this.rhs.toString();
		}
		return returnString;
	}
	
	/**
	 * Evaluates the expression.
	 * @param vars Evironment where all variables are saved.
	 * @return SymbolicExpression that holds the evaluated expression.
	 * @since  1.0
	 */
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    vars.put((Variable) this.rhs, lhs);
	    return lhs;
	}
}