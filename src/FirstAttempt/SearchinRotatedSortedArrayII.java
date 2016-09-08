package FirstAttempt;

public class SearchinRotatedSortedArrayII {

	// http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/
	// 和1不同的是，当中间值与边缘值相等时，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。
    // 这一改变增加了时间复杂度，试想一个数组有同一数字组成{1，1，1，1，1}，target=2, 那么这个算法就会将整个数组遍历(worst case)，时间复杂度由O(logn)升到O(n)
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
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
			} else {  ///// 当中间值与边缘值相等时，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。 ！！！
				left++;
			}
		}
		return false;
    }
}
