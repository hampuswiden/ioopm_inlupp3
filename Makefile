calculator: parser
	javac -d classes -classpath classes org/ioopm/calculator/Calculator.java
run: calculator
	java -classpath classes org.ioopm.calculator.Calculator
parser: ast
	javac -d classes -classpath classes org/ioopm/calculator/parser/*.java
runparser: parser
	java -classpath classes org.ioopm.calculator.parser.CalculatorParser
ast:
	javac -d classes org/ioopm/calculator/ast/*.java
test: Test.java parser
	javac -d classes -classpath classes Test.java
runtest: test
	java -classpath classes -enableassertions:Test Test
clean:
	rm -rf classes
