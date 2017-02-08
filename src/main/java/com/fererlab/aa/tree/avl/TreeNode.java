package com.fererlab.aa.tree.avl;

/**
 * can
 */
public class TreeNode<T> {

	private T data;
	private TreeNode<T> parent;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(TreeNode<T> parent, T data) {
		this.parent = parent;
		this.data = data;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public T getData() {
		return data;
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
