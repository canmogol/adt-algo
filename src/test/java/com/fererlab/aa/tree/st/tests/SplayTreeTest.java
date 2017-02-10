package com.fererlab.aa.tree.st.tests;

import com.fererlab.aa.tree.st.SplayTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * can
 */
public class SplayTreeTest {

	@Test
	public void testInsert() throws Exception {
		SplayTree<Integer> tree = new SplayTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(20);
		tree.insert(15);
		tree.insert(30);
		System.out.println(tree.traverse());
	}

	@Test
	public void testSearch() {
		SplayTree<Integer> tree = new SplayTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(20);
		tree.insert(15);
		tree.insert(30);

		Assert.assertEquals(tree.search(10), true);
		Assert.assertEquals(tree.search(5), true);
		Assert.assertEquals(tree.search(3), true);
		Assert.assertEquals(tree.search(20), true);
		Assert.assertEquals(tree.search(30), true);

		Assert.assertEquals(tree.search(999), false);
	}

}