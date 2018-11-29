package org.ioopm.calculator.ast;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public class Subtraction extends Binary {
	/**
  	* the left hand side of the expression
  	*/
	private SymbolicExpression lhs;

	/**
  	* the right hand side of the expression
  	*/
	private SymbolicExpression rhs;
	
	/**
  	* The constructor for Subtraction
  	* @param lhs the left hand side of the expression
  	* @param rhs the right hand side of the expression
  	*/
	public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
		super(lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/**
  	* Gets the name of the class.
  	* @return returns the name of the class.
  	*/
  	@Override
	public String getName() {
 		return "-";
	}

	/**
  	* Gets the priority of the class.
  	* @return returns the priority of the class.
  	*/
  	@Override
	public int getPriority() {
    	return 4;
  	}
	
	/**
 	* Check whether two instances are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances are equal.
 	*/
	public boolean equals(Object other) {
	    if (other instanceof Subtraction) {
	        return this.equals((Subtraction) other);
	    } else {
	        return false;
	    }
	}

	/**
 	* Check whether two instances of Variable are equal.
 	* @param other instance to be compared with.
 	* @return whether the two instances of Unary are equal.
 	*/
	public boolean equals(Subtraction other) {
		return (this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs));
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
 	* Evaluates the SymbolicExpression of type Subtraction.
 	* @param vars the environment where all variables are saved.
 	* @return the evaluated value
 	*/
 	@Override
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression lhs = this.lhs.eval(vars);
	    SymbolicExpression rhs = this.rhs.eval(vars);
	    if (lhs.isConstant() && rhs.isConstant()) {
	    	return new Constant(lhs.getValue() - rhs.getValue());
	    } else {
	        return new Subtraction(lhs, rhs);
	    }
	}
}