package FirstAttempt;

public class FindPeakElement {

	// http://blog.csdn.net/yangliuy/article/details/42417277
	// MIT 算法课第一节例题 - Binary Search
	public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
        	int mid = (left + right) / 2;
        	
        	if (nums[mid] > nums[mid+1]) {
        		right = mid;
        	} else {
        		left = mid+1;
        	}
        }
        return left;
    }
}
