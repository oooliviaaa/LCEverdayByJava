package FirstAttempt;

public class HouseRobberII {

	// http://www.programcreek.com/2014/05/leetcode-house-robber-ii-java/
	/**
	 * There are two cases here 
	 * 1) 1st element is included and last is not included 
	 * 2) 1st is not included and last is included. 
	 * Therefore, we can use the similar dynamic programming approach to scan the array twice and get the larger value.
	 * */
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        
        int max1 = getMaxMoney(nums, 0, len-2);
        int max2 = getMaxMoney(nums, 1, len-1);
        
        return Math.max(max1, max2);
    }
	
	private int getMaxMoney(int[] nums, int start, int end) {
		if (start == end) return nums[start];
		
		int[] dp = new int[nums.length];  ///// 这样设计很方便填写!!!!!
		dp[start] = nums[start];
		dp[start+1] = Math.max(nums[start], nums[start+1]);
		
		for (int i = start+2; i <= end; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		return dp[end];
	}
}
