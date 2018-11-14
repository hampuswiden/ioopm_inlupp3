//package org.ioopm.calculator.ast;

public class Atom extends SymbolicExpression{
	private SymbolicExpression value;
	
	public Atom(String arg) {
		super("Variable", arg);
	}
	
	public Atom(double arg) {
		super("Constant", arg);
	}
}