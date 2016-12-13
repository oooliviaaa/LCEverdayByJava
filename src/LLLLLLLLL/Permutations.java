package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        
        process(nums, 0, res);
        return res;
    }
    
    private void process(int[] nums, int start, List<List<Integer>> res) {
        if (start >= nums.length) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int n : nums) tmp.add(n);
            res.add(tmp);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (isSwapable(nums, start, i)) {
                swap(nums, start, i);
                process(nums, start+1, res);
                swap(nums, start, i);
            }
        }
    }
    
    private boolean isSwapable(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (nums[k] == nums[j]) {
                return false;
            }
        }
        return true;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	
	
	///////////////////////////
	
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
				if(isSwapable2(nums, bg, i)) {
					swap2(nums, bg, i);
					processPermute(nums, bg+1, ed, res);   ///// 下一个index还是从bg+1开始！！！！！
					swap2(nums, bg, i);
				}
			}
		}
	}
	
	private boolean isSwapable2(int[] nums, int bg, int end) {
		for(int k = bg; k < end; k++) {   // 主要是为了检查位于end的这个数之前有没有出现过，如果出现过就表示swap过了，会有重复    
			if(nums[k] == nums[end]) return false;
		}
		return true;
	}
	
	private void swap2(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	void swap3(int[] num, int a, int b){
        if (a != b){
            num[a] = num[a] ^ num[b];
            num[b] = num[a] ^ num[b];
            num[a] = num[a] ^ num[b];
        }
    }
	
	
	
	
	///////////////////////
	// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
	public List<List<Integer>> permute3(int[] nums) {
		   List<List<Integer>> list = new ArrayList<List<Integer>>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<Integer>(), nums);
		   return list;
		}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
	   if(tempList.size() == nums.length){
	      list.add(new ArrayList<Integer>(tempList));
	   } else{
	      for(int i = 0; i < nums.length; i++){ 
	         if(tempList.contains(nums[i])) continue; // element already exists, skip
	         tempList.add(nums[i]);
	         backtrack(list, tempList, nums);
	         tempList.remove(tempList.size() - 1);
	      }
	   }
	} 
}
