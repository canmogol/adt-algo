package com.fererlab.aa.queue;

import com.fererlab.aa.queue.linkedlist.QueueLinkedList;

/**
 * can
 */
public class Queue<T> {

	private List<T> list;

	public Queue() {
		this.list = new QueueLinkedList<>();
	}

	public Queue(int size) {
//		this.list = new QueueArrayList<>(size);
	}

	public void enqueue(T t) {
		list.add(t);
	}

	public T deque() {
		return list.remove();
	}

	public int size() {
		return list.size();
	}

}
