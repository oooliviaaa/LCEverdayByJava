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
			for(int i = bg; i <= ed; i++) {  // i必须从bg开始，这样当i=bg时，相当于不用换，这样也是一种permutation， see pic here: http://www.programcreek.com/2013/02/leetcode-permutations-java/
				if(isSwapable(nums, bg, i)) {
					swap(nums, bg, i);
					processPermute(nums, bg+1, ed, res);   ///// 下一个index还是从bg+1开始！！！！！
					swap(nums, bg, i);
				}
			}
		}
	}
	
	private boolean isSwapable(int[] nums, int bg, int end) {
		for(int k = bg; k < end; k++) {   // 主要是为了检查位于end的这个数之前有没有出现过，如果出现过就表示swap过了，会有重复    
			if(nums[k] == nums[end]) return false;
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
