package FirstAttempt;

public class MaximumProductSubarray {

	// o(1) extra space
	public int maxProduct(int[] nums) {
        int res = nums[0];
        if (nums == null || nums.length == 0) return 0;
        
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int preMax = max;
            int preMin = min;
            if (cur > 0) {
                max = Math.max(cur, cur * preMax);
                min = Math.min(cur, cur * preMin);
            } else {
                max = Math.max(cur, cur * preMin);
                min = Math.min(cur, cur * preMax);
            }
            res = Math.max(res, max);
        }
        return res;
    }
	
	
	///////////////
	// http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
	public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        
        int res = nums[0];
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	int cur = nums[i];
        	if (cur > 0) {
        		max[i] = Math.max(cur, cur * max[i-1]);
        		min[i] = Math.min(cur, cur * min[i-1]);
        	} else {
        		max[i] = Math.max(cur, cur * min[i-1]);
        		min[i] = Math.min(cur, cur * max[i-1]);
        	}
        	res = Math.max(res, max[i]);
        }
        return res;
    }
}
