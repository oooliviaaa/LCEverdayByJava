package FirstAttempt;

public class DesignTicTacToe_O1Solution {
	
	// https://discuss.leetcode.com/topic/44548/java-o-1-solution-easy-to-understand/2
	/**
	 * The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column. 
	 * Thus, we don't need to keep track of an entire n^2 board. 
	 * We only need to keep a count for each row and column. 
	 * If at any time a row or column matches the size of the board then that player has won.
	 * 
	 * To keep track of which player, I add one for Player1 and -1 for Player2. 
	 * There are two additional variables to keep track of the count of the diagonals. 
	 * Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.
	 * Also see a very similar answer that I believe had beaten me to the punch. 
	 * We came up with our solutions independently but they are very similar in principle.
	 * */
	
	private int[] rows;  // 每行的和
	private int[] cols;  // 每列的和
	private int diagonal;// 对角线
	private int antiDiagonal;//反对角线

	public DesignTicTacToe_O1Solution(int n) {
	    rows = new int[n];
	    cols = new int[n];
	}

	public int move(int row, int col, int player) {
	    int toAdd = player == 1 ? 1 : -1;
	    
	    rows[row] += toAdd;
	    cols[col] += toAdd;
	    if (row == col) {
	        diagonal += toAdd;
	    }
	    
	    if (col == (cols.length - row - 1)) {
	        antiDiagonal += toAdd;
	    }
	    
	    int size = rows.length;
	    if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
	        Math.abs(diagonal) == size  || Math.abs(antiDiagonal) == size) {
	        return player;
	    }
	    
	    return 0;
	}
}
