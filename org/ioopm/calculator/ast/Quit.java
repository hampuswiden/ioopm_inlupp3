package org.ioopm.calculator.ast;

public class Quit extends Command{
	private static final Quit theInstance = new Quit();

    private Quit() {}
    public static Quit instance() {
        return theInstance;
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
	    return true;
	}

	public String getName() {
		return "quit";
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}