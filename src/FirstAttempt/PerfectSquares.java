package FirstAttempt;

import java.util.Arrays;

public class PerfectSquares {
	
	// dp
	public int numSquares(int n) {
	    int max = (int) Math.sqrt(n);
	 
	    int[] dp = new int[n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	 
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=max; j++){
	            if(i==j*j){
	                dp[i]=1;
	            }else if(i>j*j){
	                dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
	            }
	        }
	    }
	 
	    return dp[n];
	}
	
	////////////////////////////
	
	public int numSquares2(int n) {
        int[] note = new int[n];
		Arrays.fill(note, 0);
		note[0] = 1;
		return getMin(n, note);
	}
	
	
	private static int getMin(int n, int[] note) {
		if (n == 0) {
			return 0;
		}
		if (note[n - 1] > 0) {
			return note[n - 1];
		}
		
		int sqrt = (int) Math.sqrt(n);
		int min = Integer.MAX_VALUE;
		for (int current = sqrt; current > 0; current--) {
			int left = current * current;
			int right = n - left;
			min = Math.min(min, 1 + getMin(right, note));
		}
		note[n - 1] = min;
		return min;
    }
	
	
	
	///////////////
	public int numSquares3(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int max = (int) Math.sqrt(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max; j++) {
                if (i == j*j) {
                    dp[i] = 1;
                } else if (i > j * j) {
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
	
	
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		int res = ps.numSquares3(4);
		System.out.println(res);
	}
}
