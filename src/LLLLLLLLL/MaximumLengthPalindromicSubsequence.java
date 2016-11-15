package LLLLLLLLL;

public class MaximumLengthPalindromicSubsequence {
	
	
	// not contiguous!!!!!
	public static int maxLengthPalindrome(int[] input) {
        if (input == null || input.length == 0) return 0;
        return helper(input, 0, input.length-1);
    }
	
	private static int helper(int[] input, int left, int right) {
		if (left == right) {
			return 1;
		}
		if (left > right) {
			return 0;
		}
		
		if (input[left] == input[right]) {
			return helper(input, left+1, right-1) + 2;
		}
		
		return Math.max(helper(input, left+1, right),  helper(input, left, right-1)); 
	}
	
	
	////////////////////
	// follow up: contiguous, same with longest palindromic substring
	public static int maxLengthPalindrome2(int[] input) { 
		int maxLen = 1;  // store the length of longest palindrome
		int len = input.length;
		boolean[][] dp = new boolean[len][len];  //dp[i][j], i is substring start index; j is substring end index
		
		// initialize the length == 1 substrings
		for(int i = 0; i < len; i++){
			dp[i][i] = true;
		}
		
		// initialize the length == 2 substrings
		for(int i = 0; i < len-1; i++){
			if(input[i] == input[i+1]) {
				dp[i][i+1] = true;
				maxLen = 2;
			}			
		}
		
		// update the rest of the substrings (length == 3, length == 4 ... length == n)
		for(int length = 3; length <= len; length++) {
			for(int p = 0; p <= len - length; p++) {
				int q = p + length - 1;  ///////// need to -1 so the length is
				if(input[p] == input[q] && dp[p+1][q-1]){
					dp[p][q] = true;
					maxLen = length;
				}
			}
		}
		return maxLen;
	}
	
	
	
	public static void main(String[] args) {
		int[] input = {1,0,2,8,3,4,5,5,4,9,3,2,1};
		int res = maxLengthPalindrome(input);
		System.out.println(res);
	}
}
