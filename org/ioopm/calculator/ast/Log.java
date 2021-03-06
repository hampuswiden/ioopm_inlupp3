package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Log extends Unary{
	/**
	 * The expression Log holds.
	 */
	private SymbolicExpression arg;
	
	/**
	 * Constructor for Log.
	 * @param arg SymbolicExpression that the expression holds.
	 * @since  1.0
	 */
	public Log(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	/**
	 * Gets the name of the expression.
	 * @return String, the name of the expression.
	 * @since  1.0
	 */
	public String getName() {
 		return "log";
	}
	
	/**
	 * Checks for equlity between the input expresison and Log.
	 * @param other Object to check equality for.
	 * @return true if argument is of type Log, and holds the same subexpression.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Log) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
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
	    SymbolicExpression arg = this.arg.eval(vars);
	    if (arg.isConstant()) {
	        return new Constant(Math.log(arg.getValue()));
	    } else {
	        return new Log(arg);
	    }
	}
}