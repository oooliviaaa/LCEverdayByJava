package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	// http://www.lifeincode.net/programming/leetcode-minimum-window-substring-java/
	/**
	 * two pointers
	 * */
	public String minWindow(String s, String t) {
        int length = Integer.MAX_VALUE;
        String res = "";
		Map<Character, Integer> dict = new HashMap<Character, Integer>();  // 因为t中字母可能有重复
        for (int i = 0; i < t.length(); i++) {
        	char c = t.charAt(i);
        	if (dict.containsKey(c)) {
        		dict.put(c, dict.get(c)+1);
        	} else {
        		dict.put(c, 1);
        	}
        }
        
        int findCount = 0;   ///// 用来记录t中字母是不是全找到了。!!!!!
        Map<Character, Integer> find = new HashMap<Character, Integer>();   ///// !!!!!
        
        int left = 0;
        int right = 0;
        while (right < s.length()) {
        	char c = s.charAt(right);
        	if (dict.containsKey(c)) {
        		if (find.containsKey(c)) {
        			if (find.get(c) < dict.get(c)) {
        				findCount++;
        			}
    				find.put(c, find.get(c)+1);
        		} else {
        			findCount++;
        			find.put(c, 1);
        		}
        	}
        	
        	// 如果全找到了。When the total counter equals to length of T, we know that we have found all characters. 
        	if (findCount == t.length()) {
        		char cc = s.charAt(left);
        		
        		// Now we can move the “left” pointer as right as possible. 
        		// We can move it when it pointing to a character that is not in T, 
        		// or even it is in T, but the number of this character is larger than the number we need to find
        		while (!find.containsKey(cc) || find.get(cc) > dict.get(cc)) {
        			
        			// cc is in T, but the number of this character is larger than the number we need to find
        			if (find.containsKey(cc) && find.get(cc) > dict.get(cc)) {
        				find.put(cc, find.get(cc) - 1);
        			}
        			left++;
        			cc = s.charAt(left);   ///// 更新cc
        		}

				int curLen = right - left + 1;
				if (curLen < length) {
					length = curLen;
					res = s.substring(left, right+1);
				}
        	}
        	right++;
        }
        return res;
    }
}
