package FirstAttempt;

import java.util.Arrays;

public class MaximumGap {

	// http://www.programcreek.com/2014/03/leetcode-maximum-gap-java/
	// bucket sort: time of O(n) and space O(n)
	/**
	 * Suppose there are N elements and they range from A to B.
	 * Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)].
	 * Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket.
	 * for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.
	 * Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.
	 * For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
	 * */
	class Bucket {
	    int low;
	    int high;
	    public Bucket() {
	        low = -1;
	        high = -1; 
	    }
	}
	
	
	public int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2){
	        return 0;
	    }
		
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		
		double interval = (double)nums.length / (max - min); ///// double !!!!!
		
		// initialize an array of buckets
		Bucket[] buckets = new Bucket[nums.length+1];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}
		
		//distribute every number to a bucket array
		for (int i = 0; i < nums.length; i++) {
			int index = (int)(interval * (nums[i] - min));  /// cast back to int 记得加括号!!!!!
			Bucket b = buckets[index];
			if (b.low == -1) {
				b.low = nums[i];
				b.high = nums[i];
			} else {
				b.low = Math.min(b.low, nums[i]);
				b.high = Math.max(b.high, nums[i]);
			}
		}
		
		int res = 0;
		int pre = buckets[0].high;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].low != -1) {
				int gap = buckets[i].low - pre;
				res = Math.max(gap, res);
				pre = buckets[i].high;
			}
		}
		return res;
    }
	
	
	
	
	
	//////////////////////
	// [不好]投机取巧办法, 先排序，得到有序数组，然后再对相邻元素作差，找出差最大的
	public int maximumGap2(int[] num) {
        if(num.length<2) return 0;
        Arrays.sort(num);; //O(nlogn)
        int gap=-1;
        for(int i=1;i<num.length;i++){
            gap=Math.max(gap,num[i]-num[i-1]);
        }
        return gap;
    }
}
