package FirstAttempt;

public class WiggleSort {

	// https://segmentfault.com/a/1190000003783283
	/**
	 * 交换法  时间 O(N) 空间 O(1)
	 * 
	 * 题目对摇摆排序的定义有两部分：
	 * 如果i是奇数，nums[i] >= nums[i - 1]
	 * 如果i是偶数，nums[i] <= nums[i - 1]
	 * 所以我们只要遍历一遍数组，把不符合的情况交换一下就行了。具体来说，如果nums[i] > nums[i - 1]， 则交换以后肯定有nums[i] <= nums[i - 1]。
	 * */
	public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
        	if ((i%2==1 && nums[i] < nums[i - 1]) || (i%2==0 && nums[i] > nums[i - 1])) {
        		int tmp = nums[i];
        		nums[i] = nums[i-1];
        		nums[i-1] = tmp;
        	}
        }
    }
}
