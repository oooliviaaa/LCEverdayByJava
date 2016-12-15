package LLLLLLLLLLL;

public class MinDiffOfTwoArrays {

	
	public int getMinDiff(int[] a, int[] b) {
		int[][] dp = new int[a.length][b.length];
		
		dp[0][0] = Math.abs(a[0] - b[0]);
		for (int i = 1; i < b.length; i++) {
			dp[0][i] = Math.min(dp[0][i-1], Math.abs(a[0] - b[i]));
		}
		
		for (int i = 1; i < a.length; i++) {
			dp[i][i] = dp[i-1][i-1] + Math.abs((a[i] - b[i]));
		}
		
		for (int i = 1; i < a.length; i++) {
			for (int j = i+1; j < b.length; j++) {
				dp[i][j] = Math.min(dp[i-1][j-1] + Math.abs(a[i] - b[j]), dp[i][j-1]);
			}
		}
		return dp[a.length-1][b.length-1];
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,12};
		int[] b = {4,9,8,4};
		
		MinDiffOfTwoArrays md = new MinDiffOfTwoArrays();
		int res = md.getMinDiff(a, b);
		System.out.println(res);
	}
}
