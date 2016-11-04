package FirstAttempt;

public class BombEnemy {

	// http://www.cnblogs.com/grandyang/p/5599289.html
	// solution 2
	/**
	 * 需要一个rowCnt int，用来记录到下一个墙之前的敌人个数。还需要一个数组colCnt[]，其中colCnt[j]表示第j列到下一个墙之前的敌人个数。
	 * 算法思路是遍历整个数组grid，对于一个位置grid[i][j]，
	 * 对于水平方向，如果当前位置是开头一个或者前面一个是墙壁，我们开始从当前位置往后遍历，遍历到末尾或者墙的位置停止，计算敌人个数。
	 * 对于竖直方向也是同样，如果当前位置是开头一个或者上面一个是墙壁，我们开始从当前位置向下遍历，遍历到末尾或者墙的位置停止，计算敌人个数。
	 * 有了水平方向和竖直方向敌人的个数，那么如果当前位置是0，表示可以放炸弹，我们更新结果res即可
	 * https://discuss.leetcode.com/topic/48565/short-o-mn-solution
	 * */
	public static int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int row = grid.length;
		int col = grid[0].length;
		int rowCount = 0;
		int[] colCount = new int[col];
		
		int res = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0 || grid[i][j-1] == 'W') {
					rowCount = 0;
					for (int k = j; k < col && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E') {
							rowCount++;
						}
					}
				}
				
				if (i == 0 || grid[i-1][j] == 'W') {
					colCount[j] = 0;
					for (int k = i; k < row && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E') {
							colCount[j]++;
						}
					}
				}
				
				if (grid[i][j] == '0') {
					res = Math.max(res, rowCount + colCount[j]);
				}
			}
		}
 		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////
	public static int maxKilledEnemies2(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int height = grid.length;
		int width = grid[0].length;
		int[][] v = new int[height][width];
		int[][] h = new int[height][width];

		// fill h
		for (int row = 0; row < height; row++) {
			int start = -1;
			int end = -1; // exclusive
			int enemies = 0;
			for (int col = 0; col < width; col++) {
				if (grid[row][col] == 'E') {
					enemies++;
					end = col;
				} else if (grid[row][col] == '0') {
					if (start == -1) {
						start = col;
					}
					end = col;
				} else {
					fillRow(h, row, start, end, enemies, grid);
					start = end = -1;
					enemies = 0;
				}
			}
			fillRow(h, row, start, end, enemies, grid);
		}

		// fill v
		for (int col = 0; col < width; col++) {
			int start = -1;
			int end = -1; // exclusive
			int enemies = 0;
			for (int row = 0; row < height; row++) {
				if (grid[row][col] == 'E') {
					enemies++;
					end = row;
				} else if (grid[row][col] == '0') {
					if (start == -1) {
						start = row;
					}
					end = row;
				} else {
					fillCol(v, col, start, end, enemies, grid);
					start = end = -1;
					enemies = 0;
				}
			}
			fillCol(v, col, start, end, enemies, grid);

		}

		return getLargestEnemy(grid, v, h);
	}

	private static int getLargestEnemy(char[][] grid, int[][] v, int[][] h) {
		int max = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '0') {
					max = Math.max(v[row][col] + h[row][col], max);
				}
			}
		}
		return max;
	}

	public static void fillRow(int[][] note, int row, int start, int end,
			int val, char[][] grid) {
		if (row > note.length || start > note[0].length || start < 0) {
			return;
		}
		for (int n = start; n <= end && n < note[0].length; n++) {
			if (grid[row][n] == '0') {
				note[row][n] = val;
			}
		}
	}

	public static void fillCol(int[][] note, int col, int start, int end,
			int val, char[][] grid) {
		if (col > note[0].length || start > note.length || start < 0) {
			return;
		}
		for (int n = start; n <= end && n < note.length; n++) {
			if (grid[n][col] == '0') {
				note[n][col] = val;
			}
		}
	}
}
