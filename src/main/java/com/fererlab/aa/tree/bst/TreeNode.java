package com.fererlab.aa.tree.bst;

/**
 * can
 */
public class TreeNode<T> {

	private final T value;
	private TreeNode<T> parent;
	private TreeNode<T> left;
	private TreeNode<T> right;
	private boolean deleted = false;

	public TreeNode(T t) {
		this.value = t;
	}

	public T getValue() {
		return value;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
