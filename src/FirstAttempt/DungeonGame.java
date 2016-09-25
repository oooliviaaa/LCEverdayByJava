package FirstAttempt;

public class DungeonGame {

	// http://www.programcreek.com/2014/03/leetcode-dungeon-game-java/
	/*
	 * This problem can be solved by using dynamic programming. 
	 * We maintain a 2-D table. h[i][j] is the minimum health value before he enters (i,j). 
	 * h[0][0] is the value of the answer. The left part is filling in numbers to the table.
	 * */
	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = Math.max(1, 1 - dungeon[row-1][col-1]);     ///// max !!!!!
        
        // initial last row
        for (int j = col-2; j >= 0; j--) {
        	dp[row-1][j] = Math.max(1, dp[row-1][j+1] - dungeon[row-1][j]);
        }
        
        // initial last column
        for (int i = row-2; i >= 0; i--) {
        	dp[i][col-1] = Math.max(1, dp[i+1][col-1] - dungeon[i][col-1]);
        }
        
        for (int i = row-2; i >= 0; i--) {
        	for (int j = col-2; j >= 0; j--) {
        		int toRight = Math.max(1, dp[i][j+1] - dungeon[i][j]);
        		int toDown = Math.max(1,  dp[i+1][j] - dungeon[i][j]);
        		dp[i][j] = Math.min(toRight, toDown);                   ///// min !!!!!
        	}
        }
        return dp[0][0];
        
    }
}
