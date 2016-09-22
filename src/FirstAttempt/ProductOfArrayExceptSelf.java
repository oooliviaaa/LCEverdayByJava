package FirstAttempt;

public class ProductOfArrayExceptSelf {

	// http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
	// solution 1, o(n) space
	public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        
        for (int i = 0; i < nums.length-1; i++) {
        	left[i+1] = left[i] * nums[i];
        }
        for (int j = nums.length-1; j > 0; j--) {
        	right[j-1] = right[j] * nums[j];
        }
        
        // multiply
        for (int i = 0; i < nums.length; i++) {
        	res[i] = left[i] * right[i];
        }
        
        return res;
    }
	
	
	//////////////////
	// solution 2, o(1) space
	public int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		
		for (int i = 0; i < nums.length-1; i++) {
			res[i+1] = res[i] * nums[i];
		}
		
		int right = 1;
		for (int j = nums.length-1; j >= 0; j--) {
			res[j] = right * res[j];
			right = right * nums[j];
		}
		
		return res;
	}
	
}
