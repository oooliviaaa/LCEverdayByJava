package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {

	// http://buttercola.blogspot.com/2015/09/leetcode-palindrome-permutation-ii.html
	/**
	 * If a palindromic permutation exists, we just need to generate the first half of the string.
	 * */
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) return res;
		
		// Step 1: determine if the string s is palindrome permutated
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		if (!isPalindromePermutation(s, hm)) {
			return res;
		}
		
		// Step 2: form the left half of the seed string
        StringBuffer sb = new StringBuffer();
        Character middle = null;
        for (Character c : hm.keySet()) {
        	int count = hm.get(c);
        	while (count > 1) {
        		sb.append(c);
        		count -= 2;
        	} 
        	if (count == 1) {
        		middle = c;
        	}
        }
        
        List<String> tmp = new ArrayList<String>();
        permutation(sb.toString().toCharArray(), 0, tmp);
		
		for (String t : tmp) {
			StringBuffer re = new StringBuffer(t);
			if (middle != null) {
				re.append(middle);
			}
			re.append(new StringBuffer(t).reverse().toString());
			res.add(re.toString());
		}
		return res;
    }
	
	private void permutation(char[] s, int bg, List<String> res) {
		if (bg >= s.length) {
			res.add(new String(s));
			return;
		}
		
		for (int i = bg; i < s.length; i++) {
			if (isSwapable(s, bg, i)) {
				swap(s, bg, i);
				permutation(s, bg+1, res);
				swap(s, bg, i);
			}
		}
	}
	
	private boolean isSwapable(char[] s, int start, int end) {
		for (int i = start; i < end; i++) {
			if (s[i] == s[end]) return false;
		}
		return true;
	}
	
	private void swap(char[] s, int i, int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
	
	private boolean isPalindromePermutation(String s, Map<Character, Integer> hm) {
		if (s == null || s.length() == 0) return true;
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (hm.containsKey(c)) {
        		hm.put(c, hm.get(c)+1);
        	} else {
        		hm.put(c, 1);
        	}
        }
        
        boolean isOdd = false;
        for (Character c : hm.keySet()) {
        	int count = hm.get(c);
        	if (count % 2 == 1) {
        		if (isOdd) return false;
        		else isOdd = true;
        	}
        }
        return true;
	}
	
	
	
	public static void main(String[] args) {
		String s = "a";
		PalindromePermutationII p2 = new PalindromePermutationII();
		List<String> res = p2.generatePalindromes(s);
		for (String r : res) System.out.println(r);
	}
}
