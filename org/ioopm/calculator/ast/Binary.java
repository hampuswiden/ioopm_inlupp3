package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public abstract class Binary extends SymbolicExpression{
	/**
	 * The left hand side expression.
	 */
	private SymbolicExpression lhs;
	
	/**
	 * The right hand side expression.
	 */
	private SymbolicExpression rhs;
	
	/**
	 * Constructor for Binary.
	 * @param lhs SymbolicExpression for the expressions left hand side.
	 * @param rhs SymbolicExpression for the expressions right hand side.
	 * @since  1.0
	 */
	public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
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
}