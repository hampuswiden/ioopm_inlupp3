package org.ioopm.calculator.ast;

public class Clear extends Command{
	private static final Clear theInstance = new Clear();

    private Clear() {}
    public static Clear instance() {
        return theInstance;
    }
	
	public boolean equals(Object other) {
	    if (other instanceof Clear) {
	        return this.equals((Clear) other);
	    } else {
	        return false;
	    }
	}

	public boolean equals(Clear other) {
	    /// access a private field of other!
	    return true;
	}

	public String getName() {
		return "Clear";
	}

	public String toString() {
		return super.toString();
	}
	
	public SymbolicExpression eval(Environment vars) {
	    throw new RuntimeException("eval called on command");
	  }
}