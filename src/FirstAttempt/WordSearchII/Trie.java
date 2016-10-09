package FirstAttempt.WordSearchII;

public class Trie {

	class TrieNode {
		
		TrieNode[] children;
		String word = "";    // 一定要initialize成空string，功能类似于node.isLeaf = true!!!
		
		public TrieNode(String val) {
			children = new TrieNode[26];
			word = val;
		}
	
		public TrieNode() {
			children = new TrieNode[26];
		}
	}   // end of class TrieNode
	
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode[] children = node.children;
			if (children[c-'a'] == null) {
				children[c-'a'] = new TrieNode();
			}
			node = children[c-'a'];
		}
		node.word = word;    // 功能类似于node.isLeaf = true, 表明这是一个word的结束
	}
	
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode[] children = node.children;
			if (children[c-'a'] == null) {
				return false;
			}
			node = children[c-'a'];
		}
		return node.word.equals(word);
	}
	
	public boolean startWith(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode[] children = node.children;
			if (children[c-'a'] == null) {
				return false;
			}
			node = children[c-'a'];
		}
		return true;
	}

}
