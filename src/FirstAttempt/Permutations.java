package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(nums == null || nums.length == 0) return res;
		processPermute(nums, 0, nums.length-1, res);
		return res;
    }
	
	private void processPermute(int[] nums, int bg, int ed, ArrayList<ArrayList<Integer>> res) {
		if(bg == ed) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int n : nums) tmp.add(n);
			res.add(tmp);
		}
		else {
			for(int i = bg; i <= ed; i++) {
				if(isSwapable(nums, bg, i)) {
					swap(nums, bg, i);
					processPermute(nums, bg+1, ed, res);
					swap(nums, bg, i);
				}
			}
		}
	}
	
	private boolean isSwapable(int[] nums, int bg, int i) {
		for(int k = bg; k < i; k++) {
			if(nums[k] == nums[i]) return false;
		}
		return true;
	}
	
	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	void swap2(int[] num, int a, int b){
        if (a != b){
            num[a] = num[a] ^ num[b];
            num[b] = num[a] ^ num[b];
            num[a] = num[a] ^ num[b];
        }
    }
}
