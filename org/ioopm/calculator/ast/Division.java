package org.ioopm.calculator.ast;

public class Division extends Binary {
	private SymbolicExpression lhs;
	private SymbolicExpression rhs;
	
	public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
		super("Division",lhs, rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getName() {
 		return "/";
	}

	public int getPriority() {
    	return 8;
  	}
}