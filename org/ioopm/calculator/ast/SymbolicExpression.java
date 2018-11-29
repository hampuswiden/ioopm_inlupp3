package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * @author      Jonathan Franzén, Hampus Widén
 * @version     1.0
 * @since       1.0
 */
public abstract class SymbolicExpression {
  /**
  * name of the ast class/instance
  */
  private String name;

  /**
  * list of arguments/subexpressions to the ast instance
  */ 
  private String[] subExpressions;

  /**
  * The constructor for SymbolicExpression
  */
  public SymbolicExpression() {

  }
  
  /**
  * The constructor for SymbolicExpression
  * @param name name of the ast class/instance
  * @param subExpressions list of arguments/subexpressions to the ast instance
  */
  public SymbolicExpression(String name, Object... subExpressions) {
    this.name = name;
    this.subExpressions = new String[subExpressions.length];
    for (int i = 0; i < subExpressions.length; ++i) {
      this.subExpressions[i] = subExpressions[i].toString();
    }
  }

  /**
  * toString method for the class
  * @return string format of the instance
  */
  @Override
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

  /**
  * Check whether the class/instance is constant.
  * @return whether it is constant.
  */
  public boolean isConstant() {
    return false;
  }

  /**
  * Gets the name of the class.
  * @return returns the name of the class.
  */
  public String getName() {
    throw new RuntimeException("getName() called on expression with no operator");
  }

  /**
  * Gets the priority of the class.
  * @return returns the priority of the class.
  */
  public int getPriority()
  {
    return 10;
  }

  /**
  * Gets the value of the class.
  * @throws RuntimeException since the SymbolicExpression class can't hold a value
  */
  public double getValue() {
    throw new RuntimeException("getValue() called on non-constant value");
  }

  /**
  * Test method which compares the string format of a SymbolicExpression with the expected string
  * @param expected the expected string format of the SymbolicExpression
  */
  public void testPrinting(String expected) {
    if (expected.equals("" + this)) {
      System.out.println("Passed: " + this);
    } 
    else {
      System.out.println("Error: expected '" + expected + "' but got '" + this + "'");
    }
  }
  
  /**
  * Test method which compares the evaluated value of a SymbolicExpression with the expected SymbolicExpression value
  * @param expected the expected SymbolicExpression of the evaluated SymbolicExpression
  * @param vars the environment which holds the variables
  */
  public void testEvaluating(SymbolicExpression expected, Environment vars) {
    SymbolicExpression r = this.eval(vars);
    SymbolicExpression e = expected.eval(vars);
    if (r.equals(e)) {
        System.out.println("Passed: " + r);
    } else {
        System.out.println("Error: expected '" + e + "' but got '" + r + "'");
    }
	}
  
  /**
  * Check whether two instances are equal.
  * @param other instance to be compared with.
  * @return whether the two instances are equal.
  */
  @Override
  public boolean equals(Object other) {
    return false;
  }
  
  /**
  * Check whether two instances are equal
  * @param vars the environment which holds the variables
  */
  public abstract SymbolicExpression eval(Environment vars);

  /**
  * Check whether the class/instance is a command
  * @return whether the class/instance is a commaand
  */
  public boolean isCommand() {
    return false;
  }
} 