package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	// http://www.jiuzhang.com/solutions/subsets-ii/
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> tmp, List<List<Integer>> res) {
        if (index >= nums.length) return;
        
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            helper(nums, i+1, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
}