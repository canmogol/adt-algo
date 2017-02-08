package com.fererlab.aa.stack.arraylist;

import com.fererlab.aa.stack.List;

import java.util.Arrays;

/**
 * can
 */
public class StackArrayList<T> implements List<T> {

	private static final int PREDEFINED_SIZE = 10;
	private Object[] objects;
	private int count = 0;

	public StackArrayList() {
		this(PREDEFINED_SIZE);
	}

	public StackArrayList(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("size cannot be less then one");
		}
		this.objects = new Object[size];
	}

	@Override
	public void add(T t) {
		if (doesNeedExpansion()) {
			expand();
		}
		objects[size()] = t;
		increaseSize();
	}

	private void increaseSize() {
		count++;
	}

	private void expand() {
		objects = Arrays.copyOf(objects, objects.length * 2);
	}

	private boolean doesNeedExpansion() {
		if (objects[objects.length - 1] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public T remove() {
		if (size() > 0) {
			T value;
			{
				@SuppressWarnings("unchecked")
				T v = (T) objects[size() - 1];
				value = v;
			}
			objects[size() - 1] = null;
			decreaseSize();
			if (shouldItShrink()) {
				shink();
			}
			return value;
		} else {
			return null;
		}
	}

	private void shink() {
		objects = Arrays.copyOf(objects, objects.length / 2);
	}

	private boolean shouldItShrink() {
		if (size() < objects.length / 2) {
			return true;
		} else {
			return false;
		}
	}

	private void decreaseSize() {
		count--;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getLast() {
		return size() > 0 ? (T) objects[size() - 1] : null;
	}

}
