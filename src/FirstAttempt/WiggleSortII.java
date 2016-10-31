package FirstAttempt;

import java.util.Arrays;

public class WiggleSortII {

	// http://buttercola.blogspot.com/2016/01/leetcode-wiggle-sort-ii.html
	/** solution 1
	 * 难点是会有相等的元素，而要求相邻元素除了wiggle外，不能相等。那么就不能取排序后相邻的元素交换，而要和后面的元素交换
	 * 
	 * solution 1: O(nlogn)时间排序+O(n)空间辅助数组解法：
	 * 1. 对原数组排序，得到排序后的辅助数组snums
	 * 2. 对原数组的偶数位下标填充snums的末尾元素
	 * 3. 对原数组的奇数位下标填充snums的末尾元素
	 * */
	
	public void wiggleSort(int[] nums) {
       if (nums == null || nums.length <= 1) return;
       
       Arrays.sort(nums);
       int len = nums.length;
       int[] tmp = new int[len];
       
       int left = (len-1) / 2;
       int right = len-1;
       
       for (int i = 0; i < len; i++) {
    	   if (i % 2 == 0) {
    		   tmp[i] = nums[left--];
    	   } else {
    		   tmp[i] = nums[right--];
    	   }
       }
       System.arraycopy(tmp, 0, nums, 0, len);
    }
	
	/////////////////////////
	
	
	/**
	 * solution 2: O(n)时间复杂度+O(1)空间复杂度解法：
	 * 1. 使用O(n)时间复杂度的quickSelect算法，从未经排序的数组nums中选出中位数mid
	 * 2. 参照解法I的思路，将nums数组的下标x通过函数idx()从[0, 1, 2, ... , n - 1, n] 映射到 [1, 3, 5, ... , 0, 2, 4, ...]，得到新下标ix
	 * 3. 以中位数mid为界，将大于mid的元素排列在ix的较小部分，而将小于mid的元素排列在ix的较大部分。
	 * 详见：https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing
	 * http://liveasatree.blogspot.com/2016/01/leetcode-wiggle-sort-ii.html
	 * */
	public void wiggleSort2(int[] nums) {
		
	}
	
	
}
