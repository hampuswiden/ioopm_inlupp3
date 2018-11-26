compile_ast:
	javac -d classes org/ioopm/calculator/ast/*.java
compile_parser:
	javac -d classes -classpath classes org/ioopm/calculator/parser/*.java
run: compile_ast compile_parser
	# java -cp classes org/ioopm/calculator/Calculator
	java -classpath classes org.ioopm.calculator.parser.CalculatorParser
clean:
	rm -rf classes
test:
	javac -d classes -classpath classes Test.java
runtest:
	cd classes; \
	java Test; \
	cd ..
