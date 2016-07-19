package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	 public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> record = new HashMap<Character, String>();
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
        	
        	String word = words[i];
        	char c = pattern.charAt(i);
        	
        	if (!record.containsKey(c)) {
        		if (record.containsValue(word)) return false;
        		record.put(c, word);      /////////////////////////   !!!!!
        	} else {
        		if (!word.equals(record.get(c))) return false;
        	}        	
        }
        return true;
    }
}
