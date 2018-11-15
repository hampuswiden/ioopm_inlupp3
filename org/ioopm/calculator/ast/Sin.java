package org.ioopm.calculator.ast;

public class Sin extends Unary{
	private SymbolicExpression arg;	
	
	public Sin(SymbolicExpression arg) {
		super("Sin" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "sin";
	}
}