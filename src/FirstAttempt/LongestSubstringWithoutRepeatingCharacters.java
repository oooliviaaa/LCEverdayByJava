package FirstAttempt;
import java.util.HashSet;


public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        HashSet<Character> hs = new HashSet<Character>();
        
        int left = 0;    //////Remember!!! need record left bound
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(hs.contains(c)) {
        		while(left < i && s.charAt(left) != c) {
        			hs.remove(s.charAt(left));
        			left++;
        		}
        		left++;
        	}
        	else {
        		hs.add(c);
        		res = Math.max(res, i - left + 1);   ////// new length could be the new max length
        	}
        }
        return res;
    }
}
