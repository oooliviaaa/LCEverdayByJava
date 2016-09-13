package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        
        Set<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
        	if (!hs.add(num)) {
        		return true;   // find dup
        	}
        }
        return false;
    }
}
