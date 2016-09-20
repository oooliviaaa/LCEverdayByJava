package FirstAttempt;

public class SurroundedRegions {

	// http://www.cnblogs.com/springfor/p/3869853.html
	/**
	 * 思路就是先对四周的O进行特殊处理，用DFS/BFS走，把所有这个O连接的O（包括这个O）都涂成#。
	 * 这样子，对于原来的棋盘来说，没有变成#的O就是四周没有被O污染的，四周都是X，那么对其变成X。
	 * 而所有#就是那些原来是O但是不是四周都被X包围的，把它们再还原成O。
	 * */
	private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
	
	public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
        	fill(board, i, 0);
        	fill(board, i, col-1);
        }
        
        for (int j = 0; j < col; j++) {
        	fill(board, 0, j);
        	fill(board, row-1, j);
        }
        
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (board[i][j] == '#') {
        			board[i][j] = 'o';
        		} else if (board[i][j] == 'o'){
        			board[i][j]='x';
        		}
        	}
        }
    }
	
	private void fill(char[][] board, int i, int j) {
		if (board[i][j] != 'o') return;
		
		board[i][j] = '#';
		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x < 0 || x >= board.length || y < 0 || y > board[0].length) continue;
			fill(board, x, y);
		}
	}
	
	public static void main(String[] args) {
		//char[][] board = {{'x', 'x', 'x', 'x'}, {'x', 'o', 'o', 'x'}, {'x', 'x', 'o', 'x'}, {'x', 'o', 'x', 'x'}};
		char[][] board = {{'x', 'x', 'x'}, {'x', 'o', 'x'}, {'x', 'x', 'x'}};
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		
		for (char[] bo : board) {
			for (char b : bo) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}
