package FirstAttempt;

public class GameOfLife {

	
	// https://segmentfault.com/a/1190000003819277
	public void gameOfLife(int[][] board) {
	
		if (board == null || board.length == 0 || board[0].length == 0) return;
		int row = board.length;
		int col = board[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int alive = 0;
				if (i > 0) { // top is available
					alive += (board[i-1][j] == 1 || board[i-1][j] == 2) ? 1 : 0;
				}
				if (i < row-1) { // bottom is available
					alive += (board[i+1][j] == 1 || board[i+1][j] == 2) ? 1 : 0;
				}
				if (j > 0) { // left is available
					alive += (board[i][j-1] == 1 || board[i][j-1] == 2) ? 1 : 0;
				}
				if (j < col-1) { // right is available
					alive += (board[i][j+1] == 1 || board[i][j+1] == 2) ? 1 : 0;
				}
				if (i > 0 && j > 0) {  // top left corner is available 
					alive += (board[i-1][j-1] == 1 || board[i-1][j-1] == 2) ? 1 : 0;
				}
				if (i > 0 && j < col-1) { // top right corner is available
					alive += (board[i-1][j+1] == 1 || board[i-1][j+1] == 2) ? 1 : 0;
				}
				if (i < row-1 && j > 0) { // bottom left corner is available
					alive += (board[i+1][j-1] == 1 || board[i+1][j-1] == 2) ? 1 : 0;
				}
				if (i < row-1 && j < col-1) { // bottom right corner is available
					alive += (board[i+1][j+1] == 1 || board[i+1][j+1] == 2) ? 1 : 0;
				}
				
				if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
					board[i][j] = 2;
				} else if (board[i][j] == 0 && alive == 3) {
					board[i][j] = 3;
				}
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = board[i][j] % 2;
			}
		}
	}
}
