package org.ioopm.calculator.ast;

public class Vars extends Command{
	private static final Vars theInstance = new Vars();

    private Vars() {}
    
    public static Vars instance() {
        return theInstance;
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
	    return this.instance().equals(other.instance());
	}

	public String getName() {
		return "Vars";
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}
