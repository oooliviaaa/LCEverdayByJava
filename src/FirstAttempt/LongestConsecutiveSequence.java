package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	
	// requires O(n) complexity --> hashmap
	public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int res = 1;
        for (int n : nums) {
        	set.add(n);
        }
        
        for (int n : nums) {
        	int small = n-1;
        	int large = n+1;
        	int count = 1;
        	
        	while (set.contains(small)) {
        		count++;
        		set.remove(small);
        		small--;
        	}
        	
        	while(set.contains(large)) {
        		count++;
        		set.remove(large);
        		large++;
        	}
        	
        	res = Math.max(res, count);
        	set.remove(n);   ///// remove 出去，减少重复计算，其实也可以不remove啦。。。
        }
        return res;
    }
}
