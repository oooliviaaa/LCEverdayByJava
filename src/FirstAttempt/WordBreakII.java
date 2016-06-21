package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("");
		dict.add("le");
		dict.add("et");
		dict.add("code");
		dict.add("etcode");
		
		WordBreakII wb2 = new WordBreakII();
		List<String> res = wb2.wordBreak(s, dict);
			for (String l : res) {
				System.out.println(l);
			}
			System.out.println("=====");
		
	}
	
	// DFS
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        
        helper(s, wordDict, 0, res);
        
        return res;
    }
	
	private boolean helper(String s, Set<String> dict, int index, List<String> res) {
		if (index >= s.length()) {
			return true;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (dict.contains(sub)) {
				res.add(sub);
				if (helper(s, dict, i, res)) {
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
        
        helper2(s, wordDict, 0, new ArrayList<String>(), res);
        
        return res;
    }
	
	private void helper2(String s, Set<String> dict, int index, List<String> tmp, List<ArrayList<String>> res) {
		if (index >= s.length()) {
			ArrayList<String> record = new ArrayList<String>(tmp);
			res.add(record);
			return;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (dict.contains(sub)) {
				tmp.add(sub);
				helper2(s, dict, i, tmp, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
}
