package GQuestions;

import java.util.Arrays;

public class SquareNumSumToN_Shuai {

	
	
	public static int getMin(int n) {
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
			min = Math.min(min, 1 + getMin(right, note));   // because dp[left] 肯定是个sqrt root，dp[left] = 1;
		}
		note[n - 1] = min;
		return min;
	}
	
	public static void main(String[] args) {
		int test = 999;
		System.out.println(getMin(test));  // 2
	}
}
