package FirstAttempt;

public class DistinctSubsequences {

	// http://www.cnblogs.com/springfor/p/3896152.html
	/**
	 * 首先设置动态规划数组dp[i][j]，表示S串中从开始位置到第i位置与T串从开始位置到底j位置匹配的子序列的个数。
	 * 如果S串为空，那么dp[0][j]都是0；
	 * 如果T串为空，那么dp[i][j]都是1，因为空串为是任何字符串的字串。
	 * 可以发现规律，dp[i][j] 至少等于 dp[i][j-1]。
	 * 同时，如果字符串S[i-1]和T[j-1]（dp是从1开始计数，字符串是从0开始计数）匹配的话，dp[i][j]还要加上dp[i-1][j-1]
	 * */
	public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
        	dp[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) {
        	dp[0][j] = 0;
        }
        
        for (int i = 1; i <= s.length(); i++) {
        	for (int j = 1; j <= t.length(); j++) {
        		dp[i][j] = dp[i-1][j];   ///////////////  至少是i-1长度s与j长度t的match个数!!!!!
        		if (s.charAt(i-1) == t.charAt(j-1)) {
        			dp[i][j] += dp[i-1][j-1];
        		}
        	}
        }
        return dp[s.length()][t.length()];
    }
	
	
}
