package org.ioopm.calculator.ast;

public class Cos extends Unary{
	private SymbolicExpression arg;	
	
	public Cos(SymbolicExpression arg) {
		super("Cos" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "cos";
	}
}