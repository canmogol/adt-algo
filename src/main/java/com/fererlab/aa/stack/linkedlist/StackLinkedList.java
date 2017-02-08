package com.fererlab.aa.stack.linkedlist;

import com.fererlab.aa.stack.List;

/**
 * can
 */
public class StackLinkedList<T> implements List<T> {

	private Node<T> head;
	private int count = 0;

	@Override
	public void add(T t) {
		if (head == null) {
			head = new Node<>(t);
		} else {
			Node<T> previous = head;
			head = new Node<>(t);
			head.setPrevious(previous);
		}
		count++;
	}

	@Override
	public T remove() {
		if (head == null) {
			return null;
		} else {
			T t = head.getData();
			head = head.getPrevious();
			count--;
			return t;
		}
	}

	@Override
	public int size() {
		return count;
	}

	public T getLast() {
		return head == null ? null : head.getData();
	}

}
