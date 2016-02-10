package FirstAttempt;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        
        int bg = 0;
        int ed = nums.length - 1;
        
        while(bg <= ed) {
        	int mid = (bg + ed) / 2;
        	if(nums[mid] == target) return mid;
        	else if(nums[mid] < target) bg = mid+1;
        	else ed = mid-1;
        }
        return bg;
    }
}
