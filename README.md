# Inlupp 3

Instructions to build/run the program.
- `make` to build the program
- `make run` to build and run the calculator
- `make runparser` to build and run the parser
- `make runtest` to build and run the tests
- `make clean` to clear all the compiled `.class` files


## Design Choices

In order to prevent named constant from being redefined, we chose to extend the parser to handle potential conflict by throwing `SyntaxErrorException`s. When handling errors, the program will continue to run and await input from the user. However, an error message will be displayed in the terminal.