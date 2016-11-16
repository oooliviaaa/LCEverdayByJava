package LLLLLLLLL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromeFinder_Naive {

	public Set<String> findPalindromes(String s) {
		Set<String> note = new HashSet<String>();
		Set<String> res = new HashSet<String>();
		helper(s, 0, "", note);

		for (String r : note) {
			if (isPalindrome(r)) {
				res.add(r);
			}
		}
		return res;
	}
	
	private void helper(String s, int index, String tmp, Set<String> note) {
		if (index == s.length()) {
			note.add(tmp);
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			char c = s.charAt(i);
			helper(s, i+1, tmp+c, note);
		}
	}
	
	private boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeFinder_Naive pf = new PalindromeFinder_Naive();
		Set<String> res = pf.findPalindromes("abcba");
		for (String r : res) System.out.println(r);
	}
}
