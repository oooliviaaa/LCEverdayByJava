package LLLLLLLLL.WordFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    
	public char val;
    public Map<Character, TrieNode> children;
    public boolean isLeaf;
    
    // Initialize your data structure here.
    public TrieNode(char val) {
        this.val = val;
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}

public class Trie {
    private TrieNode root;
    
    public TrieNode getRoot() {
    	return root;
    }

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;           ///// 先grab这个root
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Map<Character, TrieNode> children = node.children;
            TrieNode next;
            if (children.containsKey(c)) {
                next = children.get(c);
            } else {
                next = new TrieNode(c);
                children.put(c, next);
            }
            node = next;
        }
        node.isLeaf = true;   ////// !!!!!
    }

}
