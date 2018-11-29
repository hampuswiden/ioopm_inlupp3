package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Quit extends Command{
	/**
 	* The singleton Quit instantiated in theInstance
 	*/
	private static final Quit theInstance = new Quit();
	/**
	* Constructor for Quit
 	*/
    private Quit() {}

    /**
 	* Method to get the "theInstance" field since it's private.
 	* @return the only instance of Quit.
 	*/
    public static Quit instance() {
        return theInstance;
    }
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	    if (other instanceof Quit) {
	        return this.equals((Quit) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of Quit are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of Quit are equal.
 	*/
	public boolean equals(Quit other) {
	    return true;
	}

	/**
 	* Gets the name of the class.
 	* @return returns the name of the class.
 	*/
 	@Override
	public String getName() {
		return "quit";
	}

	/**
 	* toString method for the class
 	* @return string format of the instance
 	*/
	@Override
	public String toString() {
		return super.toString();
	}
	
	/**
 	* Evaluates the SymbolicExpression of type Quit.
 	* @param vars the environment where all variables are saved.
 	* @throws RuntimeException since Quit can't be evaluated.
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}