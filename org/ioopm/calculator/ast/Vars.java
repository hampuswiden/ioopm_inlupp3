package org.ioopm.calculator.ast;

public class Vars extends Command{
	private String arg;	
	
	public Vars(String arg) {
		super(arg);
		this.arg = arg;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Vars) {
	        return this.equals((Vars) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Vars other) {
	    /// access a private field of other!
	    return this.arg.equals(other.arg);
	}
}