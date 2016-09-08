package FirstAttempt;

public class SearchinRotatedSortedArray {

	// http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
	public int search(int[] nums, int target) {
	    int left = 0;
	    int right= nums.length-1;
	 
	    while(left<=right){
	        int mid = left + (right-left)/2;
	        if(target==nums[mid])
	            return mid;
	 
	        if(nums[left]<=nums[mid]){
	            if(nums[left]<=target&& target<nums[mid]){
	                right=mid-1;
	            }else{
	                left=mid+1;
	            }
	        }else{
	            if(nums[mid]<target&& target<=nums[right]){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }    
	    }
	 
	    return -1;
	}
	
	
	////////////////
	// solution 2
	
	public int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        
        int bg = 0;
        int ed = nums.length-1;
        
        while(bg+1 < ed) {  ///////// make sure bg never exceed ed, so that make sure ed never less than 0
										////////////////// and bg never exceed nums.length-1

        	int mid = (bg + ed) / 2;
        	if(nums[mid] == target) return mid;
        	if(nums[mid] > nums[bg]) {  // mid is in the front of cutting point
        		if(nums[mid] >= target && target >= nums[bg]) {
        			ed = mid-1; 
        		}
        		else{
        			bg = mid+1;
        		}
        	}
        	else {
        		if(nums[mid] <= target && target <= nums[ed]) {
        			bg = mid+1;
        		}
        		else {
        			ed = mid-1;
        		}
        	}
        }
        if(nums[bg] == target) return bg;  ////////////in the end, when bg and ed are side by side with each other, check both
        if(nums[ed] == target) return ed;
        return -1;
    }
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{5,6,7,8,9,0,1,2,3,4};
		SearchinRotatedSortedArray sr = new SearchinRotatedSortedArray();
		int res0 = sr.search(nums, 0);
		int res1 = sr.search(nums, 2);
		System.out.println("res0 >>>" + res0);
		System.out.println("res1 >>>" + res1);

		int res2 = sr.search(nums, 9);
		int res3 = sr.search(nums, 7);
		System.out.println("res2 >>>" + res2);
		System.out.println("res3 >>>" + res3);

		int res4 = sr.search(nums, 23);
		System.out.println("res4 >>>" + res4);
		
	}
}
