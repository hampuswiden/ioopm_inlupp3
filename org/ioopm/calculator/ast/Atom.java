package org.ioopm.calculator.ast;

public abstract class Atom extends SymbolicExpression{
	private String var;
	private double value;
	
	public Atom(String arg) {
		super("Variable", arg);
		this.var = arg;
	}
	
	public Atom(double arg) {
		super("Constant", arg);
		this.value = arg;
	}
}