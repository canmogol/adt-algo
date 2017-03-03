package com.fererlab.ps.intercode.w16;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeNodeTest {

    private static final int ROOT = 0;
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private BinaryTreeNode binaryTreeNode;

    @Before
    public void createBinaryTree() {
        binaryTreeNode = new BinaryTreeNode(ROOT);
    }

    @Test
    public void testInsertLeft() throws Exception {
        binaryTreeNode.insertLeft(LEFT);
        assertThat(binaryTreeNode.left.value, is(LEFT));
    }

    @Test
    public void testInsertRight() throws Exception {
        binaryTreeNode.insertRight(RIGHT);
        assertThat(binaryTreeNode.right.value, is(RIGHT));
    }
}
