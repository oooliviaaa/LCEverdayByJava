package LLLLLLLLL;

public class PizzaCutByNTime {

	/* 1) observe a few terms of the series (1 line, 2 lines, 3 lines...), 
	 * 2) write down n and f(n), 
	 * 3) realize that f(n+1) = f(n) + n+1, 
	 * 4) solve the recurrence to find that f(n) = n*(n+1)/2 + 1
	 */
	
	public int solution(int n) {
		return n * (n+1) / 2 + 1;
	}
	
	public int dpSolution(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + i;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		PizzaCutByNTime pizza = new PizzaCutByNTime();
		int res = pizza.dpSolution(3);
		System.out.println(res);
	}
}
