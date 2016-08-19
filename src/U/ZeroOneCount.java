package U;

public class ZeroOneCount {

	// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190604&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
	int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private int dfs(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1) {
			return 0;
		}
		matrix[i][j] = 2;
		int res = 1;
		for (int[] dir : directions) {
			int x = i + dir[0]; int y = j + dir[1];
			res += dfs(matrix, x, y);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,0,1,0,0}, {0,1,1,0,1}, {0,0,1,0,0}, {1,1,1,1,0}};
		
		ZeroOneCount zo = new ZeroOneCount();
		int res = zo.dfs(matrix, 1, 2);
		System.out.println(res);
	}
}
