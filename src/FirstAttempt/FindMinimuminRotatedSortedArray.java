package FirstAttempt;

public class FindMinimuminRotatedSortedArray {

	// http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/
	// recursion
	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}
	 
	public int findMin(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		if (right - left == 1) {  ///// !!!!!
			return Math.min(nums[left], nums[right]);
		}
		if (nums[left] < nums[right]) {  /////  根本没有rotate!!!!!
			return nums[left];  
		}
		
		int mid = (left + right) / 2;
		if (nums[mid] < nums[left]) {
			return findMin(nums, left, mid);
		} else {
			return findMin(nums, mid, right);
		}
	}
	
	//////////////////////
	//Java Solution 2 - Iteration

	public int findMin_Iteration(int[] nums) {
	    if(nums==null || nums.length==0)
	        return -1;
	 
	    if(nums.length==1)
	        return nums[0];
	 
	    int left=0;
	    int right=nums.length-1;
	 
	    //not rotated
	    if(nums[left]<nums[right])
	        return nums[left];
	 
	    while(left <= right){
	        if(right-left==1){
	            return nums[right];
	        }
	 
	        int m = left + (right-left)/2;
	 
	        if(nums[m] > nums[right])
	            left = m;
	        else
	            right = m;
	    }
	 
	    return nums[left];
	}
}
