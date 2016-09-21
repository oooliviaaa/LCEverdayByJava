package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) return res;
		
		int left = 0;
		int right = 1;
		
		while (right < nums.length) {
			while (right < nums.length && (nums[right] - nums[right-1] == 1)) {
				right++;
			}
			
			addResult(res, nums[left], nums[right-1]);
			left = right;
			right++;
		}
		
		if (left < nums.length) {
			addResult(res, nums[left], nums[right-1]);   // add the last one
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
}
