package LLLLLLLLLLL;

public class MyHashTable<K, V> {
	
	private static final int DEFAULT_SIZE = 10;
	private HTNode<K, V>[] array;
	private int size;
	
	public MyHashTable() {
		array = new HTNode[DEFAULT_SIZE];
		this.size = DEFAULT_SIZE;
	}
	
	public MyHashTable(int size) {
		array = new HTNode[size];
		this.size = size;
	}
	
	public V get(K key) {
		int index = key.hashCode() % size;
		
		HTNode<K, V> node = array[index];
		while (node != null) {
			if (node.key == key) {
				return node.value;
			} else {
				node = node.next;
			}
		}
		return null;
	}
	 
	  
	public void put(K key, V value) {
		int index = key.hashCode() % size;
		HTNode<K, V> node = array[index];
		
		if (node == null) {
			array[index] = new HTNode(key, value);
		} else {
			while (node.next != null && node.key != key) {
				node = node.next;
			}
			if (node.key == key) {
				node.value = value;
			} else {
				node.next = new HTNode(key, value);
			}
		}
	}
}

class HTNode<K, V> {
	
	public K key;
	public V value;
	HTNode<K, V> next;
	
	public HTNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
