package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	// https://segmentfault.com/a/1190000005605192
	// solution 1: hashmap
	/**
	 * HashMap和HashTable的区别：
	 * 	HashTable是synchronized，所以对于non-threaded applications，HashMap效率更高；
	 * 	HashTable不允许null作为键值，而HashMap允许一个null键和无限个null值；
	 * 	HashMap有一个subclass，叫LinkedHashMap，便于查询可预测的迭代顺序。
	 * 
	 * 为什么Trie比HashMap效率更高
	 * 	Trie可以在O(L)（L为word.length）的时间复杂度下进行插入和查询操作；
	 * 	HashMap和HashTable只能找到完全匹配的词组，而Trie可以找到有相同前缀的、有不同字符的、有缺失字符的词组。
	 * */
	public List<List<Integer>> palindromePairs(String[] words) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words == null || words.length < 2) return res;

		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i < words.length; i++) {
			hm.put(words[i], i);
		}
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j <= word.length(); j++) {  //  notice it should be "j <= words[i].length()"，因为s1, s2可以是空的""
				String s1 = word.substring(0, j);
				String s2 = word.substring(j);
				
				if (isPalindrome(s1)) {
					String reverseS2 = new StringBuffer(s2).reverse().toString();
					if (hm.getOrDefault(reverseS2, i) != i) {   // get or default position不是i，表示从hashmap里面找到了，且不是它自己
						res.add(Arrays.asList(hm.get(reverseS2), i));
					}
				}
				if (isPalindrome(s2) && s2.length() != 0) {  // check "s2.length() != 0" to avoid duplicates, eg. "abcd"和"dcba", "abcd"+"" == ""+"dcba"
					String reverseS1 = new StringBuffer(s1).reverse().toString();
					if (hm.getOrDefault(reverseS1, i) != i) {
						res.add(Arrays.asList(i, hm.get(reverseS1)));
					}
				}
			}
		}
		return res;
    }
	
	private boolean isPalindrome(String s) {
		if (s == null) return false;
		if (s.length() <= 1) return true;
		
		int i = 0;
		int j = s.length()-1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	
	//////////////////
	// solution 2: trie tree
	class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
        	addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
        	search(words, i, root, res);
        }
        return res;
    }
    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (root.next[word.charAt(i) - 'a'] == null) {
            	root.next[word.charAt(i) - 'a'] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) root.list.add(index);
            root = root.next[word.charAt(i) - 'a'];
        }
        root.list.add(index);
        root.index = index;
    }
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
        for (int j = 0; j < words[i].length(); j++) {   
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) list.add(Arrays.asList(i, root.index));
            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        for (int j : root.list) {
            if (i == j) continue;
            list.add(Arrays.asList(i, j));
        }
    }
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
    
    
    
    
	
	public static void main(String[] args) {
		PalindromePairs pp = new PalindromePairs();
		
		String[] words = {"abcd","dcba","lls","s","sssll"};
		String[] words2 = {"a",""};
		List<List<Integer>> res = pp.palindromePairs(words2);
		for (List<Integer> re : res) {
			for (Integer r : re) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
