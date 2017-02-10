package com.fererlab.aa.tree.st;

/**
 * can
 */
public class TreeNode<T> {

	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	private TreeNode<T> parent;

	public TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
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
}
