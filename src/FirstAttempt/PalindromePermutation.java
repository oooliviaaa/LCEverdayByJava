package FirstAttempt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {

	// https://segmentfault.com/a/1190000003790181
	// solution 1: hashmap
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
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
	
	
	//////////////////
	// solution 2: hashset
	public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            // 出现的第偶数次，将其从Set中移出
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            } else {
            // 出现的第奇数次，将其加入Set中
                set.add(s.charAt(i));
            }
        }
        // 最多只能有一个奇数次字符
        return set.size() <= 1;
    }
}
