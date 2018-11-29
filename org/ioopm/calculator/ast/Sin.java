package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Sin extends Unary{
	/**
  * The argument to the sin function
  */
	private SymbolicExpression arg;	
	
	/**
 	* The constructor for Sin
 	* @param arg argument to the sin function
 	*/
	public Sin(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	/**
  * Gets the name of the class.
  * @return returns the name of the class.
  */
  @Override
	public String getName() {
 		return "sin";
	}
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	    if (other instanceof Sin) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
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
 	* Evaluates the SymbolicExpression of type Sin.
 	* @param vars the environment where all variables are saved.
 	* @return the evaluated value
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression arg = this.arg.eval(vars);
	    if (arg.isConstant()) {
	        return new Constant(Math.sin(arg.getValue()));
	    } else {
	        return new Sin(arg);
	    }
	}
}