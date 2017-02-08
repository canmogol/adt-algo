package com.fererlab.aa.stack.tests;

import com.fererlab.aa.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class StackTest {

	@Test
	public void push() {
		Stack<Integer> stackLinked = new Stack<>();
		pushTest(stackLinked);
		Stack<Integer> stackArray = new Stack<>();
		pushTest(stackArray);
	}

	private void pushTest(Stack<Integer> stack) {
		int current = Integer.MAX_VALUE;
		stack.push(current);
		int popped = stack.pop();
		assertEquals(popped, current);
	}

	@Test
	public void multiplePush() {
		Stack<Integer> stackLinked = new Stack<>();
		multiplePushTest(stackLinked);
		Stack<Integer> stackArray = new Stack<>();
		multiplePushTest(stackArray);
	}

	private void multiplePushTest(Stack<Integer> stack) {
		int last = Integer.MAX_VALUE;
		int[] integers = {1, 2, 3, last};
		for (Integer i : integers) {
			stack.push(i);
		}
		int popped = stack.pop();
		assertEquals(popped, last);
	}

	@Test
	public void peek() {
		Stack<Integer> stackLinked = new Stack<>();
		peekTest(stackLinked);
		Stack<Integer> stackArray = new Stack<>();
		peekTest(stackArray);
	}

	private void peekTest(Stack<Integer> stack) {
		Integer last = Integer.MAX_VALUE;
		stack.push(1);
		stack.push(2);
		stack.push(last);
		assertEquals(stack.peek(), last);
		assertEquals(stack.peek(), last);
		assertEquals(stack.peek(), last);
	}

}
