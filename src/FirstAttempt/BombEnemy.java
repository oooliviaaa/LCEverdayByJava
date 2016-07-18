package FirstAttempt;

public class BombEnemy {

	public static int maxKilledEnemies(char[][] grid) {
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
