package LLLLLLLLL;

public class The100Game {

	// file:///Users/yaolin/Dropbox/%E9%9D%A2%E7%BB%8F/%E9%A2%86%E8%8B%B1/CA1/100++%20-%20Engineering%20-%20LinkedIn%20Corporate%20Wiki.htm
	
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) throws Exception {
		int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (maxSum < desiredTotal) {
			throw new Exception("no one can win");
		}
		
		boolean[] usedNums = new boolean[maxChoosableInteger+1];
		return canWin(0, maxChoosableInteger, desiredTotal, usedNums);
	}
	
	private boolean canWin(int curSum, int maxChoosableInteger, int desiredTotal, boolean[] usedNums) {
		if (curSum >= desiredTotal) {
			return false;
		}
		
		for (int i = 1; i <= maxChoosableInteger; i++) {
			if (usedNums[i]) continue;
			
			usedNums[i] = true;
			boolean oppoWin = canWin(curSum+i, maxChoosableInteger, desiredTotal, usedNums);
			usedNums[i] = false;
			
			if (!oppoWin) {
				return true;
			}
		}
		return false;
	}
}
