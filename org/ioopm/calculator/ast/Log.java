package org.ioopm.calculator.ast;

public class Log extends Unary{
	private SymbolicExpression arg;
	
	public Log(SymbolicExpression arg) {
		super("Log" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "log";
	}
}