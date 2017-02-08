package com.fererlab.aa.stack.tests;

import com.fererlab.aa.stack.arraylist.StackArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class StackArrayListTest {

	@Test
	public void add() {
		StackArrayList<Integer> list = new StackArrayList<>(3);
		assertEquals(list.size(), 0);
		int count = 4;
		for (int i = 0; i < count; i++) {
			list.add(i);
		}
		assertEquals(list.size(), count);
	}

	@Test
	public void remove() {
		StackArrayList<Integer> list = new StackArrayList<>(3);
		assertEquals(list.size(), 0);
		int count = 10;
		for (int i = 1; i <= count; i++) {
			list.add(i);
		}
		for (int i = count; i > 0; i--) {
			Integer popped = list.remove();
			assertEquals(popped, new Integer(i));
		}
	}

	@Test
	public void getLast() {
		StackArrayList<Integer> list = new StackArrayList<>(2);
		Integer last = Integer.MAX_VALUE;
		list.add(1);
		list.add(2);
		list.add(last);
		assertEquals(list.getLast(), last);
		assertEquals(list.getLast(), last);
		assertEquals(list.getLast(), last);
	}


}
