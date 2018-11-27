ast:
	javac -d classes org/ioopm/calculator/ast/*.java
parser: ast
	javac -d classes -classpath classes org/ioopm/calculator/parser/*.java
runparser: parser
	java -classpath classes org.ioopm.calculator.parser.CalculatorParser
clean:
	rm -rf classes
test: Test.java parser
	javac -d classes -classpath classes Test.java
runtest: test
	java -classpath classes -enableassertions:Test Test
