package FirstAttempt;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) { // 先假设一共有i个node。i iterate from 2 to n
			for (int j = 0; j <= i-1; j++) {  // j代表左子树，最少0个node，最多i-1个node
				int left = dp[j];
				int right = dp[i - j - 1];
				dp[i] += left * right;
			}
		}
		return dp[n];
	}
}
