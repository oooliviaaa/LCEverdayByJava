package FirstAttempt;

public class IntegerBreak {

	/**
	 * Let dp[i] to be the max production value for breaking the number i. 
	 * Since dp[i+j] can be i*j, dp[i+j] = max(max(dp[i], i) * max(dp[j], j)), dp[i+j]).
	 * */
	public int integerBreak(int n) {
        int[] dp = new int[n+1];
        
        for (int i = 1; i <= n; i++) {  // 最大是i=n-1, j=1, 使得i+j=n
        	for (int j = 1; j <= i; j++) {  // j的值不能大于i
        		if (i+j <= n) {   ///// 要check会不会out of bound !!!!!
        			dp[i+j] = Math.max(dp[i+j], Math.max(dp[i], i) * Math.max(dp[j], j));
        		}
        	}
        }
        return dp[n];
    }
}
