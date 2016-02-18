package FirstAttempt;

public class WildcardMatching {

	// https://longwayjade.wordpress.com/2015/04/26/leetcode-recursion-dp-greedy-wildcard-matching/
	///////////////////1 - Greedy/////////////////
	public boolean isMatch(String s, String p) {
        
    }
	
	///////////////////2 - Recursion/////////////////
	public boolean isMatch2(String s, String p) {
        if(s == null) return p == null;
		return helper2(s, p, 0, 0);
    }
	
	private boolean helper2(String s, String p, int i, int j) {
		if(j == p.length()) return i == s.length();
		
		if(p.charAt(j) == '*') {
			while(j < p.length() && p.charAt(j) == '*') j++;  // Move the index at p to a non-start char.
			while(i < s.length()) {
				if(helper2(s, p, i, j)) return true;
				i++;
			}
			return helper2(s, p, i, j);  // whether that * consumes the whole s
		}
		else if(i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
			return helper2(s, p, i+1, j+1);
		}
		else {
			return false;
		}
	}
	
	///////////////////3 - DP/////////////////
	public boolean isMatch3(String s, String p) {
		if(s == null) return p == null;
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		
		
		
		
    }
}
