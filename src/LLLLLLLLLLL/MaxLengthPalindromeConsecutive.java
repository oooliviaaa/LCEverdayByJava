package LLLLLLLLLLL;

public class MaxLengthPalindromeConsecutive {

	
	public String solution(String s) {
		if (s == null || s.length() == 0) return "";
        
        int len = 1;
        int start = 0;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                len = 2;
                start = i;
            }
        }
        
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    len = length;
                    start = i;
                }
            }
        }
        return s.substring(start, start+len);
	}
}
