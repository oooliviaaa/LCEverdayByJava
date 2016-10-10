package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {

	// http://www.cnblogs.com/anne-vista/p/4869172.html
	/**
	 * 解题关键点有3个：
	 * 1. 找出word abbreviation 的规律，<first letter><number><last letter>，number = string.length() - 2
	 * 2. 当发现dictionary 里有相同的abbreviation, key 对应的value 变为"" 
	 * 3. The abbreviation of "hello", i.e., h3o already exists in the dictionary.
	 * 	  Input: ["hello"],isUnique("hello") Output: [false] Expected: [true]
	 * 	  If the given word itself is in the dictionary, and it has the unique abbreviation, then we should return true.
	 * */
	
	Map<String, String> hm = new HashMap<String, String>();  // 用来存储abbreviation-word pairs
	
	public UniqueWordAbbreviation(String[] dictionary) {
        for (String s : dictionary) {
        	String abbrevicate = getAbbreviate(s);
        	if (!hm.containsKey(abbrevicate)) {
        		hm.put(abbrevicate, s);
        	} else {
        		hm.put(abbrevicate, "");  // 代表有重复
          	}
        }
    }

    public boolean isUnique(String word) {
    	if (word == null || word.length() <= 2) return true;    
    	/**
    	 * 为了解决这种test cases：
    	 * Input: ["a","a"],isUnique("a")
    	 * Output: [false]
    	 * Expected: [true]
    	 * */
    	
    	String abbrevicate = getAbbreviate(word);
        if (hm.containsKey(abbrevicate)) {
        	return word.equals(hm.get(abbrevicate));
        }
        return true;
    }
    
    private String getAbbreviate(String s) {
    	if (s == null || s.length() <= 2) return s;
    	
    	return s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
    }
}
