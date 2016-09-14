package FirstAttempt;

public class InterleavingString {

	// http://www.cnblogs.com/springfor/p/3896159.html
	// DP: 动态规划数组是dp[i][j]，表示：s1取前i位，s2取前j位，是否能组成s3的前i+j位。
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != s1.length() + s2.length()) return false;    

		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		dp[0][0] = true;
		
		for (int i = 1; i <= s1.length() && s1.charAt(i-1) == s3.charAt(i-1); i++) {  // 当有一处不同时，for loop就结束了!!!!!
			dp[i][0] = true;
		}
		
		for (int j = 1; j <= s2.length() && s2.charAt(j-1) == s3.charAt(j-1); j++) {  // 当有一处不同时，for loop就结束了!!!!!
			dp[0][j] = true;
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				char c = s3.charAt(i+j-1);
				if (c == s1.charAt(i-1) && dp[i-1][j]) {
					dp[i][j] = true;
				} else if (c == s2.charAt(j-1) && dp[i][j-1]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[s1.length()][s2.length()];
    }
	
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		boolean res = is.isInterleave("db", "b", "cbb");
		System.out.println(res);
	}
}
