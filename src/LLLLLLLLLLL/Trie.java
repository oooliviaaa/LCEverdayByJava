package LLLLLLLLLLL;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	
	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Map<Character, TrieNode> children = p.children;
			if (!children.containsKey(c)) {
				TrieNode next = new TrieNode(c);
				children.put(c, next);
			}
			p = children.get(c);
		}
		p.isLeaf = true;
	}
	
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Map<Character, TrieNode> children = p.children;
			if (children.containsKey(c)) {
				p = children.get(c);
			} else {
				return false;
			}
		}
		return p.isLeaf;
	}
	
	public boolean startWith(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Map<Character, TrieNode> children = p.children;
			if (children.containsKey(c)) {
				p = children.get(c);
			} else {
				return false;
			}
		}
		return true;
	}
	
}

class TrieNode {
	public char val;
	public Map<Character, TrieNode> children;
	public boolean isLeaf;
	
	public TrieNode(char val) {
		this.val = val;
		children = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}
