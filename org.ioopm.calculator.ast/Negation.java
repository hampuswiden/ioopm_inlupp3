//package org.ioopm.calculator.ast;

public class Negation extends Unary {
  private SymbolicExpression expression;
  
	public Negation(SymbolicExpression expression) {
		super(expression);
	}
}