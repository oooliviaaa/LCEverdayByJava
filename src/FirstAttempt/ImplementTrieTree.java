package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

// 这个方法更好
class TrieNode {
    
    char val;
    Map<Character, TrieNode> children;
    boolean isLeaf;
    
    // Initialize your data structure here.
    public TrieNode(char val) {
        this.val = val;
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}

public class ImplementTrieTree {
    private TrieNode root;

    public ImplementTrieTree() {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
    
    private TrieNode searchNode(String word) {
        if (word == null || word.trim().length() == 0) return null;
        
        TrieNode node = root;                 ///// 先grab这个root
        for (int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children = node.children;
            if (!children.containsKey(word.charAt(i))) {
                return null;
            }
            node = children.get(word.charAt(i));
        }
        return node;
    }
}
