package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary2 {

	public String alienOrder(String[] words) {
        if (words == null || words.length <= 0) return "";
		if (words.length == 1) {
			StringBuffer sb = new StringBuffer(words[0]);
			return sb.reverse().toString();
		}
        
        
        // used
        Map<Character, Boolean> used = new HashMap<Character, Boolean>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                used.put(c, false);
            }
        }
        
        // sequential map;
        Map<Character, List<Character>> dict = new HashMap<Character, List<Character>>();
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            int j = 0;
            while (j < w1.length() && j < w2.length()) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (dict.containsKey(c1)) {
                        List<Character> follows = dict.get(c1);
                        if (!follows.contains(c2)) {
                            follows.add(c2);
                        }
                    } else {
                        List<Character> follows = new ArrayList<Character>();
                        follows.add(c2);
                        dict.put(c1, follows);
                    }
                    break;
                }
                j++;
            }
        }
        
        // topological sort
        StringBuffer res = new StringBuffer();
        for (char c : used.keySet()) {
            if (!used.get(c)) {
                Set<Character> loop = new HashSet<Character>();
                if (sort(dict, used, loop, c, res)) {
                    return "";   // 有环
                }
            }
        }
        
        for (char c : used.keySet()) {
            if (!used.get(c)) {
                res.insert(0, c);
            }
        }
        return res.toString();
    }
    
    private boolean sort(Map<Character, List<Character>> dict, Map<Character, Boolean> used, 
                                        Set<Character> loop, char c, StringBuffer res) {
        used.put(c, true);
        if (loop.contains(c)) return true;    ///// !!!!!
        loop.add(c);                          ///// !!!!!
        
        if (dict.containsKey(c)) {            ///// !!!!!
            List<Character> follows = dict.get(c);
            for (char f : follows) {
                if (!used.get(f)) {
                    if (sort(dict, used, loop, f, res)) {
                        return true;
                    }
                }
            }
        }
        
        loop.remove(c);                       ///// backtracking !!!!!
        res.insert(0, c);
        return false;
    }
	
}
