package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

	// https://kennyzhuang.gitbooks.io/algorithms-collection/content/count_of_smaller_numbers_after_self.html
	
	// 1. Solution IV: Binary search
	/**
	 * 首先可以使用用二分搜索法，思路是将给定数组从最后一个开始，用二分法插入到一个新的数组，
	 * 这样新数组就是有序的，那么此时该数字在新数组中的坐标就是原数组中其右边所有较小数字的个数
	 * */
	public List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        
        for (int i = nums.length-1; i >= 0; i--) {
        	int num = nums[i];
        	int index = findIndex(sorted, num);
        	res[i] = index;
        	sorted.add(index, num);
        	
        }
        return Arrays.asList(res);
    }
	
	private int findIndex(List<Integer> sorted, int target) {
		if (sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size()-1;
		if (sorted.get(start) >= target) return 0;
		if (sorted.get(end) < target) return end+1;
		
		while (start + 1 < end) {     ///// !!!!!
			int mid = (start + end) / 2;
			if (sorted.get(mid)  < target) {
				start = mid+1;
			} else {
				end = mid;           ///// !!!!!
			}
		}
		
		if (sorted.get(start) >= target) return start;
	    return end;
	}
	
}
