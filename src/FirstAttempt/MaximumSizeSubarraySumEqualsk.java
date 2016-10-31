package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {

	/**
	 * // https://segmentfault.com/a/1190000005771068
	 * 一边扫描数组生成hashmap一边找和，这样能确保找的都是前面的；
	 * 同时如果遇到key重复了，先记录下当前sum是否可以找到和为k，
	 * 可以的话记录max,然后我们丢掉这个key,保留最早的那个，因为最早的可以生成的size更大，
	 * 当前这个我们也已经examine过了。
	 * 
	 * http://www.cnblogs.com/EdwardLiu/p/5104280.html
	 * Use a HashMap to keep track of the sum from index 0 to index i, use it as the key, and use the current index as the value
	 * */
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int max = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();  // key:第0到第i-1 elements的和; value:到第i个数
        int sum = 0;
        hm.put(0, -1);   ///// !!!!! 从某个index为i的数往前一共有i-(-1)=i+1个数
        for (int i = 0; i < nums.length; i++) {
        	int cur = nums[i];
        	sum += cur;
        	if (!hm.containsKey(sum)) {
        		hm.put(sum, i);
        	}
        	
        	int lookfor = sum - k;
        	if (hm.containsKey(lookfor)) {
        		max = Math.max(max, i-hm.get(lookfor));
        	}
        }
        return max;
    }
}
