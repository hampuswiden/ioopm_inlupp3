package org.ioopm.calculator.ast;

public class Log extends Unary{
	private SymbolicExpression arg;
	
	public Log(SymbolicExpression arg) {
		super(arg);
		this.arg = arg;
	}

	public String getName() {
 		return "log";
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Log) {
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
	        return new Constant(Math.log(arg.getValue()));
	    } else {
	        return new Log(arg);
	    }
	}
}