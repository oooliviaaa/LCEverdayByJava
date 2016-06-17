package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int capability;
	private int len;
	private Map<Integer, DoublyLinkedListNode> hm;
	private DoublyLinkedListNode head; // most recent
	private DoublyLinkedListNode tail; // last recent
	
	public LRUCache(int cap) {
		capability = cap;
		len = 0;
		hm = new HashMap<Integer, DoublyLinkedListNode>(cap);
		
	}
	
	public int get(int key) {
		if (hm.containsKey(key)) {
			DoublyLinkedListNode node = hm.get(key);
			removeNode(node);
			setHead(node);
			return node.val;
		} else {
			return -1;
		}
	}
	
	public void set(int key, int val) {
		if (hm.containsKey(key)) {
			DoublyLinkedListNode node = hm.get(key);
			node.val = val;
			removeNode(node);
			setHead(node);
		} else {
			DoublyLinkedListNode node = new DoublyLinkedListNode(key, val);
			if (len >= capability) {
				DoublyLinkedListNode endNode = tail;
				tail = tail.pre;
				hm.remove(endNode.key);
				if (tail != null) {
					tail.next = null;
				}
			} else {
				len++;
			}
			setHead(node);
			hm.put(key, node);
		}
	}
	
	private void removeNode(DoublyLinkedListNode node) {
		DoublyLinkedListNode pre = node.pre;
		DoublyLinkedListNode next = node.next;
		
		if (pre != null) {
			pre.next = next;
		} else {
			head = next;
		}
		
		if (next != null) {
			next.pre = pre;
		} else {
			tail = pre;
		}
	}
	
	private void setHead(DoublyLinkedListNode node) {
		node.next = head;
		node.pre = null;
		
		if (head != null) {
			head.pre = node;
		} 
		head = node;
		if (tail == null) {
			tail = node;
		}
	}
}
