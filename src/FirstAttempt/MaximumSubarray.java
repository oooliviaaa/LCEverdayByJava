package FirstAttempt;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
		int sum = nums[0];
        int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) { ///////////// start from 1 !!!!!
			sum = Math.max(sum + nums[i], nums[i]);  /////////// include i or start from i !!!!!
			max = Math.max(sum, max);
		}
		return max;
    }
}
