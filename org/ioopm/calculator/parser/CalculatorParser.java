package org.ioopm.calculator.parser;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class CalculatorParser {
	private StreamTokenizer token;
	
	public CalculatorParser() {
		this.token.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :) 
        this.token.eolIsSignificant(true);
	}
	
	public void parse(String inputString) {
		this.token = new StreamTokenizer(new StringReader(inputString));
	}
}
