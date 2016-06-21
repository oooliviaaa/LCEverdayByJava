package FirstAttempt.PrefixTree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	char val;
	Map<Character, TrieNode> children;
	boolean isleaf;
	
	public TrieNode(char val) {
		this.val = val;
		children = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}
