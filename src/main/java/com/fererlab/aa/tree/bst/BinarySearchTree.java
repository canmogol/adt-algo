package com.fererlab.aa.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * can
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private TreeNode<T> root;
	private int count = 0;

	public void insert(T value) {
		if (root == null) {
			root = new TreeNode<>(value);
			root.setParent(null);
		} else {
			addElement(root, value);
		}
		count++;
	}

	private void addElement(TreeNode<T> currentNode, T value) {
		if (currentNode.getValue().compareTo(value) > 0) {
			// add to left, or continue on left
			if (currentNode.getLeft() == null) {
				TreeNode<T> leftNode = new TreeNode<>(value);
				leftNode.setParent(currentNode);
				currentNode.setLeft(leftNode);
			} else {
				addElement(currentNode.getLeft(), value);
			}
		} else if (currentNode.getValue().compareTo(value) < 0) {
			// add to right, or continue on right
			if (currentNode.getRight() == null) {
				TreeNode<T> rightNode = new TreeNode<>(value);
				rightNode.setParent(currentNode);
				currentNode.setRight(rightNode);
			} else {
				addElement(currentNode.getRight(), value);
			}
		} else {
			// value and the tree node's value are equal
			throw new RuntimeException("an equal value sent, value: " + value + ", this implementation does not support equal values in tree");
		}
	}

	public boolean search(T value) {
		//System.out.print("\nstep ");
		TreeNode<T> node = find(root, value, 0);
		if (node == null) {
			return false;
		} else if (node.isDeleted()) {
			return false;
		} else {
			return true;
		}
	}

	private TreeNode<T> find(TreeNode<T> currentNode, T value, int step) {
		//System.out.print(step + " ");
		if (currentNode == null) {
			return null;
		}
		if (currentNode.getValue().compareTo(value) < 0) {
			return find(currentNode.getRight(), value, ++step);
		} else if (currentNode.getValue().compareTo(value) > 0) {
			return find(currentNode.getLeft(), value, ++step);
		} else {
			return currentNode;
		}
	}

	public int size() {
		return count;
	}

	public boolean delete(T value) {
		TreeNode<T> node = find(root, value, 0);
		if (node == null) {
			return false;
		}
		if (node.getLeft() == null
			&& node.getRight() == null) {
			if (node.equals(node.getParent().getLeft())) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
			return true;
		} else if (node.getLeft() != null
			^ node.getRight() != null) {
			if (node.getLeft() != null) {
				if (node.equals(node.getParent().getLeft())) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			} else {
				if (node.equals(node.getParent().getLeft())) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
			return true;
		} else {
			// swap and remove
			TreeNode<T> predecessorNode = predecessor(node);
			if (node.equals(root)) {
				root = predecessorNode;
			}
			swap(node, predecessorNode);
			return softDelete(node);
		}
	}

	private void swap(TreeNode<T> currentNode, TreeNode<T> predecessorNode) {
		TreeNode<T> currentParent = currentNode.getParent();
		TreeNode<T> currentLeft = currentNode.getLeft();
		TreeNode<T> currentRight = currentNode.getRight();
		TreeNode<T> preParent = predecessorNode.getParent();
		TreeNode<T> preLeft = predecessorNode.getLeft();
		TreeNode<T> preRight = predecessorNode.getRight();

		if (currentParent != null) {
			if (currentNode.equals(currentParent.getLeft())) {
				currentParent.setLeft(predecessorNode);
			} else {
				currentParent.setRight(predecessorNode);
			}
		}
		predecessorNode.setParent(currentParent);
		if (!predecessorNode.equals(currentLeft)) {
			predecessorNode.setLeft(currentLeft);
		} else {
			predecessorNode.setLeft(null);
		}
		if (!predecessorNode.equals(currentRight)) {
			predecessorNode.setRight(currentRight);
		} else {
			predecessorNode.setRight(null);
		}
		if (currentLeft != null) {
			currentLeft.setParent(predecessorNode);
		}
		if (currentRight != null) {
			currentRight.setParent(predecessorNode);
		}

		if (preParent != null) {
			if (predecessorNode.equals(preParent.getLeft())) {
				preParent.setLeft(currentNode);
			} else {
				preParent.setRight(currentNode);
			}
		}

		currentNode.setParent(preParent);

		if (!currentNode.equals(preLeft)) {
			currentNode.setLeft(preLeft);
		} else {
			currentNode.setLeft(null);
		}

		if (!currentNode.equals(preRight)) {
			currentNode.setRight(preRight);
		} else {
			currentNode.setRight(null);
		}

	}

	private TreeNode<T> predecessor(TreeNode<T> node) {
		TreeNode<T> predecessorNode = findTheHighest(node.getLeft());
		return predecessorNode;
	}

	private TreeNode<T> findTheHighest(TreeNode<T> node) {
		TreeNode<T> predecessorNode = node;
		while (predecessorNode.getRight() != null) {
			predecessorNode = predecessorNode.getRight();
		}
		return predecessorNode;
	}

	public boolean softDelete(TreeNode<T> node) {
		if (node == null) {
			return false;
		}
		if (node.getLeft() == null
			&& node.getRight() == null) {
			if (node.getParent() != null) {
				if (node.equals(node.getParent().getLeft())) {
					node.getParent().setLeft(null);
				} else {
					node.getParent().setRight(null);
				}
			}
			return true;
		} else if (node.getLeft() != null
			^ node.getRight() != null) {
			if (node.getLeft() != null) {
				if (node.getParent().getLeft().equals(node)) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			} else {
				if (node.getParent().getLeft().equals(node)) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
			return true;
		} else {
			node.setDeleted(true);
			return true;
		}
	}

	public boolean softDelete(T value) {
		TreeNode<T> node = find(root, value, 0);
		return softDelete(node);
	}

	public List<T> traverseInOrder() {
		List<T> list = new ArrayList<>();
		if (root != null) {
			printInOrder(list, root);
		}
		return list;
	}

	private void printInOrder(List<T> list, TreeNode<T> node) {
		if (node.getLeft() != null) {
			printLeft(list, node.getLeft());
		}
		System.out.print(node.getValue() + " ");
		list.add(node.getValue());
		if (node.getRight() != null) {
			printRight(list, node.getRight());
		}
	}

	private void printRight(List<T> list, TreeNode<T> node) {
		if (node.getRight() != null) {
			printInOrder(list, node);
		} else {
			list.add(node.getValue());
			System.out.print(node.getValue() + " ");
		}
	}

	private void printLeft(List<T> list, TreeNode<T> node) {
		if (node.getLeft() != null) {
			printInOrder(list, node);
		} else {
			list.add(node.getValue());
			System.out.print(node.getValue() + " ");
		}
	}

	public List<T> traverse() {
		List<T> list = new ArrayList<>();
		if (root != null) {
			System.out.print("\nroot:" + root.getValue() + ", ");
			print(list, root);
		}
		return list;
	}

	private void print(List<T> list, TreeNode<T> node) {
		System.out.print(node.getValue() + " ");
		list.add(node.getValue());
		if (node.getLeft() != null) {
			print(list, node.getLeft());
		}
		if (node.getRight() != null) {
			print(list, node.getRight());
		}
	}
}
