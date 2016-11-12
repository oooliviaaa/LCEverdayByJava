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
//	public static int maxLengthPalindrome2(int[] input) { 
//		
//		
//	}
	
	
	
	public static void main(String[] args) {
		int[] input = {1,0,2,8,3,4,5,5,4,9,3,2,1};
		int res = maxLengthPalindrome(input);
		System.out.println(res);
	}
}
