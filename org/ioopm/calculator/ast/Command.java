package org.ioopm.calculator.ast;

public abstract class Command extends SymbolicExpression{
	private String arg;	
	
	public Command(String arg) {
		super("Command", arg);
		this.arg = arg;
	}
}