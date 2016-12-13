package LLLLLLLLLLL;

public class MaxLengthPalindromeNonConsecutive {

	public int solution(String s) {
		if (s == null || s.length() == 0) return 0;
		return helper(s, 0, s.length()-1);
	}
	
	private int helper(String s, int left, int right) {
		if (left > right) return 0;
		if (left == right) return 1;
		
		if (s.charAt(left) == s.charAt(right)) {
			return helper(s, left++, right--) + 2;
		} else {
			return Math.max(helper(s, left++, right), helper(s, left, right--)); 
		}
	}
}
