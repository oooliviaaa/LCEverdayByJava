package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationAllWords {

	public ArrayList<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> res = new ArrayList<Integer>();
        if(s == null || words == null || s.length() == 0 || words.length == 0) return res;
        
        int num = words.length;
        int len = words[0].length();
        
        Map<String, Integer> toFind = new HashMap<String, Integer>();   // reference
        Map<String, Integer> found = new HashMap<String, Integer>();   // visiting record
        
        // put all strings into toFind:
        for(int i = 0; i < num; i++) {
        	if(toFind.containsKey(words[i])) {
        		toFind.put(words[i], toFind.get(words[i])+1);
        	}
        	else{
        		toFind.put(words[i], 1);
        	}
        }
        
        ///////////////////////// the last chance has to be at least num*len long, use <= !!!!!
        for(int i = 0; i <= s.length() - num*len; i++) {   // i: starting point
        	found.clear();
        	int count;
        	for(count = 0; count < num; count++) {
        		int index = i + count * len;
        		String sub = s.substring(index, index+len);
        		if(!toFind.containsKey(sub)) break;
        		if(!found.containsKey(sub)) {
        			found.put(sub, 1);
        		}
        		else {
        			found.put(sub, found.get(sub)+1);
        		}
        		if(found.get(sub) > toFind.get(sub)) break;
        	}
        	if(count == num) res.add(i);  // all the word in words are found, add starting point to res
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "ababababab";
		String[] words = new String[]{"ab", "ab"};
		SubstringwithConcatenationAllWords sc = new SubstringwithConcatenationAllWords();
		ArrayList<Integer> res = sc.findSubstring(s, words);
		for(Integer i : res) {
			System.out.println(i);
		}
	}
}
