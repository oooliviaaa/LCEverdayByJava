package FirstAttempt.PrefixTree;

import java.util.Map;

public class ImplementTrie {

	private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.trim().length() == 0) return;
        Map<Character, TrieNode> child = root.children;
        
        for (int i = 0; i < word.length(); i++) {
        	char w = word.charAt(i);
        	
        	TrieNode node;
        	if (child.containsKey(w)) {
        		node = child.get(w);
        	} else {
        		node = new TrieNode(w);
        		child.put(w, node);
        	}
        	child = node.children;
        	
        	if (i == word.length()-1) {
        		node.isleaf = true;
        	}
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        
        return node != null && node.isleaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
    
    private TrieNode searchNode(String s) {
    	TrieNode node = null;
    	if (s == null || s.trim().length() == 0) return node;
    	Map<Character, TrieNode> child = root.children;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (child.containsKey(c)) {
    			node = child.get(c);
    			child = node.children;
    		} else {
    			return null;
    		}
    	}
    	return node;
    }
}
