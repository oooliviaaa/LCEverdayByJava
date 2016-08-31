package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	// http://www.programcreek.com/2014/05/leetcode-valid-anagram-java/
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
        	char sc = s.charAt(i);
        	charCount[sc - 'a'] += 1;
        	char tc = t.charAt(i);
        	charCount[tc - 'a'] -= 1;
        }
        
        for (int i : charCount) {
        	if (i != 0) return false;
        }
        return true;
    }
	
	
	
	
	//////////follow up///////////
	// If the inputs contain unicode characters, an array with length of 26 is not enough.

	public boolean isAnagram2(String s, String t) {
	    if(s.length()!=t.length())
	        return false;
	 
	    Map<Character, Integer> map = new HashMap<Character, Integer>();    
	 
	    for(int i=0; i<s.length(); i++){
	        char c1 = s.charAt(i);
	        if(map.containsKey(c1)){
	            map.put(c1, map.get(c1)+1);
	        }else{
	            map.put(c1,1);
	        }
	    }
	 
	    for(int i=0; i<s.length(); i++){
	        char c2 = t.charAt(i);
	        if(map.containsKey(c2)){
	            if(map.get(c2)==1){
	                map.remove(c2);
	            }else{
	                map.put(c2, map.get(c2)-1);
	            }
	        }else{
	            return false;
	        }    
	    }
	 
	    if(map.size()>0)
	        return false;
	 
	    return true;
	}
}
