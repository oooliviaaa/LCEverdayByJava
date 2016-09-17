package FirstAttempt;

public class HouseRobber {

	// http://www.programcreek.com/2014/03/leetcode-house-robber-java/
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);   ////// initialize !!!!!
        
        for (int i = 2; i < nums.length; i++) {
        	dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
