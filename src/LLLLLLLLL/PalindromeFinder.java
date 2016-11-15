package LLLLLLLLL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromeFinder {

	public Set<String> findPalindromes(String s) {
		Set<String> res = new HashSet<String>();
		Map<String, Set<String>> note = new HashMap<String, Set<String>>();  // 记录下一个string能构成的的所有palindrome
		helper(s, note, res);
		return res;
	}
	
	private void helper(String s, Map<String, Set<String>> note, Set<String> res) {
		if (s == null || s.length() == 0) return;
		if (note.containsKey(s)) return;
		
		Set<String> substrings = new HashSet<String>();
		if (s.length() == 1) {
			substrings.add(s);
			note.put(s, substrings);
			return;
		}
	}
}
