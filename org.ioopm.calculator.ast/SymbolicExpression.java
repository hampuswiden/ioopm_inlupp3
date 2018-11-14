//package org.ioopm.calculator.ast; /// could place this in parser *for now*

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
  public String toString(String msg) {
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

}