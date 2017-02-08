package com.fererlab.aa.stack.tests;

import com.fererlab.aa.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * can
 */
public class StackFlowTest {

	private static final Integer fiftyFive = 55;
	private static final Integer sixtySix = 66;
	private static final Integer seventySeven = 77;
	private static final Integer eightyEight = 88;

	@Test
	public void addRemoveFlow(){

		Stack<Integer> stack = new Stack<>(5);
		assertEquals(stack.size(), 0);

		stack.push(fiftyFive);
		assertEquals(stack.size(), 1);

		stack.push(sixtySix);
		assertEquals(stack.size(), 2);

		stack.push(seventySeven);
		assertEquals(stack.size(), 3);

		stack.push(eightyEight);
		assertEquals(stack.size(), 4);


		assertEquals(stack.peek(), eightyEight);
		assertEquals(stack.peek(), eightyEight);
		assertEquals(stack.peek(), eightyEight);
		assertEquals(stack.peek(), eightyEight);


		assertEquals(stack.pop(), eightyEight);
		assertEquals(stack.pop(), seventySeven);
		assertEquals(stack.pop(), sixtySix);
		assertEquals(stack.pop(), fiftyFive);
	}

}
