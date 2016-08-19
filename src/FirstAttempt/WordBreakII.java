package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		WordBreakII wb2 = new WordBreakII();
		List<String> res = wb2.wordBreak(s, dict);
			for (String l : res) {
				System.out.println(l);
			}
			System.out.println("=====");
			
			List<ArrayList<String>> wordBreakAllResults = wb2.wordBreakAllResults(s, dict);
			for (List<String> list : wordBreakAllResults) {
				for (String l : list) {
					System.out.println(l);
				}
				System.out.println("~~~");
			}
		
	}
	
	// DFS
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        
        helper(s, wordDict, 0, new StringBuffer(), res);
        
        return res;
    }
	
	private void helper(String s, Set<String> dict, int index, StringBuffer tmp, List<String> res) {
		if (index >= s.length()) {
			res.add(tmp.toString());
			return;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (dict.contains(sub)) {
				tmp.append(" " + sub);
				helper(s, dict, i, tmp, res);
				tmp.delete(tmp.length()-sub.length()-1, tmp.length());
			}
		}
	}
	
	
	
	// DFS return only one result， and check if exists
	public List<String> wordBreakOneResult(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        
        helper2(s, wordDict, 0, res);
        
        return res;
    }
	
	private boolean helper2(String s, Set<String> dict, int index, List<String> res) {
		if (index >= s.length()) {
			return true;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (dict.contains(sub)) {
				res.add(sub);
				if (helper2(s, dict, i, res)) {
					break;
				}
				res.remove(res.size()-1);
			}
		}
		return true;
	}
	
	
	
	
	// DFS return all results
	public List<ArrayList<String>> wordBreakAllResults(String s, Set<String> wordDict) {
        List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        helper3(s, wordDict, 0, new ArrayList<String>(), res);
        
        return res;
    }
	
	private void helper3(String s, Set<String> dict, int index, List<String> tmp, List<ArrayList<String>> res) {
		if (index >= s.length()) {
			ArrayList<String> record = new ArrayList<String>(tmp);
			res.add(record);
			return;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (dict.contains(sub)) {
				tmp.add(sub);
				helper3(s, dict, i, tmp, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
}
