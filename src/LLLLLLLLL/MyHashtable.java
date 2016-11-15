package LLLLLLLLL;

import java.util.Arrays;

public class MyHashtable<K, V> {

	int tableSize;
	HTNode<K, V>[] array;
	static final int DEFAULT_SIZE = 1000;
	
	public MyHashtable() {
		tableSize = DEFAULT_SIZE;
		array = new HTNode[DEFAULT_SIZE];
	}
	
	public MyHashtable(int size) {
		tableSize = size;
		array = new HTNode[size];
	}
	
	public V get(K key) {
		int index = key.hashCode() % tableSize;
		HTNode<K, V> node = array[index];
		
		HTNode<K, V> p = node;
		while (p != null) {
			if (p.key.equals(key)) {
				return p.value;
			} else {
				p = p.next;
			}
		}
		return null;
	}
	
	
	public void put(K key, V value) {
		int index = key.hashCode() % tableSize;
		HTNode<K, V> node = array[index];
		if (node == null) {
			array[index] = new HTNode<K, V>(key, value, null);
		} else {
			HTNode<K, V> p = node;
			while (p.key != key && p.next != null) {
				p = p.next;
			}
			if (p.key.equals(key)) {
				p.value = value;
			} else {
				p.next = new HTNode<K, V>(key, value, null);
			}
		}

	}
	
	public boolean remove(K key) {
		int index = key.hashCode() % tableSize;
		HTNode<K, V> node = array[index];
		if (node == null) {
			return false;
		}
		HTNode<K, V> p = node;
		while (p != null) {
			if (p.key.equals(key)) {
				p.value = null;
				return true;
			} else {
				p = p.next;
			}
		}
		return false;
	}
	
	public void resize(int size) {
		this.tableSize = size;
		HTNode<K, V>[] reference = Arrays.copyOf(array, array.length);
		array = new HTNode[size];
		for (HTNode<K, V> node : reference) {
			if (node == null) continue;
			while (node != null) {
				put(node.key, node.value);
				node = node.next;
			}
		}
	}
	
}


class HTNode<K, V> {
	K key;
	V value;
	HTNode<K, V> next;
	
	public HTNode(K key, V value, HTNode<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}