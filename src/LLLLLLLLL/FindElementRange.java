package LLLLLLLLL;

public class FindElementRange {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return new int[]{-1, -1};
        }
        
        int p = binarySearch(nums, target);
        if(p == -1) return new int[]{-1, -1};
        
        int a = p, b = p;
        while(a >= 0) {
        	a--;
        	if(a < 0 || nums[a] != target) {
        		break;   // begin: a+1
        	}
        }
        
        while(b < nums.length) {
        	b++;
        	if(b >= nums.length || nums[b] != target) {
        		break;  // end: b-1
        	}
        }
        
        return new int[]{a+1, b-1};
        
    }
	
	private int binarySearch(int[] nums, int target) {
		int bg = 0;
		int ed = nums.length-1;
		
		while(bg <= ed) {
			int mid = (bg + ed) / 2;
			if(nums[mid] == target) return mid;
			else if(nums[mid] > target) ed = mid-1;
			else bg = mid+1;
		}
		return -1;
    }
}
