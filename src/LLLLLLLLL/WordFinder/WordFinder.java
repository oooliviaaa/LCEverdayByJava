package LLLLLLLLL.WordFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordFinder {

	Trie trie;
	// prefix tree
	public void init (Set<String> words) {
		trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		
	}
	 
    
    public Set<String> find(List<Character> characters) {
    	Map<Character, Integer> hm = new HashMap<Character, Integer>();
    	for (char c : characters) {
    		if (hm.containsKey(c)) {
    			hm.put(c, hm.get(c)+1);
    		} else {
    			hm.put(c, 1);
    		}
    	}
    	
    	Set<String> res = new HashSet<String>();
    	helper(hm, trie.getRoot(), "", res);
    	return res;
    }
    
    private void helper(Map<Character, Integer> hm, TrieNode node, String tmp, Set<String> res) {
    	if (node.isLeaf) {
    		res.add(tmp);
    		return;
    	}
    	if (hm.isEmpty()) {
    		return;
    	}
    	
    	Map<Character, TrieNode> children = node.children;
    	for (Character c : children.keySet()) {
    		TrieNode child = children.get(c);
    		if (child != null && hm.containsKey(c)) {
    			Map<Character, Integer> newhm = new HashMap<Character, Integer>(hm);
    			if (newhm.get(c) == 1) {
    				newhm.remove(c);
    			} else {
    				newhm.put(c, hm.get(c)-1);
    			}
    			helper(newhm, child, tmp+c, res);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Set<String> words = new HashSet<String>();
    	words.add("word"); words.add("words"); words.add("wood"); words.add("woo"); words.add("order");
    	char[] chars = {'o', 'r', 's', 'd', 'o', 'w', 'e'};
    	List<Character> characters = new ArrayList<Character>();
    	for (char c : chars) {
    		characters.add(c);
    	}
    	
    	
    	WordFinder wf = new WordFinder();
    	wf.init(words);
    	Set<String> res = wf.find(characters);
    	for (String r : res) System.out.println(r);
    }
}
