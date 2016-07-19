package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {

	// http://www.chenguanghe.com/word-pattern-ii/
	public boolean wordPatternMatch(String pattern, String str) {
        Map<Object, Integer> record = new HashMap<Object, Integer>();///////// Object !!! can be Character or String
        return dfs(pattern, 0, str, 0, record);
    }
	
	private boolean dfs(String pattern, int p, String str, int q, Map<Object, Integer> record) {
		if (p == pattern.length() && q == str.length()) return true;
		if (p == pattern.length() || q == str.length()) return false;
		
		char c = pattern.charAt(p);
		for (int i = q; i < str.length(); i++) { 
			String ss = str.substring(q, i+1);
			Integer a = record.get(c);  
			Integer b = record.get(ss);
			if (a == b) {      //如果map中的i对应的值(可以是null) 和 substring对应的值相同(也可以是null)
				if (a == null) {
					record.put(c, i);    ///////////// i !!!!! 这个string到i位置之前都match上了。
					record.put(ss, i);
				}
				
				if (dfs(pattern, p+1, str, i+1, record)) {
					return true;
				}
				
				if (a == null) {         ///////////////   backtracking !!!!!
					record.remove(c);
					record.remove(ss);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String pattern = "eecs";
		String str = "electronicengineeringcomputerscience";
		
		WordPatternII wp2 = new WordPatternII();
		boolean res = wp2.wordPatternMatch(pattern, str);
		System.out.println(res);
	}
}
