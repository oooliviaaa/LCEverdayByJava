package FirstAttempt;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        
        int i = 0; 
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
        	if (sum >= s) {
        		res = Math.min(res, j-i);
        		sum -= nums[i];
        		i++;           ///////// !!!!!
        	} else {
        		sum += nums[j];
        		j++;           ///////// !!!!! 
        	}
        }
        
        while (sum >= s) {    ///////// !!!!!
            res = Math.min(res, j-i);
            sum -= nums[i];
            i++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
