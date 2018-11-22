package org.ioopm.calculator.ast;
import java.util.HashMap;

public abstract class SymbolicExpression {
  private String name; 
  private String[] subExpressions;

  public SymbolicExpression() {

  }
  
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

  public boolean isConstant() {
    return false;
  }

  public String getName() {
    throw new RuntimeException("getName() called on expression with no operator");
  }

  public int getPriority()
  {
    return 10;
  }

  public double getValue() {
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
  
  public void testEvaluating(SymbolicExpression expected, Environment vars) {
    SymbolicExpression r = this.eval(vars);
    SymbolicExpression e = expected.eval(vars);
    if (r.equals(e)) {
        System.out.println("Passed: " + r);
    } else {
        System.out.println("Error: expected '" + e + "' but got '" + r + "'");
    }
	}
  
  public boolean equals(Object other) {
    return false;
  }
  
  public abstract SymbolicExpression eval(Environment vars);

  public boolean isCommand() {
    return false;
  }
  
}