package com.fererlab.aa.queue.tests;

import com.fererlab.aa.queue.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class QueueTest {

	public static final int ELEMENTS_QUEUED = 5;

	@Test
	public void testQueue() throws Exception {
		Queue<Integer> queue = new Queue<>();
		test(queue);
	}

	private void test(Queue<Integer> queue) {
		for (int i = 0; i < ELEMENTS_QUEUED; i++) {
			queue.enqueue(i);
		}

		assertEquals(queue.size(), ELEMENTS_QUEUED);

		for (int i = 0; i < ELEMENTS_QUEUED; i++) {
			assertEquals(queue.deque(), new Integer(i));
		}

	}

}