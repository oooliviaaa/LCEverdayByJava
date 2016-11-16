package LLLLLLLLL;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	// http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
	public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> hm = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	
        	if (hm.containsKey(c1)) {
        		if (hm.get(c1) != c2) return false;
        	} else {
        		if(hm.containsValue(c2)) return false; //if c2 is already being mapped !!!!! 
        		hm.put(c1, c2);
        	}
        }
        return true;
    }
}
