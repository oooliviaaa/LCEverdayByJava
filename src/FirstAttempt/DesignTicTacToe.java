package FirstAttempt;

import java.util.Arrays;

public class DesignTicTacToe {

	int[][] board;
	
    public DesignTicTacToe(int n) {
        board = new int[n][n];
        for (int[] b : board) {
        	Arrays.fill(b, 0);  /// 不能直接fill in board，因为他是2维的，其elements是array，不能直接fill 0；
        }
    }
    
    /** way 1: o(n) 
     * Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (board[row][col] != 0) {
        	return 0;
        }
        
        board[row][col] = player;
        int len = board.length;
        boolean ver = true;    // 垂直
        boolean hor = true;    // 平行方向
        boolean gra = true;    // 对角线
        boolean regra = true;  // 反对角线
        
        for (int i = 0; i < len; i++) {
        	if (board[i][col] != player) ver = false;
        	if (board[row][i] != player) hor = false;
        	if (board[i][i] != player) gra = false;
        	if (board[i][len-i-1] != player) regra = false;
        }
        
        return (ver || hor || gra || regra) ? player : 0;
    	
    }
    
    
    public static void main(String[] args) {
    	DesignTicTacToe dt = new DesignTicTacToe(4);
    	int res = dt.move(0, 0, 1);
    	res = dt.move(1, 1, 1);
    	res = dt.move(1, 1, 1);
    	System.out.println(res);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

