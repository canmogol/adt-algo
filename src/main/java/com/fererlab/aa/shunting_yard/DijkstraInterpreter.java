package com.fererlab.aa.shunting_yard;

import java.util.Stack;

/**
 * can
 */
public class DijkstraInterpreter {

	private Stack<String> operations = new Stack<>();
	private Stack<Double> values = new Stack<>();

	public Double interpret(String expression) {
		/*
		( 4 + 5 )
		9

		( 2 * 6 )
		12

		( ( 4 + 5 ) + ( 2 * 6 ) )
		( 9 + ( 2 * 6 ) )
		( 9 + 12 )
		21

		 */
		String[] expressions = expression.split(" ");
		for (String input : expressions) {
			switch (input) {
				case "(":
					break;
				case "+":
					this.operations.push("+");
					break;
				case "-":
					this.operations.push("-");
					break;
				case "*":
					this.operations.push("*");
					break;
				case "/":
					this.operations.push("/");
					break;
				case ")":
					// calculations
					double result = evaluate();
					this.values.push(result);
					break;
				default:
					this.values.push(Double.parseDouble(input));
					break;
			}
		}

		return this.values.pop();
	}

	private Double evaluate() {
		Double result = -1D;
		Double first, second;
		String operation = this.operations.pop();
		switch (operation) {
			case "+":
				result = this.values.pop() + this.values.pop();
				break;
			case "-":
				second = this.values.pop();
				first = this.values.pop();
				result = first - second;
				break;
			case "*":
				result = this.values.pop() * this.values.pop();
				break;
			case "/":
				second = this.values.pop();
				first = this.values.pop();
				result = first / second;
				break;
		}
		return result;
	}

}
