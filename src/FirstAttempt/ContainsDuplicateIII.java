package FirstAttempt;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {

	// http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;
		
		SortedSet<Long> ts = new TreeSet<Long>();  ///// Long来防止overflow！详见下面的testcase
		for (int i = 0; i < nums.length; i++) {
			long cur = (long) nums[i];
			
			long leftBound = (long)cur - t;
			long rightBound =(long) cur + t + 1; //right boundary is exclusive, so +1;
			
			SortedSet<Long> subSet = ts.subSet(leftBound, rightBound);
			
			
			if (!subSet.isEmpty()) {
				return true;
			}
			
			ts.add(cur);
			
			if (i >= k) {
				ts.remove((long)nums[i-k]);
			}
		}
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,2147483647};  // 如果treeSet用Integer，碰到这个case就会overflow变成leftBound: -2147483647, rightBound: -2147483648
		ContainsDuplicateIII cd3= new ContainsDuplicateIII();
		boolean res = cd3.containsNearbyAlmostDuplicate(nums, 1, 2147483647);
		System.out.println(res);
	}
}
