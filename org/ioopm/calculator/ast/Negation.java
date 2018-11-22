package org.ioopm.calculator.ast;

public class Negation extends Unary {
  private SymbolicExpression arg;
  
	public Negation(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}
	
	public String getName() {
 		return "negation";
	}
	
	public String toString() {
		return super.toString();
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Negation) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
	}
	
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression arg = this.arg.eval(vars);
	    if (arg.isConstant()) {
	        return new Constant(-arg.getValue());
	    } else {
	        return new Negation(arg);
	    }
	}
}