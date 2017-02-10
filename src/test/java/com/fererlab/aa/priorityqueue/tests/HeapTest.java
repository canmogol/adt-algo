package com.fererlab.aa.priorityqueue.tests;

import com.fererlab.aa.priorityqueue.Heap;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * can
 */
public class HeapTest {

	@Test
	public void testOffer() throws Exception {
		Heap<Integer> heap = new Heap<>();
		heap.offer(4);
		Assert.assertEquals(new Integer(4), heap.peek());
		heap.offer(6);
		Assert.assertEquals(new Integer(6), heap.peek());
		heap.offer(5);
		Assert.assertEquals(new Integer(6), heap.peek());
	}

	@Test
	public void testPop() throws Exception {
		Heap<Integer> heap = new Heap<>();
		heap.offer(20);
		heap.offer(10);
		heap.offer(30);
		heap.offer(5);
		heap.offer(15);
		heap.offer(25);
		heap.offer(35);
		Assert.assertEquals(new Integer(35), heap.peek());

		Integer root = heap.pop();
		Assert.assertEquals(new Integer(35), root);
		Assert.assertEquals(new Integer(30), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(30), root);
		Assert.assertEquals(new Integer(25), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(25), root);
		Assert.assertEquals(new Integer(20), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(20), root);
		Assert.assertEquals(new Integer(15), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(15), root);
		Assert.assertEquals(new Integer(10), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(10), root);
		Assert.assertEquals(new Integer(5), heap.peek());

		root = heap.pop();
		Assert.assertEquals(new Integer(5), root);
		Assert.assertEquals(null, heap.peek());

	}


	@Test
	public void testSort() throws Exception {
		Heap<Integer> heap = new Heap<>();
		heap.offer(20);
		heap.offer(10);
		heap.offer(30);
		heap.offer(5);
		heap.offer(15);
		heap.offer(25);
		heap.offer(35);

		List<Integer> sorted = Heap.sort(heap);
		Assert.assertArrayEquals(
			sorted.toArray(new Integer[sorted.size()]),
			new Integer[]{
				35, 30, 25, 20, 15, 10, 5
			}
		);

	}
}