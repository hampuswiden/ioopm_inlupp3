package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {
  private String name; 
  private String[] subExpressions;
  
 /// The second argument allows us to pass in 0 or more arguments
  public SymbolicExpression(String name, Object... subExpressions) {
    this.name = name;
    this.subExpressions = new String[subExpressions.length];
    for (int i = 0; i < subExpressions.length; ++i) {
      this.subExpressions[i] = subExpressions[i].toString();
    }
  }

  /// Returns e.g., "Constant(42)" if name is "Constant" and subExpressions is ["42"]
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.name);
    sb.append("(");
    for (int i = 1; i < this.subExpressions.length; ++i) {
      sb.append(this.subExpressions[i]);
      if (i + 1 < subExpressions.length) {
        sb.append(", ");
      }
    }
    sb.append(")");
    return sb.toString(); 
  }

  public Boolean isConstant() {
    return false;
  }

  public String getName() {
    throw new RuntimeException("getName() called on expression with no operator");
  }

  public int getPriority() {
    return 10;
  }

  public Double getValue() {
    throw new RuntimeException("getValue() called on non-constant value");
  }

  //Test
  public void testPrinting(String expected) {
    if (expected.equals("" + this)) {
      System.out.println("Passed: " + this);
    } 
    else {
      System.out.println("Error: expected '" + expected + "' but got '" + this + "'");
    }
  }
  
  public boolean equals(Object other) {
	  return false;
  }
  
  public SymbolicExpression eval() {
	  return new Constant(5);
  }
  
  public void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
	    SymbolicExpression r = e.eval();
	    if (r.equals(expected)) {
	        System.out.println("Passed: " + e);
	    } else {
	        System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
	    }
	}
}