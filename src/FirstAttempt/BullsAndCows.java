package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

	// http://www.programcreek.com/2014/05/leetcode-bulls-and-cows-java/
	public String getHint(String secret, String guess) {
        int countBull = 0;
        int countCow = 0;
        
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        // check bull
        for (int i = 0; i < guess.length() && i < secret.length(); i++) {
        	char cg = guess.charAt(i);
        	char cs = secret.charAt(i);
        	
        	if (cg == cs) {
        		countBull++;
        	} else {
        		if (hm.containsKey(cs)) {   //收集secret中不match的字母作为之后的reference
        			hm.put(cs, hm.get(cs)+1);
        		} else {
        			hm.put(cs, 1);
        		}
        	}
        }
        
        // check cow
        for (int i = 0; i < guess.length() && i < secret.length(); i++) {
        	char cg = guess.charAt(i);
        	char cs = secret.charAt(i);
        	
        	if (cg != cs) {
        		if (hm.containsKey(cg)) {  // 参照secret
        			countCow++;
        			int count = hm.get(cg);
        			if (count == 1) {
        				hm.remove(cg);
        			} else {
        				hm.put(cg, count-1);
        			}
        		}
        	}
        }
        
        return countBull + "A" + countCow + "B";
        
    }
}
