package org.ioopm.calculator.ast;

public class Quit extends Command{
	private String arg;	
	
	public Quit(String arg) {
		super(arg);
		this.arg = arg;
	}
}