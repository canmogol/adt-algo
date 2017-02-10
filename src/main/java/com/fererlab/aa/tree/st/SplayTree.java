package com.fererlab.aa.tree.st;

import java.util.ArrayList;
import java.util.List;

/**
 * Splaying:
 * After a search operation, setting the found node with searched value
 * at the root node is called splaying
 * <p/>
 * There are three ways to do that
 * 1. zig-zag
 * 2. zig-zig
 * 3. zig
 */
public class SplayTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public void insert(T data) {
		if (root == null) {
			root = new TreeNode<>(data);
		} else {
			insert(root, data);
		}
	}

	private void insert(TreeNode<T> node, T data) {
		int compareTo = node.getData().compareTo(data);
		if (compareTo < 0) {
			if (node.getRight() == null) {
				node.setRight(new TreeNode<>(data, node));
			} else {
				insert(node.getRight(), data);
			}
		} else if (compareTo > 0) {
			if (node.getLeft() == null) {
				node.setLeft(new TreeNode<>(data, node));
			} else {
				insert(node.getLeft(), data);
			}
		} else {
			throw new IllegalArgumentException("tree already got the value: " + data);
		}
	}

	public List<T> traverse() {
		List<T> list = new ArrayList<>();
		traverse(root, list);
		System.out.println();
		return list;
	}

	private void traverse(TreeNode<T> node, List<T> list) {
		System.out.print(node.getData() + " ");
		list.add(node.getData());
		if (node.getLeft() != null) {
			System.out.print("l");
			traverse(node.getLeft(), list);
		}
		if (node.getRight() != null) {
			System.out.print("r");
			traverse(node.getRight(), list);
		}
	}

	public boolean search(T data) {
		TreeNode<T> node = search(root, data);
		if (node != null) {
			moveDataToRoot(node);
		}
		return node != null;
	}

	private void moveDataToRoot(TreeNode<T> node) {
		int compareTo = node.getData().compareTo(root.getData());
		if (compareTo != 0) {
			moveToTop(node);
		}
	}

	private void moveToTop(TreeNode<T> node) {
		if (node.getParent() != null) {
			if (node.equals(node.getParent().getLeft())) {
				rotateRight(node);
			} else {
				rotateLeft(node);
			}
			moveToTop(node);
		}
	}

	private void rotateRight(TreeNode<T> node) {
		TreeNode<T> nodeRight = node.getRight();
		TreeNode<T> parentParent = node.getParent().getParent();

		if (parentParent != null) {
			if (node.getParent().equals(parentParent.getLeft())) {
				parentParent.setLeft(node);
			} else {
				parentParent.setRight(node);
			}
		}
		node.getParent().setParent(node);
		node.setRight(node.getParent());
		node.getParent().setLeft(nodeRight);
		if (nodeRight != null) {
			nodeRight.setParent(node.getParent());
		}
		node.setParent(parentParent);

		if (node.getParent() == null) {
			root = node;
		}
	}

	private void rotateLeft(TreeNode<T> node) {
		TreeNode<T> nodeLeft = node.getLeft();
		TreeNode<T> parentParent = node.getParent().getParent();

		if (parentParent != null) {
			if (node.getParent().equals(parentParent.getLeft())) {
				parentParent.setLeft(node);
			} else {
				parentParent.setRight(node);
			}
		}
		node.getParent().setParent(node);
		node.setLeft(node.getParent());
		node.getParent().setRight(nodeLeft);
		if (nodeLeft != null) {
			nodeLeft.setParent(node.getParent());
		}
		node.setParent(parentParent);

		if (node.getParent() == null) {
			root = node;
		}
	}


	private TreeNode<T> search(TreeNode<T> node, T data) {
		if (node == null) {
			return null;
		}
		int compareTo = node.getData().compareTo(data);
		if (compareTo < 0) {
			return search(node.getRight(), data);
		} else if (compareTo > 0) {
			return search(node.getLeft(), data);
		} else {
			return node;
		}
	}

}
