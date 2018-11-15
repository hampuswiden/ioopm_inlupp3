package org.ioopm.calculator.ast;

public class Vars extends Command{
	private String arg;	
	
	public Vars(String arg) {
		super(arg);
		this.arg = arg;
	}
}