package GQuestions;

import java.util.List;

public class SquareNumSumToN {

	
	public int solution(int N) {
		if (N <= 2) return N;
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int n = 2; n <= N; n++) {
			
			int sq = (int) Math.sqrt(n);
			int min = Integer.MAX_VALUE;
			for (int i = sq; i > 0; i--) {
				int time = 1 + dp[n - i*i];   // because dp[i*i] = 1
				min = Math.min(min, time);
			}
			dp[n] = min;
		}
		
		return dp[N];
	}
	
	public static void main(String[] args) {
		SquareNumSumToN sn = new SquareNumSumToN();
		int res = sn.solution(10);
		System.out.println(res);
	}
}
