package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Negation extends Unary {
  
 	/**
	* The argument to the negation function/operator
	*/
	private SymbolicExpression arg;
  
  /**
 	* The constructor for Negation
 	* @param arg argument to the negation function/operator
 	*/
	public Negation(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}
	
	/**
  * Gets the name of the class.
  * @return returns the name of the class.
  */
  @Override
	public String getName() {
 		return "negation";
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
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
 	@Override
	public boolean equals(Object other) {
	  if (other instanceof Negation) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
	}
	
	/**
 	* Evaluates the SymbolicExpression of type Negation.
 	* @param vars the environment where all variables are saved.
 	* @return the evaluated value
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression arg = this.arg.eval(vars);
	    if (arg.isConstant()) {
	        return new Constant(-arg.getValue());
	    } else {
	        return new Negation(arg);
	    }
	}
}