package com.fererlab.aa.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * can
 */
public class Heap<T extends Comparable<T>> {

	private static final int STEP_SIZE = 10;
	private T[] elements;
	private int nextIndex = 0;

	public Heap() {
	}

	public Heap(Heap<T> h) {
		this.elements = Arrays.copyOf(h.elements, h.elements.length);
		this.nextIndex = h.nextIndex;
	}

	public void offer(T data) {
		if (!hasSpace()) {
			expand();
		}
		add(data);
		heapify(nextIndex - 1);
	}

	private void heapify(int index) {
		if (index >= 0) {
			T data = elements[index];
			int otherChild;
			int parentIndex;
			if (index % 2 == 0) {
				// right child
				parentIndex = (index - 2) / 2;
				otherChild = index - 1;
			} else {
				// left child
				parentIndex = (index - 1) / 2;
				otherChild = index + 1;
			}

			if (parentIndex >= 0) {
				if (elements[parentIndex].compareTo(data) < 0) {
					// parent is less then data
					T parent = elements[parentIndex];
					elements[parentIndex] = data;
					elements[index] = parent;
				}
				if (elements[otherChild] != null
					&& elements[parentIndex].compareTo(elements[otherChild]) < 0) {
					// parent is less then other child
					T parent = elements[parentIndex];
					elements[parentIndex] = elements[otherChild];
					elements[otherChild] = parent;
				}
				heapify(parentIndex);
			}
		} else {
			// do nothing for negative indexes
		}
	}

	private void add(T data) {
		elements[nextIndex] = data;
		nextIndex++;
	}

	private void expand() {
		elements = Arrays.copyOf(elements, elements.length + STEP_SIZE);
	}

	@SuppressWarnings("unchecked")
	private boolean hasSpace() {
		if (elements == null) {
			elements = (T[]) new Comparable[STEP_SIZE];
			return true;
		} else if (nextIndex == elements.length) {
			return false;
		} else {
			return true;
		}
	}

	public T peek() {
		return elements[0];
	}

	public T pop() {
		if (nextIndex == 0) {
			return null;
		} else {
			T root = elements[0];
			T lastElement = elements[nextIndex - 1];
			elements[0] = lastElement;
			elements[nextIndex - 1] = null;
			nextIndex--;
			heapify(nextIndex - 1);

			return root;
		}
	}

	public static <T extends Comparable<T>> List<T> sort(Heap<T> h) {
		List<T> list = new ArrayList<>();
		Heap<T> heap = new Heap<>(h);
		T root;
		while ((root = heap.pop()) != null) {
			list.add(root);
		}
		return list;
	}

}
