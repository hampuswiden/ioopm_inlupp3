all:
	javac -d classes org/ioopm/calculator/ast/*.java
run:
	java -cp classes org/ioopm/calculator/Calculator
clean:
	rm -rf classes
test:
	javac -d classes -classpath classes Test.java
runtest:
	cd classes; \
	java Test; \
	cd ..