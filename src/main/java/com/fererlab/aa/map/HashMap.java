package com.fererlab.aa.map;

/**
 * can
 */
public class HashMap<K, V> {

	private static final int SIZE = 19;

	@SuppressWarnings("unchecked")
	private Node<K, V>[] nodes = new Node[SIZE];

	public void put(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("key or value cannot be null");
		} else {
			int hash = hash(key);
			put(hash, key, value);
		}
	}

	private void put(int hash, K key, V value) {
		Node<K, V> current = nodes[hash];
		if (current == null) {
			nodes[hash] = new Node<>(hash, key, value);
		} else {
			boolean alreadyInMap = false;
			Node<K, V> node = current;
			while (node.getNext() != null) {
				if (value.equals(node.getValue())) {
					alreadyInMap = true;
					break;
				}
				node = node.getNext();
			}
			if (!alreadyInMap) {
				if (!value.equals(node.getValue())) {
					node.setNext(new Node<K, V>(hash, key, value));
				}
			}
		}
	}

	private int hash(K key) {
		return key.hashCode() % SIZE;
	}

	public V get(K key) {
		int hash = hash(key);
		Node<K, V> node = nodes[hash];
		if (node == null) {
			return null;
		} else if (node.getNext() == null) {
			return node.getValue();
		} else {
			while (node.getNext() != null) {
				node = node.getNext();
			}
			return node.getValue();
		}
	}

}
