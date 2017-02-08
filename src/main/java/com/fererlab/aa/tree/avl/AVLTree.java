package com.fererlab.aa.tree.avl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * can
 */
public class AVLTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public void insert(T data) {
		if (root == null) {
			root = new TreeNode<>(null, data);
		} else {
			insert(root, data);
		}
		int rootVal = balance(root);
		System.out.println("\nrootVal = " + rootVal);
	}

	private int balance(TreeNode<T> node) {
		// traverse tree with in-order traversal
		// 		compare the left and the right node values
		//		if the difference is greater than 1 then rotate (left or right)
		if (node == null) {
			return -1;
		}
		final int leftVal = balance(node.getLeft());
		final int rightVal = balance(node.getRight());

		int nodeVal = Math.max(leftVal, rightVal) + 1;
		final int diff = Math.abs(leftVal - rightVal);
		if (diff > 1) {
			if (leftVal < rightVal) {
				rotateLeft(node);
			} else {
				rotateRight(node);
			}
			nodeVal = nodeVal - 1;
		}
		return nodeVal;
	}

	private void rotateRight(TreeNode<T> node) {
		boolean isRoot = false;
		if (root.getData().compareTo(node.getData()) == 0) {
			isRoot = true;
		}
		normalize(node);
		TreeNode<T> leftNode = node.getLeft();
		TreeNode<T> nodeParent = node.getParent();
		TreeNode<T> leftNodeParent = leftNode.getParent();

		node.setLeft(leftNode.getRight());
		leftNode.setRight(node);

		if (isRoot) {
			root = leftNode;
		}

		if (nodeParent != null) {
			if (node.equals(nodeParent.getLeft())) {
				nodeParent.setLeft(leftNode);
			} else {
				nodeParent.setRight(leftNode);
			}
		}

		node.setParent(leftNodeParent);
		leftNode.setParent(nodeParent);

	}

	private void rotateLeft(TreeNode<T> node) {
		boolean isRoot = false;
		if (root.getData().compareTo(node.getData()) == 0) {
			isRoot = true;
		}
		normalize(node);
		TreeNode<T> rightNode = node.getRight();
		TreeNode<T> nodeParent = node.getParent();
		TreeNode<T> rightNodeParent = rightNode.getParent();

		node.setRight(rightNode.getLeft());
		rightNode.setLeft(node);

		if (isRoot) {
			root = rightNode;
		}


		if (nodeParent != null) {
			if (node.equals(nodeParent.getLeft())) {
				nodeParent.setLeft(rightNode);
			} else {
				nodeParent.setRight(rightNode);
			}
		}

		node.setParent(rightNodeParent);
		rightNode.setParent(nodeParent);
	}

	private void normalize(TreeNode<T> node) {
		if (node.getRight() != null
			&& node.getRight().getLeft() != null
			&& node.getRight().getRight() == null) {
			// 				node
			//					right child 1
			//			left child 2
			TreeNode<T> child1 = node.getRight();
			TreeNode<T> child2 = node.getRight().getLeft();
			// swap child 1 with child 2
			// move child 1(2)	to other side

			child1.setLeft(child2.getLeft());
			child1.setRight(child2.getRight());

			child1.setParent(child2);
			child2.setParent(node);

			node.setRight(child2);
			child2.setLeft(null);
			child2.setRight(child1);

		} else if (node.getLeft() != null
			&& node.getLeft().getRight() != null
			&& node.getLeft().getLeft() == null) {
			// 				node
			//		left child
			//				right child
			TreeNode<T> child1 = node.getLeft();
			TreeNode<T> child2 = node.getLeft().getRight();
			// swap child 1 with child 2
			// move child 1(2)	to other side

			child1.setLeft(child2.getLeft());
			child1.setRight(child2.getRight());

			child1.setParent(child2);
			child2.setParent(node);

			node.setLeft(child2);
			child2.setRight(null);
			child2.setLeft(child1);
		}

	}

	private void insert(TreeNode<T> node, T data) {
		int compareTo = data.compareTo(node.getData());
		if (compareTo < 0) {
			// data: 5		node-data:	10
			if (node.getLeft() == null) {
				TreeNode<T> dataNode = new TreeNode<>(node, data);
				node.setLeft(dataNode);
			} else {
				insert(node.getLeft(), data);
			}
		} else if (compareTo > 0) {
			// data: 5		node-data:	3
			if (node.getRight() == null) {
				TreeNode<T> dataNode = new TreeNode<>(node, data);
				node.setRight(dataNode);
			} else {
				insert(node.getRight(), data);
			}
		} else {
			throw new InvalidParameterException("tree already contains same value: " + data);
		}
	}

	public List<T> traverse() {
		List<T> values = new ArrayList<>();
		traverse(values, root);
		return values;
	}

	private void traverse(List<T> values, TreeNode<T> node) {
		System.out.print(node.getData() + " ");
		values.add(node.getData());
		if (node.getLeft() != null) {
			System.out.print("l");
			traverse(values, node.getLeft());
		}
		if (node.getRight() != null) {
			System.out.print("r");
			traverse(values, node.getRight());
		}
	}

	public void remove(){
		// it is the same implementation as in the BinarySearchTree, see the implementation there
		// there are three cases;
		// 1. the node to remove is a terminal node, a leaf node, a node without any children
		//		simply remove the reference to that node from its parent
		// 2. the node has only one child
		//		set the parent's reference to that child, this will remove the node from tree
		// 3. node has two children
		//		either find the predecessor or the successor
		//		and set the reference int the predecessor/successor's parent to null
		// 		and replace node to delete with predecessor/successor
		//
		// after removing the node, run the balance() method on the tree
	}
}
