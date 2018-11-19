package org.ioopm.calculator.ast;

public class Quit extends Command{
	private String arg;	
	
	public Quit(String arg) {
		super(arg);
		this.arg = arg;
	}
	
	public boolean equals(Object other) {
	    if (other instanceof Quit) {
	        return this.equals((Quit) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Quit other) {
	    /// access a private field of other!
	    return this.arg.equals(other.arg);
	}

	public String getName() {
		return "Quit";
	}

	public String toString() {
		return super.toString();
	}
}