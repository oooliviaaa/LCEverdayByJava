package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet"); dict.add("code");
		
		WordBreak wb = new WordBreak();
		boolean res = wb.wordBreak(s, dict);
		System.out.println(res);
	}
	
		
	// dynamic programming
	/**
	 * Define an array dp[] such that dp[i]==true means s.subString(0, (i-1)) can be segmented using dictionary
	 * Initial state dp[0] == true
    */
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i; j >= 0; j--) {
        		String sub = s.substring(j, i+1);
        		if (dp[j] && wordDict.contains(sub)) {
        			dp[i+1] = true;
        			break;
        		}
        	}
        }
        return dp[s.length()];
	}
	
}
