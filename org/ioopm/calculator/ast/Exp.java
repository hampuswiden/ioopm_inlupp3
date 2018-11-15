package org.ioopm.calculator.ast;

public class Exp extends Unary{
	private SymbolicExpression arg;	
	
	public Exp(SymbolicExpression arg) {
		super("Exp" ,arg);
	}

	public String getName() {
 		return "exp";
	}
}