package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

	// http://www.programcreek.com/2014/05/leetcode-contains-duplicate-ii-java/
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	if (hm.containsKey(nums[i])) {
        		int pre = hm.get(nums[i]);
        		if (k >= i-pre) {
        			return true;
        		}
        	}
        	hm.put(nums[i], i);   ///// update position
        }
        return false;
    }
}
