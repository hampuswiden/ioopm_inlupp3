ast:
	javac -d classes org/ioopm/calculator/ast/*.java
parser: ast
	javac -d classes -classpath classes org/ioopm/calculator/parser/*.java
calculator: parser
	javac -d classes -classpath classes org/ioopm/calculator/Calculator.java
runparser: parser
	java -classpath classes org.ioopm.calculator.parser.CalculatorParser
run: calculator
	java -classpath classes org.ioopm.calculator.Calculator
clean:
	rm -rf classes
test: Test.java parser
	javac -d classes -classpath classes Test.java
runtest: test
	java -classpath classes -enableassertions:Test Test
