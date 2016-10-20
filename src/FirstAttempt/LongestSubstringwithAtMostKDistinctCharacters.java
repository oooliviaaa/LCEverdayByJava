package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

	// http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(k==0 || s==null || s.length()==0)
	        return 0;
	 
	    if(s.length()<k)
	        return s.length();
	 
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
        	
    		if (map.keySet().size() > k) {
    			int len = ed - st;   		///// ed-st就是他俩之间的距离-1，所以size>k的时候比较max大小是刚好的!!!!!
            	max = Math.max(max, len);
            	
            	while (map.keySet().size() > k) {
            		char cc = s.charAt(st);
            		Integer ccnum = map.get(cc);
            		if (--ccnum == 0) {
            			map.remove(cc);
            		} else {
            		    map.put(cc, map.get(cc)-1);
            		}
            		st++;
            	}
    		}
        	ed++;
        }
        return Math.max(max, s.length() - st);   ///// 最后别忘了比较最后一段!!!!!
    }
	
	public static void main(String[] args) {
		String s = "asdffdgh";
		String s2 = "aa";
		int k = 4;
		
		LongestSubstringwithAtMostKDistinctCharacters ls = new LongestSubstringwithAtMostKDistinctCharacters();
		int res = ls.lengthOfLongestSubstringKDistinct(s2, 1);
		System.out.println("result : " + res);
		
	}
}
