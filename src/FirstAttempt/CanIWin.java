package FirstAttempt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanIWin {

	// https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation
	/** with memory o(2^n)
	 * Since in the problem statement, it says maxChoosableInteger will not be larger than 20, 
	 * which means the length of our boolean[] array will be less than 20. 
	 * Then we can use an Integer to represent this boolean[] array. How?
	 * Say the boolean[] is {false, false, true, true, false}, 
	 * then we can transfer it to an Integer with binary representation as 00110. 
	 * Since Integer is a perfect choice to be the key of HashMap, then we now can "memorize" the sub-problems using Map<Integer, Boolean>.
	 * */
	boolean[] used;
	Map<Integer, Boolean> previousResults;
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
		
		used = new boolean[maxChoosableInteger+1];
        previousResults = new HashMap<Integer, Boolean>();  // 记录无论是自己还是对手，遇到used是这种情况时的最终结果（true:赢，false:输）
        
        return helper(desiredTotal);
    }
	
	private boolean helper(int sum) {
		if (sum <= 0) return false;
		int key = getFormat(used);
		if (previousResults.containsKey(key)) {
			return previousResults.get(key);
		}
		
		for (int i = 1; i < used.length; i++) {
			if (used[i]) continue;
			used[i] = true;
			boolean oppoWin = helper(sum - i);
			used[i] = false;
			
			if (!oppoWin) {
				previousResults.put(key, true); // for this key, the result will be can win
				return true;
			}
		}
		 
		previousResults.put(key, false);  // for this key, the result will be can't win
		return false;
	}
	
	private int getFormat(boolean[] array) {
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			res <<= 1;
			if (array[i]) res |= 1;
		}
		return res;
	}
}
