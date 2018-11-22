package org.ioopm.calculator.ast;

public class Cos extends Unary{
	private SymbolicExpression arg;	
	
	public Cos(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	public String getName() {
 		return "cos";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Cos) {
	        return super.equals(other);
	    } else {
	        return false;
	    }
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    SymbolicExpression arg = this.arg.eval(vars);
	    if (arg.isConstant()) {
	        return new Constant(Math.cos(arg.getValue()));
	    } else {
	        return new Cos(arg);
	    }
	}
}