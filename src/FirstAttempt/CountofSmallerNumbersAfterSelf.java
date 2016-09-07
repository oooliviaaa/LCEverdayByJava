package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

	// https://kennyzhuang.gitbooks.io/algorithms-collection/content/count_of_smaller_numbers_after_self.html
	
	// 1. Solution IV: Binary search
	/**
	 * 首先可以使用用二分搜索法，思路是将给定数组从最后一个开始，用二分法插入到一个新的数组，
	 * 这样新数组就是有序的，那么此时该数字在新数组中的坐标就是原数组中其右边所有较小数字的个数
	 * */
	public List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        
        for (int i = nums.length-1; i >= 0; i--) {
        	int num = nums[i];
        	int index = findIndex(sorted, num);
        	res[i] = index;
        	sorted.add(index, num);
        	
        }
        return Arrays.asList(res);
    }
	
	private int findIndex(List<Integer> sorted, int target) {
		if (sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size()-1;
		if (sorted.get(start) >= target) return 0;
		if (sorted.get(end) < target) return end+1;
		
		while (start + 1 < end) {     ///// !!!!!
			int mid = (start + end) / 2;
			if (sorted.get(mid)  < target) {
				start = mid+1;
			} else {
				end = mid;           ///// !!!!!
			}
		}
		
		if (sorted.get(start) >= target) return start;
	    return end;
	}
	
	/////////////////
	// https://discuss.leetcode.com/topic/31422/easiest-java-solution/2
	// Solution III: Binary search tree
	/**
	 * Traverse from nums[len - 1] to nums[0], and build a binary search tree, which stores:
	 * 1. val: value of nums[i]
	 * 2. count: if val == root.val, there will be count number of smaller numbers on the right
	 * */
	class TreeNode {
		TreeNode left; 
		TreeNode right;
		int val;
		int count = 1;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<Integer> countSmaller_BST(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		res.add(0);
		for(int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			res.add(count);
		}
		Collections.reverse(res);
		return res;
	}

	public int insertNode(TreeNode root, int val) {
		int thisCount = 0;
		while(true) {
			if(val <= root.val) {
				root.count++;      ///// !!!!!
				if(root.left == null) {
					root.left = new TreeNode(val); 
					break;
				} else {
					root = root.left;
				}
			} else {
				thisCount += root.count;   ///// !!!!!
				if(root.right == null) {
					root.right = new TreeNode(val); 
					break;
				} else {
					root = root.right;
				}
			}
		}
		return thisCount;
	}
	
	
	
}
