package org.ioopm.calculator.ast;

public class Exp extends Unary{
	private SymbolicExpression arg;	
	
	public Exp(SymbolicExpression arg) {
		super("Exp" ,arg);
		this.arg = arg;
	}

	public String getName() {
 		return "exp";
	}
}