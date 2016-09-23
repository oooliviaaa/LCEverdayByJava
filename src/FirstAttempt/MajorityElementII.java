package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	// http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
	// Java Solution 2: Majority Vote. 
	// Time = O(n) and Space = O(1)
	/**
	 * 任意一个数组出现次数大于n/3的众数最多有两个
	 * 我们使用投票法的核心是找出两个候选众数进行投票，
	 * 需要两遍遍历，第一遍历找出两个候选众数，第二遍遍历重新投票验证这两个候选众数是否为众数即可，
	 * 由于这道题却没有这种限定，即满足要求的众数可能不存在，所以要有验证
	 * */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		Integer n = null;
		Integer m = null;
		
		int cn = 0;
		int cm = 0;
		
		for (int i = 0; i < nums.length; i++) { ///// 一定要exclusive!!!!!
			int cur = nums[i];
			if (n != null && cur == n) {
				cn++;
			} else if (m != null && cur == m) {
				cm++;
			} else if (cn == 0) {     /////////////// res 变换的时刻！！！！！
				n = cur;
				cn++;
			} else if (cm == 0) {     /////////////// res 变换的时刻！！！！！
				m = cur;
				cm++;
			} else {
				cn--;
				cm--;
			}
		}
		
		cn = cm = 0;  // 清零
		for (int i : nums) {
			if (i == n) cn++;
			else if (i == m) cm++;   ///// 一定要exclusive!!!!!
		}
		
		if (cn > nums.length / 3) res.add(n);
		if (cm > nums.length / 3) res.add(m);
		return res;
    }
}
