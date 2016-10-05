package FirstAttempt;

public class PaintFence {

	// https://segmentfault.com/a/1190000003790650
	/**
	 * 根据题意，不能有超过连续两根柱子是一个颜色，也就意味着第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。
	 * 如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。
	 * 假设dp[1]是第一根柱子及之前涂色的可能性数量，dp[2]是第二根柱子及之前涂色的可能性数量，则dp[3]=(k-1)*dp[1] + (k-1)*dp[2]。
	 * 
	 * 递推式有了，下面再讨论下base情况，所有柱子中第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。
	 * */
	public int numWays(int n, int k) {
		// 因为dp[i]只与dp[i-1]和dp[i-2]有关，所欲dp只要三位就够了。
		// 当n=0时返回0
        int dp[] = {0, k , k*k, 0};
        if (n <= 2){
            return dp[n];
        }
        
        for (int i = 3; i <= n; i++) {
        	dp[3] = (k - 1) * (dp[1] + dp[2]);
        	
        	// 向前挪一位
        	dp[1] = dp[2];
        	dp[2] = dp[3];
        }
        return dp[3];
    }
}
