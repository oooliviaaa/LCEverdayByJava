package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	// http://www.programcreek.com/2013/02/leetcode-4sum-java/
	// A typical k-sum problem. Time is N to the power of (k-1) --> O(n^3)
	public List<ArrayList<Integer>> fourSum(int[] nums, int target) {
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length < 4) return res;
        
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>(); 
        for(int i = 0; i < nums.length - 3; i++) {
        	for(int j = i+1; j < nums.length - 2; j++) {
        		int bg = j+1;
        		int ed = nums.length-1;
        		while(bg < ed) {
        			int sum = nums[i] + nums[j] + nums[bg] + nums[ed];
        			if(sum == target) {
        				ArrayList<Integer> tmp = new ArrayList<Integer>();
        				tmp.add(nums[i]);
        				tmp.add(nums[j]);
        				tmp.add(nums[bg]);
        				tmp.add(nums[ed]);
        				
        				if(!hs.contains(tmp)) {
        					hs.add(tmp);
        					res.add(tmp);
        				}
        				bg++;
        				ed--;
        			}
        			else if(sum > target) ed--;
        			else bg++;
        		}
        	}
        }
        return res;
    }
}
