package com.fererlab.aa.stack.tests;

import com.fererlab.aa.stack.linkedlist.StackLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class StackLinkedListTest {

	@Test
	public void add() {
		StackLinkedList<Integer> list = new StackLinkedList<>();
		assertEquals(list.size(), 0);
		int count = 4;
		for (int i = 0; i < count; i++) {
			list.add(i);
		}
		assertEquals(list.size(), count);
	}

	@Test
	public void remove() {
		StackLinkedList<Integer> list = new StackLinkedList<>();
		assertEquals(list.size(), 0);
		int count = 4;
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
		StackLinkedList<Integer> list = new StackLinkedList<>();
		Integer last = Integer.MAX_VALUE;
		list.add(1);
		list.add(2);
		list.add(last);
		assertEquals(list.getLast(), last);
		assertEquals(list.getLast(), last);
		assertEquals(list.getLast(), last);
	}


}
