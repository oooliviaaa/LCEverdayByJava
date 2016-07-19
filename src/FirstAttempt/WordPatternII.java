package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {

	// http://www.chenguanghe.com/word-pattern-ii/
	public boolean wordPatternMatch(String pattern, String str) {
        Map<String, Integer> record = new HashMap<String, Integer>();
        return dfs(pattern, 0, str, 0, record);
    }
	
	private boolean dfs(String pattern, int p, String str, int q, Map<String, Integer> record) {
		if (p == pattern.length() && q == str.length()) return true;
		if (p == pattern.length() || q == str.length()) return false;
		
		char c = pattern.charAt(p);
		for (int i = q; i < str.length(); i++) { 
			String ss = str.substring(q, i+1);
			String sc = ""+c;
			Integer a = record.get(c);  
			Integer b = record.get(ss);
			if (a == b) {      //如果map中的i对应的值(可以是null) 和 sbustring对应的值相同(也可以是null)
				if (a == null) {
					record.put(sc, i);
					record.put(ss, i);
				}
				
				if (dfs(pattern, p+1, str, i+1, record)) {
					return true;
				}
				
				if (a == null) {         ///////////////   backtracking !!!!!
					record.remove(sc);
					record.remove(ss);
				}
			}
		}
		return false;
	}
}
