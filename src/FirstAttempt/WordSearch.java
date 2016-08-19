package FirstAttempt;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        int row = board.length; 
        int col = board[0].length;
        
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean dfs(char[][] board, String word, int i, int j, int k) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
	        return false;
	    }
		
		char c = board[i][j];
		char w = word.charAt(k);
		
		if (c != w) return false;
		if (c == w && k == word.length()-1) return true;
		
		board[i][j] = '.';   /////// mark as visited !!!!!
		
		// top
		if (dfs(board, word, i-1, j, k+1) 
				|| dfs(board, word, i+1, j, k+1)
				|| dfs(board, word, i, j-1, k+1) 
				|| dfs(board, word, i, j+1, k+1)) return true;
		
		board[i][j] = c;   ///// recover for backfilling !!!!!
		return false;
	}
}
