package com.fererlab.aa.stack;

import com.fererlab.aa.stack.arraylist.StackArrayList;
import com.fererlab.aa.stack.linkedlist.StackLinkedList;

/**
 * can
 */
public class Stack<T> {

	private final List<T> list;

	public Stack() {
		list = new StackLinkedList<>();
	}

	public Stack(int size) {
		this.list = new StackArrayList<>(size);
	}

	public void push(T t) {
		list.add(t);
	}

	public T pop() {
		return list.remove();
	}

	public T peek() {
		return list.getLast();
	}

	public int size() {
		return list.size();
	}

}
