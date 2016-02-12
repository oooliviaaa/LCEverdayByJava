package FirstAttempt;

public class FirstMissingPositive {

	// http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        
        for(int i = 0; i < nums.length; i++) {
        	while(nums[i] != i) {  // when the ith element is not i  --> no loop
        		int cur = nums[i];
        		
        		// no need to swap when ith element is out of range [0,n]
        		if(cur < 0 || cur >= nums.length) break;
        		
        		//handle duplicate elements --> loop
        		if(cur == nums[cur]) break;
        		
        		// swap elements
        		nums[i] = nums[cur];
        		nums[cur] = cur; 
        		for(int n : nums) System.out.print(n);
        	}
        }
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != i) return i;
        }
        return nums.length;   // otherwise, return the biggest num+1
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{-1,2,5,1,1,3,6,8,7};
		FirstMissingPositive fm = new FirstMissingPositive();
		int res = fm.firstMissingPositive(nums);
		System.out.println(res);
	}
}
