package FirstAttempt;

import java.util.Random;

public class RandomPickIndex {

	/** http://blog.csdn.net/mebiuw/article/details/52511992
	 * 
	 * 这道题指明了我们不能用太多的空间，那么省空间的随机方法只有水塘抽样了，
	 * LeetCode之前有过两道需要用这种方法的题目Shuffle an Array和Linked List Random Node。
	 * 
	 * 那么如果了解了水塘抽样，这道题就不算一道难题了，我们定义两个变量，计数器cnt和返回结果res，
	 * 我们遍历整个数组，如果数组的值不等于target，直接跳过；
	 * 如果等于target，计数器加1，
	 * 然后我们在[0,cnt]范围内随机生成一个数字，如果这个数字是0，我们将res赋值为i即可
	 * */
	int[] nums;
	Random random;
	
	public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	int cur = nums[i];
        	if (target == cur) {
        		count++;
        		if (random.nextInt(count) == 0) {
        			res = i;
        		}
        	}
        }
        return res;
    }
}
