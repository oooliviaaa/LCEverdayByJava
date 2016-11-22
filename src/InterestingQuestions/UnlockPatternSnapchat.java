package InterestingQuestions;

public class UnlockPatternSnapchat {

	int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public int howManyPattern(int[][] matrix) {
		int count = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				count += dfs(matrix, i, j, 0, visited);
			}
		}
		return count;
	}
	
	private int dfs(int[][] matrix, int i, int j, int step, boolean[][] visited) {
		int count = 0;
		if (step >= 3) count++;  // 走三步，等于经历四个数字
		
		visited[i][j] = true;

		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
				count += dfs(matrix, x, y, step+1, visited);
			}
		}
		
		visited[i][j] = false;

		return count;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		UnlockPatternSnapchat up = new UnlockPatternSnapchat();
		
		int res = up.howManyPattern(matrix);
		System.out.println(res);  // 38
	}
}
