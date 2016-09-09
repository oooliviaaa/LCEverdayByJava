package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	// http://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
	// solution 2: binary search
	// 当遇到一个比之前的数小的数时，从list中找到比本数大的数里最小的那个，将他replace成新来的这个小一些的数。
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<Integer>(); 
        
        for (int num : nums) {
        	if (list.isEmpty() || list.get(list.size()-1) < num) {
        		list.add(num);
        	} else {
        		int pos = findCorrectPosition(list, num);
        		list.set(pos, num);
        	}
        }
        return list.size();
    }
	
	private int findCorrectPosition(List<Integer> list, int num) {
		int i = 0;
		int j = list.size() - 1;
		while (i < j) {
			int mid = (i+j) / 2;
			if (list.get(mid) < num) {
				i = mid+1;
			} else {
				j = mid;  ///////// !!!!!
			}
		}
		return j;
	}
	
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = new int[]{9,1,5,6,2,3,4,7,20}; //这个例子里，2将5replace掉，3将6replace掉，这样之后的4就会被加入list里，使得结果更长。
		int res = lis.lengthOfLIS(nums);
		System.out.println(res);
	}
}
