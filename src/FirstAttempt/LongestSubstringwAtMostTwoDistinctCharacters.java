package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwAtMostTwoDistinctCharacters {

	// http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 1;
        int left = 0;
        if (s.length() <= 2) return s.length();
        
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (hm.containsKey(c)) {
        		hm.put(c, hm.get(c)+1);
        	} else {
        		hm.put(c, 1);
        	}
        	
        	if (hm.keySet().size() <= 2) {
        		max = Math.max(max, i-left+1);
        	} else {
        		while (hm.keySet().size() > 2) {
        			char r = s.charAt(left);
        			int count = hm.get(r);
        			if (count == 1) {
        				hm.remove(r);
        			} else {
        				hm.put(r, count-1);
        			}
        			left++;
        		}
        	}
        }
        max = Math.max(max, s.length() - left);
        return max;
    }
}
