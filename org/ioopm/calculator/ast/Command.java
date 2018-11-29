package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public abstract class Command extends SymbolicExpression{
	
	/**
	 * The name of the command.
	 */
	private String arg;	
	
	/**
	 * Checks for equlity between the input Object and Command.
	 * @param other Object to check equality for.
	 * @return true if argument is of type Command.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Command) {
	        return this.equals((Command) other);
	    } else {
	        return false;
	    }
	}

	/**
	 * Checks for equlity between the input command and Command.
	 * @param other Object to check equality for.
	 * @return true if the two commands args are equal.
	 * @since  1.0
	 */
	public boolean equals(Command other) {
		return this.arg.equals(other.arg);
	}

	/**
	 * Converts the expression to a string.
	 * @return String, the command in string format.
	 * @since  1.0
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * Checks if expression is of type Command.
	 * @return true.
	 * @since  1.0
	 */
	public boolean isCommand() {
		return true;
	}
}