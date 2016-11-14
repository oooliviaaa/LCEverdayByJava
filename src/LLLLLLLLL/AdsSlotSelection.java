package LLLLLLLLL;

// house robber
public class AdsSlotSelection {

	public int maxAdsValue(int[] values) {
		int res = 0;
		if (values == null || values.length == 0) return res;
		
		int[] dp = new int[values.length];
		dp[0] = values[0];
		dp[1] = Math.max(values[0], values[1]);
		
		for (int i = 2; i < values.length; i++) {
			dp[i] = Math.max(dp[i-2] + values[i], dp[i-1]);
		}
		
		return dp[values.length - 1];
	}
}
