package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> tmp, List<List<Integer>> res) {
        if (index >= nums.length) return;
        
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            helper(nums, i+1, tmp, res);
            tmp.remove(tmp.size()-1);
        }
	}
}
