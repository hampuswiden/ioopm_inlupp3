package org.ioopm.calculator.ast;

public abstract class Command extends SymbolicExpression{
	private String arg;	
	
	public Command(String arg) {
		super("Command", arg);
		this.arg = arg;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Command) {
	        return this.equals((Command) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Command other) {
	    /// access a private field of other!
		return this.arg.equals(other.arg);
	}

	public String toString() {
		return this.getName();
	}
}