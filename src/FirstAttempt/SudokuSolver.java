package FirstAttempt;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
		solver(board);
    }
	
	public boolean solver(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == '.') {
					for(char k = '1'; k <= '9'; k++) {
						board[i][j] = k;  ////////convert int to char
						if(isValid(board, i, j) && solver(board)) return true;
						board[i][j] = '.';
					}
					return false;  ////// try 1~9, non is valid, so return false
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int i, int j) {
		
	}
}
