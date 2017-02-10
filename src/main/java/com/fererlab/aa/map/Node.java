package com.fererlab.aa.map;

/**
 * can
 */
public class Node<K, V> {

	private final int hash;
	private final K key;
	private final V value;
	private Node<K, V> next;

	public Node(int hash, K key, V value) {
		this.hash = hash;
		this.key = key;
		this.value = value;
	}

	public int getHash() {
		return hash;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}
}
