package LLLLLLLLL;

public class SearchInRotateArrayWithDup {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) return true;
			
			if (nums[mid] < nums[left]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid+1;
				} else {
					right = mid-1;
				}
			} else if (nums[mid] > nums[left]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid-1;
				} else {
					left = mid+1;
				}
			} else {  ///// 当中间值与边缘值相等时，让left往后移动，忽略掉这个相同点!!!
				left++;
			}
		}
		return false;
	}
}
