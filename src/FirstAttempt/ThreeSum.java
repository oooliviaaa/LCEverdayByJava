package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// http://www.programcreek.com/2012/12/leetcode-3sum/ --> O(n^2)
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3) return res;
        
        // sort the array.  Don't Forget!!!!!!!!
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
        	if (i > 0 && nums[i] == nums[i-1]) continue; // avoid duplicate
        	int neg = -nums[i];
        	int bg = i + 1;
        	int ed = nums.length - 1;
        	
        	while(bg < ed) {
        		if(neg == (nums[bg] + nums[ed])) {
        			List<Integer> tmp = new ArrayList<Integer>();
        			tmp.add(nums[i]);
        			tmp.add(nums[bg]);
        			tmp.add(nums[ed]);
        			
        			res.add(tmp);
        			
        			bg++;
        			ed--;
        			
        			// avoid duplicate
        			while(bg < ed && nums[bg] == nums[bg-1]) bg++;
        			while(bg < ed && nums[ed] == nums[ed+1]) ed--;
        		}
        		else if(nums[bg] + nums[ed] < neg) {
        			bg++;
        		}
        		else {
        			ed--;
        		}
        	}
        }
        return res;
    }
}
