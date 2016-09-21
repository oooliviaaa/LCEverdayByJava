package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			addResult(res, lower, upper);
			return res;
		}
		
		if (lower < nums[0]) {
			addResult(res, lower, nums[0]-1);
		}
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i-1] > 1) {  // 间隔超过一
				addResult(res, nums[i-1]+1, nums[i]-1);
			}
		}
		
		if (upper > nums[nums.length-1]) {
			addResult(res, nums[nums.length-1]+1, upper);
		}
		
		return res;
    }
	
	private void addResult(List<String> res, int low, int up) {
		String s;
		if (low == up) {
			s = "" + low;
		} else {
			s = low + "->" + up;
		} 
		res.add(s);
	}
	
	
	public static void main(String[] args) {
		int[] nums = {0,1,3,50,75};
		
		MissingRanges mr = new MissingRanges();
		List<String> res = mr.findMissingRanges(nums, 0, 99);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
