package org.ioopm.calculator.ast;

public class Negation extends Unary {
  private SymbolicExpression expression;
  
	public Negation(SymbolicExpression expression) {
		super("Negation", expression);
		this.expression = expression;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Negation) {
	        return this.equals((Negation) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Negation other) {
	    /// access a private field of other!
	    return this.expression.equals(other.expression);
	}
}