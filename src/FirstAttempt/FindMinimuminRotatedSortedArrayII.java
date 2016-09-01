package FirstAttempt;

public class FindMinimuminRotatedSortedArrayII {

	// http://www.programcreek.com/2014/03/leetcode-find-minimum-in-rotated-sorted-array-ii-java/
	/**
	 * We only need to add one more condition, which checks if the left-most element and the right-most element are equal. 
	 * If they are we can simply drop one of them. 
	 * In my solution below, I drop the left element whenever the left-most equals to the right-most.
	 * */
	// recursion
	public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
	
	private int findMin(int[] nums, int left, int right) {
		if (left == right) return nums[left];
		if (right - left == 1) return Math.min(nums[left], nums[right]);   ///// !!!!!
		if (nums[left] < nums[right]) return nums[left];    ///// !!!!!
		
		if (nums[left] == nums[right]) {
			return findMin(nums, left+1, right);  ///// 丢掉left !!!!!
		}
		
		int mid = (left + right) / 2;
		if (nums[mid] >= nums[left]) { //////////  >= !!!!! for example [3,3,1], return 1
			return findMin(nums, mid, right);
		} else {
			return findMin(nums, left, mid);
		}
		
	}
	
	
	//////////////////// 
	// iteration
	public int findMin_Iteration(int[] nums) {
	    int i=0;
	    int j=nums.length-1;
	 
	    while(i<=j){
	 
	        //handle cases like [3, 1, 3]
	        while(nums[i]==nums[j] && i!=j){
	            i++;
	        }
	 
	        if(nums[i]<=nums[j]){
	            return nums[i];
	        }
	 
	        int m=(i+j)/2;
	        if(nums[m]>=nums[i]){
	            i=m+1;
	        }else{
	            j=m;
	        }
	    }
	 
	    return -1;
	}

}
