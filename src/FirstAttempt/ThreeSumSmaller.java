package FirstAttempt;

import java.util.Arrays;

public class ThreeSumSmaller {

	// https://segmentfault.com/a/1190000003794736
	/**
	 * 解题思路和3SUM一样，也是先对整个数组排序，然后一个外层循环确定第一个数，然后里面使用头尾指针left和right进行夹逼，得到三个数的和。
	 * 如果这个和大于或者等于目标数，说明我们选的三个数有点大了，就把尾指针right向前一位（因为是排序的数组，所以向前肯定会变小）。
	 * 如果这个和小于目标数，那就有right - left个有效的结果。为什么呢？
	 * 因为假设我们此时固定好外层的那个数，还有头指针left指向的数不变，那把尾指针向左移0位一直到左移到left之前一位，这些组合都是小于目标数的。
	 * */
	public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        
        Arrays.sort(nums);  ///// !!!!!
        
        for (int i = 0; i < nums.length-2; i++) {
        	int first = nums[i];
        	int left = i+1;
        	int right = nums.length-1;
        	while (left < right) {
        		int second = nums[left];
        		int third = nums[right];
        		int sum = first + second + third;
        		if (sum >= target) {
        			right--;
        		} else {
        			// right - left个组合都是小于目标数的 !!!!!
                    res += right - left;
                    left++;
        		}
        	}
        }
        return res;
    }
}
