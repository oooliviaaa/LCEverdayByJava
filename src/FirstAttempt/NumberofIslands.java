package FirstAttempt;

public class NumberofIslands {

	/*
	 * DFS、BFS。只要遍历一遍，碰到一个1，就把它周围所有相连的1都标记为非1，这样整个遍历过程中碰到的1的个数就是所求解
	 * */
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char c = grid[i][j];
				if (c != '1') {
					continue;
				}
				count++;
				dfs(grid, i, j);
			}
		}
		return count;
    }
	
	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
	}
}
