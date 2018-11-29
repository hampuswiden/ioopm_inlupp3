package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Vars extends Command{
	/**
 	* The singleton Vars instantiated in theInstance
 	*/
	private static final Vars theInstance = new Vars();

	/**
	* Constructor for Vars
 	*/
    private Vars() {}
    
    /**
 	* Method to get the "theInstance" field since it's private.
 	* @return the only instance of Vars.
 	*/
    public static Vars instance() {
        return theInstance;
    }
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	    if (other instanceof Vars) {
	        return this.equals((Vars) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of Vars are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of Vars are equal.
 	*/
	public boolean equals(Vars other) {
	    return true;
	}

	/**
 	* Gets the name of the class.
 	* @return returns the name of the class.
 	*/
 	@Override
	public String getName() {
		return "vars";
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
 	* Evaluates the SymbolicExpression of type Vars.
 	* @param vars the environment where all variables are saved.
 	* @throws RuntimeException since Vars can't be evaluated.
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}
