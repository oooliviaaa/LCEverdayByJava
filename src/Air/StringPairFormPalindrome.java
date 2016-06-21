package Air;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPairFormPalindrome {

	public static void main(String[] args) {
		System.out.println(findPairStringsToFormPalindrome(new String[]{"a", ""}));
		System.out.println(findPairStringsToFormPalindrome(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
	}
	
	public static List<ArrayList<Integer>> findPairStringsToFormPalindrome(String[] words) {
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		Map<String, Integer> dict = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			dict.put(words[i], i);
		}
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 1; j <= word.length(); j++) {
				String left = word.substring(0, j);
				String right = word.substring(j);
				
				if (isPalindrome(left)) {
					String revRight = getReversedString(right);
					Integer index = dict.get(revRight);
					if (index != null && index != i) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(index);
						tmp.add(i);
						res.add(tmp);
					}
					if (revRight.length() == 0) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(i);
						tmp.add(index);
						res.add(tmp);
					}
				}
				if (isPalindrome(right)) {
					String leftRev = getReversedString(left);
					Integer index = dict.get(leftRev);
					if (index != null && index != i) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(index);
						tmp.add(i);
						res.add(tmp);
					}
				}
			}
		}
		return res;
	}
	
	private static boolean isPalindrome(String s) {
		int bg = 0;
		int ed = s.length()-1;
		
		while (bg <= ed) {
			if (s.charAt(bg) != s.charAt(ed)) {
				return false;
			}
			bg++;
			ed--;
		}
		return true;
	}
	
	private static String getReversedString(String s) {
		return new StringBuffer(s).reverse().toString();
	}
	
}
