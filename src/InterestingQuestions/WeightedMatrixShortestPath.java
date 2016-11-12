package InterestingQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WeightedMatrixShortestPath {

	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	
	// weight are all positive numbers, 
	// -1 means wall --> blocked
	public int solution(int[][] matrix, int stx, int sty, int edx, int edy) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
		dp[stx][sty] = matrix[stx][sty];
		
		helper(matrix, dp, stx, sty, matrix[stx][sty]);
		return dp[edx][edy] == Integer.MAX_VALUE ? -1 : dp[edx][edy];
	}
	
	private void helper(int[][] matrix, int[][] dp, int i, int j, int curSum) {
		if (dp[i][j] < curSum) {  // heavier path, ignore
			return;
		}
		dp[i][j] = curSum;
		for (int[] dir : directions) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length 
					&& matrix[x][y] != -1) {
				helper(matrix, dp, x, y, dp[i][j] + matrix[x][y]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {2,5,-1}, {5,8,9}, {10,11,12}};
		WeightedMatrixShortestPath wm = new WeightedMatrixShortestPath();
		int res = wm.solution(matrix, 0, 0, 3, 2);
		System.out.println(res);
	}
}
