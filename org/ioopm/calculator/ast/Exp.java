package org.ioopm.calculator.ast;

public class Exp extends Unary{
	private SymbolicExpression arg;	
	
	public Exp(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	public String getName() {
 		return "exp";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Exp) {
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
	        return new Constant(Math.exp(arg.getValue()));
	    } else {
	        return new Exp(arg);
	    }
	}
}