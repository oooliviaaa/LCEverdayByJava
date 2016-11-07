package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {

	public List<List<Integer>> threeSum(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
        	if (i != 0 && nums[i-1] == nums[i]) {  ///// 去重
        		continue;
        	}
        	int p = i+1;
        	int q = nums.length-1;
        	int sum = nums[i] + nums[p] + nums[q];
        	if (sum == k) {
        		List<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(i); tmp.add(p); tmp.add(q);
        		res.add(tmp);
        	} else if (sum > k) {
        		q--;
        	} else {
        		p++;
        	}
        }
        return res;
    }
}
