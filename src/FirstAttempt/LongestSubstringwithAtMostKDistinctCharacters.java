package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int st = 0;
        int ed = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (st < s.length() && ed < s.length()) {
        	char c = s.charAt(ed);
        	Integer cnum = map.get(c);
        	if (cnum == null) {
        		cnum = 1;
        	} else {
        		cnum++;
        	}
    		map.put(c, cnum);
        	ed++;
        	
        	while (map.keySet().size() > k) {
        		char cc = s.charAt(st);
        		Integer ccnum = map.get(cc);
        		if (--ccnum == 0) {
        			map.remove(cc);
        		}
        		st++;
        	}
        	
        	int len = ed - st;
        	max = Math.max(max, len);
        }
        return max;
    }
	
	public static void main(String[] args) {
		String s = "asdffdgh";
		int k = 4;
		
		LongestSubstringwithAtMostKDistinctCharacters ls = new LongestSubstringwithAtMostKDistinctCharacters();
		int res = ls.lengthOfLongestSubstringKDistinct(s, k);
		System.out.println("result : " + res);
		
	}
}
