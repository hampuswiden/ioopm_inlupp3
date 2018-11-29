package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Clear extends Command{
	/**
	 * The final instance of Clear
	 */
	private static final Clear theInstance = new Clear();

	/**
	 * Private constructor for Clear.
	 * @since  1.0
	 */
    private Clear() {}
    
    /**
	 * Instance of Clear.
	 * @return The instance of Clear
	 * @since  1.0
	 */
    public static Clear instance() {
        return theInstance;
    }
	
    /**
	 * Checks for equlity between the input Object and Clear.
	 * @param  Object to check equality for.
	 * @return true if argument is of type Clear.
	 * @since  1.0
	 */
	public boolean equals(Object other) {
	    if (other instanceof Clear) {
	        return this.equals((Clear) other);
	    } else {
	        return false;
	    }
	}

	/**
	 * Checks for equlity between the input command and Clear.
	 * @param  Object to check equality for.
	 * @return true.
	 * @since  1.0
	 */
	public boolean equals(Clear other) {
	    return true;
	}

	/**
	 * Gets the name of the command.
	 * @return String, the name of the command. 
	 * @since  1.0
	 */
	public String getName() {
		return "Clear";
	}

	/**
	 * Converts the expression to a string.
	 * @return String, the command in string format.
	 * @since  1.0
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * Tries to evaluate Clear and throws an error.
	 * @param  Evironment where all variables are saved.
	 * @throws Throws and error since commands can't be evaluated.
	 * @since  1.0
	 */
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}