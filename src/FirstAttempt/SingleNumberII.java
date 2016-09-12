package FirstAttempt;

public class SingleNumberII {

	// http://www.cnblogs.com/springfor/p/3870863.html
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	for (int j = 0; j < 32; j++) {
        		if ((num >> j & 1) == 1) {
        			count[j] += 1;
        		}
        	}
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
        	res += (count[i] % 3) << i;
        }
        return res;
    }
}
