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


    /////////////////
    // only output nums
    public int getNumSubset(int[] nums) {
        return helper2(nums, 0) + 1;
    }

    private int helper2(int[] nums, int index) {
        if (index >= nums.length) return 0;
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            count += helper2(nums, i+1) + 1;
        }
        return count;
    }

    public static void main(String[] args) {
    	Subsets s = new Subsets();
    	int[] nums = new int[]{1,2,3,4};
    	int res = s.getNumSubset(nums);
    	List<List<Integer>> real = s.subsets(nums);
    	System.out.println("res: " + res + " real: " + real.size());
    	for (List<Integer> re : real) {
    		for (int r : re) {
    			System.out.print(r + " ");
    		}
    		System.out.println();
    	}
    }

}
