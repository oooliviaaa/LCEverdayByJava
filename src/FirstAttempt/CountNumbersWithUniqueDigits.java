package FirstAttempt;

public class CountNumbersWithUniqueDigits {

	// https://discuss.leetcode.com/topic/48001/backtracking-solution/2
	// backtracking
	public int countNumbersWithUniqueDigits(int n) {
        int count = 1; // x == 0
        long max = (long) Math.pow(10, n);
        
        boolean[] used = new boolean[10];  // 记录number 1~9 is used or not
        for (int i = 1; i < 10; i++) {  // 第一个数字只能是1~9
        	used[i] = true;
        	count += dfs(i, used, max);
        	used[i] = false;
        }
        return count;
    }
	
	private int dfs(int prev, boolean[] used, long max) {
		int count = 0;
		
		if (prev < max) {   ///// 只要小于max就是一个答案
			count++;
		} else {
			return count;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (!used[i]) {
				used[i] = true;
				int nextPrev = 10 * prev + i;
				count += dfs(nextPrev, used, max);  ///// !!!!!
				used[i] = false;
			}
		}
		return count;
	}
}
