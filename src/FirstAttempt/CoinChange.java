package FirstAttempt;

import java.util.Arrays;

public class CoinChange {

	
	/**http://www.programcreek.com/2015/04/leetcode-coin-change-java/   --> 这个方法现在会out of bound，所以变形一下
	 * Let dp[v] to be the minimum number of coins required to get the amount v. 
	 * dp[i+a_coin] = min(dp[i+a_coin], dp[i]+1) if dp[i] is reachable. 
	 * dp[i+a_coin] = dp[i+a_coin] is dp[i] is not reachable. 
	 * We initially set dp[i] to be MAX_VALUE. 
	 * 
	 * https://discuss.leetcode.com/topic/64092/java-solution-with-explanation
	 * */
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount == 0) return 0;
		
		int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i <= amount; i++) {
        	for (int coin : coins) {
        		if (i >= coin && dp[i-coin] != Integer.MAX_VALUE) {
        			dp[i] = Math.min(dp[i], dp[i-coin]+1);
        		}
        	}
        }
        return dp[amount] >= Integer.MAX_VALUE ?  -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1,2147483647};
		CoinChange cc = new CoinChange();
		int res = cc.coinChange(coins, 2);
		
		System.out.println(res);
	}
}
