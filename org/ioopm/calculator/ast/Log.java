package org.ioopm.calculator.ast;

public class Log extends Unary{
	private SymbolicExpression arg;
	
	public Log(SymbolicExpression arg) {
		super("Log" ,arg);
	}

	public String getName() {
 		return "log";
	}
}