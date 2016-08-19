package FirstAttempt;


public class CombinationSumIV {

	// https://www.hrwhisper.me/leetcode-combination-sum-iv/
	public int combinationSum4(int[] nums, int target) {
        
		int[] dp = new int[target+1];   // int[] is prefilled by 0
		dp[0] = 1;
		
		for (int i = 0; i < target; i++) {  ///// all the nums are positive, so i starts from 0 to target-1 !!!!!
			for (int num : nums) {
				if (i+num <= target) {
					dp[i+num] += dp[i];  // previous value filled in dp[i+num] + num less dp[i] value
				}
			}
		}
		return dp[target];
	}
}
