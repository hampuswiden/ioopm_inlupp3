package org.ioopm.calculator.ast;

public class Sin extends Unary{
	private SymbolicExpression arg;	
	
	public Sin(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	public String getName() {
 		return "sin";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Sin) {
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
	        return new Constant(Math.sin(arg.getValue()));
	    } else {
	        return new Sin(arg);
	    }
	}
}