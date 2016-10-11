package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

	public int longestPalindrome(String s) {
		int count = 0;
		Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (set.contains(c)) {
        		set.remove(c);
        		count++;
        	} else {
        		set.add(c);
        	}
        }
        
        if (!set.isEmpty()) return count*2 + 1;
        else return count*2;
    }
}
