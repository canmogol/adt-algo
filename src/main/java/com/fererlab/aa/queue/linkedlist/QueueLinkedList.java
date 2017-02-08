package com.fererlab.aa.queue.linkedlist;

import com.fererlab.aa.queue.List;

/**
 * can
 */
public class QueueLinkedList<T> implements List<T> {

	private Node<T> head;
	private Node<T> tail;
	private int count = 0;

	@Override
	public void add(T t) {
		if (tail == null) {
			tail = new Node<>(t);
			head = tail;
		} else {
			Node<T> node = new Node<>(t);
			tail.setPrevious(node);
			node.setNext(tail);
			tail = node;
		}
		increaseSize();
	}

	private void increaseSize() {
		count++;
	}

	@Override
	public T remove() {
		if (head == null) {
			return null;
		} else {
			T value = head.getValue();
			head = head.getPrevious();
			if (head != null) {
				head.setNext(null);
			}
			decreaseSize();
			return value;
		}
	}

	private void decreaseSize() {
		count--;
	}

	@Override
	public int size() {
		return count;
	}
}
