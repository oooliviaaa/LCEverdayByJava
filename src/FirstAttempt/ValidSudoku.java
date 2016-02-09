package FirstAttempt;

import java.util.Arrays;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[] visited = new boolean[9];
        
        // row
        for(int i = 0; i < 9; i++) {
        	Arrays.fill(visited, false);
        	for(int j = 0; j < 9; j++) {
        		if(!isValid(board[i][j], visited)){
        			return false;
        		}
        	}
        }
        
        // col
        for(int j = 0; j < 9; j++) {
        	Arrays.fill(visited, false);
        	for(int i = 0; i < 9; i++) {
        		if(!isValid(board[i][j], visited)) {
        			return false;
        		}
        	}
        }
        
        // sub-matrix
        for(int i = 0; i < 9; i += 3) {  // 0, 3, 6 row
        	for(int j = 0; j < 9; j += 3) {  // 0, 3, 6, col
        		Arrays.fill(visited, false);
        		for(int k = 0; k < 9; k++) {
        			if(!isValid(board[i+k/3][j+k%3], visited)){   /////////////////////
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
	
	private boolean isValid(char digit, boolean[] visited){
		if(digit == '.') return true;
		int c = digit - '0';   //////////////////////////////////////
		if(c < 1 || c > 9 || visited[c-1]) return false;
		visited[c-1] = true;
		return true;
	}
}
