package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSum2 {

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(candidates == null || candidates.length == 0) return res;
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		helper(candidates, 0, target, tmp, res);
		
		//remove duplicate lists
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(res);
		res.clear();
		res.addAll(set);
		
		return res;
    }
	
	private void helper(int[] nums, int index, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(cur));  ///// remember to use 'new'!!! otherwise the inside ArrayList<> will change
		}
		
		for(int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			helper(nums, i+1, target-nums[i], cur, res);  //same num can be used only once, so the index is i+1
			cur.remove(cur.size()-1);
		}
    }
}
