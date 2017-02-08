package com.fererlab.aa.tree.bst.tests;

import com.fererlab.aa.tree.bst.BinarySearchTree;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

/**
 * can
 */
public class BinarySearchTreeTest {

	@Test
	public void testInsert() throws Exception {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		insert(binarySearchTree);
	}

	private void insert(BinarySearchTree<Integer> tree) {
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		assertEquals(tree.size(), 3);
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testException() throws Exception {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage(startsWith("an equal value sent"));

		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(1);
		tree.insert(1);
	}

	@Test
	public void testSearch() throws Exception {
		search1(new BinarySearchTree<>());
		search2(new BinarySearchTree<>());
	}

	private void search2(BinarySearchTree<Integer> tree) {
		tree.insert(12);
		tree.insert(4);
		tree.insert(1);
		tree.insert(7);
		tree.insert(20);
		tree.insert(15);
		tree.insert(25);

		assertTrue(tree.search(12));

		assertTrue(tree.search(4));
		assertTrue(tree.search(1));
		assertTrue(tree.search(7));

		assertTrue(tree.search(20));
		assertTrue(tree.search(15));
		assertTrue(tree.search(25));

	}

	private void search1(BinarySearchTree<Integer> tree) {
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);

		assertTrue(tree.search(1));
		assertTrue(tree.search(2));
		assertTrue(tree.search(3));

		assertFalse(tree.search(77));
		assertFalse(tree.search(88));
		assertFalse(tree.search(99));
	}

	@Test
	public void testSwapDelete() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(12);
		tree.insert(4);
		tree.insert(1);
		tree.insert(7);
		tree.insert(20);
		tree.insert(15);
		tree.insert(25);

		List<Integer> inOrderExpected = Arrays.asList(1, 4, 7, 12, 15, 20, 25);
		List<Integer> traverseInOrder = tree.traverseInOrder();
		assertEquals(traverseInOrder, inOrderExpected);

		List<Integer> root12expected = Arrays.asList(12, 4, 1, 7, 20, 15, 25);
		List<Integer> root12 = tree.traverse();
		assertEquals(root12, root12expected);

		List<Integer> root7expected = Arrays.asList(7, 4, 1, 20, 15, 25);
		tree.delete(12);
		List<Integer> root7 = tree.traverse();
		assertEquals(root7, root7expected);

		List<Integer> removed20expected = Arrays.asList(7, 4, 1, 15, 25);
		tree.delete(20);
		List<Integer> removed20 = tree.traverse();
		assertEquals(removed20, removed20expected);

		List<Integer> removed4expected = Arrays.asList(7, 1, 15, 25);
		tree.delete(4);
		List<Integer> removed4 = tree.traverse();
		assertEquals(removed4, removed4expected);

	}
}