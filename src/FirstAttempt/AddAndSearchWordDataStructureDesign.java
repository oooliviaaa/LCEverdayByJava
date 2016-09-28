package FirstAttempt;

public class AddAndSearchWordDataStructureDesign {

	// http://www.cnblogs.com/yrbbest/p/4979621.html
	// Trie tree， Java Solution 2 - Using Array
	
	class TrieNode {
		TrieNode[] children;
		boolean isLeaf;
		TrieNode() {      //  由于数组下标就可以代替字母值，所以根本不用存node的val
			children = new TrieNode[26];
		}
	}
	
	TrieNode root;
	 
    public AddAndSearchWordDataStructureDesign(){
        root = new TrieNode();
    }
	
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	int index = c - 'a';
        	TrieNode[] children = node.children;
        	if (children[index] == null) {
        		TrieNode tmp = new TrieNode();
        		children[index] = tmp;
        	}
        	// 此处不用将node.isLeaf变为false，因为我们是要track在此结束的word是否出现过，
        	// isLeaf就是告诉我们这个word在这结束的，即便他有children，他也是我们曾经add入的某个单词的最后一位
        	node = children[index];  
        }
        node.isLeaf = true;   /////// 最后一个是leaf
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	TrieNode node = root;
    	return dfs(word, 0, node);
    }
    
    private boolean dfs(String word, int index, TrieNode node) {
    	if (node.isLeaf && index == word.length()) return true;
    	if (index >= word.length()) return false;
    	if (node.isLeaf && index < word.length()) return false;
    	
    	char c = word.charAt(index);
    	TrieNode[] children = node.children;
    	if (c == '.') {
    		for (int i = 0; i < children.length; i++) {
    			if (children[i] != null) {
    				if (dfs(word, index+1, children[i])) {
    					return true;
    				}
    			}
    		}
    	} else {
    		TrieNode next = children[c-'a'];
    		if (next == null) return false;
    		return dfs(word, index+1, next);
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	AddAndSearchWordDataStructureDesign as = new AddAndSearchWordDataStructureDesign();
    	as.addWord("a");
    	boolean res = as.search(".");
    	System.out.println(res);
    }
}
