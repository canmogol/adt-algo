package com.fererlab.aa.stack.linkedlist;

/**
 * can
 */
public class Node<T> {

	private Node<T> previous;
	private T data;

	public Node(T data) {
		this.data = data;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "N{" + data + '}';
	}
}