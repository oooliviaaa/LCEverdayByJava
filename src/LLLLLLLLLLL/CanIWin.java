package LLLLLLLLLLL;

public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
			return false;
		}
		
		boolean[] used = new boolean[maxChoosableInteger+1];
		return helper(maxChoosableInteger, desiredTotal, used);
	}
	
	private boolean helper(int maxNum, int sum, boolean[] used) {
		if (sum <= 0) {
			return false;
		}
		
		for (int i = 1; i <= maxNum; i++) {
			if (used[i]) continue;
			used[i] = true;
			boolean oppowin = helper(maxNum, sum-i, used);
			used[i] = false;
			
			if (oppowin) {
				return false;
			}
		}
		return false;
	}
	
}
