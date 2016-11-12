package LLLLLLLLL;

import java.util.Arrays;

public class MinimumNumOfCoins {

	public int minimumNumber(int[] values, int sum) {
		if (values == null || values.length == 0 || sum == 0) {
			return 0;
		}
		
		int[] dp = new int[sum+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int amount = 1; amount <= sum; amount++) {
			for (int i = 0; i < values.length; i++) {
				int cur = values[i];
				if (cur < amount) {
					dp[i] = Math.min(dp[i], dp[amount - cur] + 1);
				}
			}
		}
		return dp[sum];
	}
}
