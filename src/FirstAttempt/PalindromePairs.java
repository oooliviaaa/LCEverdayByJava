package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	
	public List<List<Integer>> palindromePairs(String[] words) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words == null || words.length < 2) return res;

		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i < words.length; i++) {
			hm.put(words[i], i);
		}
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j <= word.length(); j++) {  //  notice it should be "j <= words[i].length()"，因为s1, s2可以是空的""
				String s1 = word.substring(0, j);
				String s2 = word.substring(j);
				
				if (isPalindrome(s1)) {
					String reverseS2 = new StringBuffer(s2).reverse().toString();
					if (hm.getOrDefault(reverseS2, i) != i) {   // get or default position不是i，表示从hashmap里面找到了，且不是它自己
						res.add(Arrays.asList(hm.get(reverseS2), i));
					}
				}
				if (isPalindrome(s2) && s2.length() != 0) {  // check "s2.length() != 0" to avoid duplicates, eg. "abcd"和"dcba", "abcd"+"" == ""+"dcba"
					String reverseS1 = new StringBuffer(s1).reverse().toString();
					if (hm.getOrDefault(reverseS1, i) != i) {
						res.add(Arrays.asList(i, hm.get(reverseS1)));
					}
				}
			}
		}
		return res;
    }
	
	private boolean isPalindrome(String s) {
		if (s == null) return false;
		if (s.length() <= 1) return true;
		
		int i = 0;
		int j = s.length()-1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePairs pp = new PalindromePairs();
		
		String[] words = {"abcd","dcba","lls","s","sssll"};
		String[] words2 = {"a",""};
		List<List<Integer>> res = pp.palindromePairs(words2);
		for (List<Integer> re : res) {
			for (Integer r : re) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
