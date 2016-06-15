package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AlienDictionary {

// http://blog.csdn.net/pointbreak1/article/details/48761705
	public String alienOrder(String[] words) {
		if (words == null || words.length <= 1) return "";
		
		Map<Character, List<Character>> dic = new HashMap<Character, List<Character>>();
		Map<Character, Boolean> used = new HashMap<Character, Boolean>();
		
		// preprocess
		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			for (int j = 0; j < cur.length(); j++) {
				if (!used.containsKey(cur.charAt(j))) {
					used.put(cur.charAt(j), false);
				}
			}
		}
		
		for (int i = 1; i < words.length; i++) {
			String pre = words[i-1];
			String cur = words[i];
			int j = 0;
			while (j < pre.length() && j < cur.length()) {
				char p = pre.charAt(j);
				char c = cur.charAt(j);
				if (p != c) {
					if (!dic.containsKey(p)) {
						List<Character> l = new ArrayList<Character>();
						l.add(c);
						dic.put(p, l);
					}
					else {
						dic.get(p).add(c);
					}
					break;
				}
				j++;
			}
		}
		
		// topological sort on dic
		StringBuffer res = new StringBuffer();
		Iterator<Character> it = dic.keySet().iterator();
		
		while (it.hasNext()) {
			char cur = it.next();
			if (!used.get(cur)) {
				Set<Character> loop = new HashSet<Character>();
				if (topologicalSort(cur, dic, used, loop, res)) {
					return "";
				}
			}
		}
		
		
		// take care of the node without any edge
		it = used.keySet().iterator();
		while (it.hasNext()) {
			char cur = (char)it.next();  
            if(!used.get(cur))  
                res.insert(0, cur); 
		}
		
		return res.toString();
	}
	
	private boolean topologicalSort(char cur, Map<Character, List<Character>> dic, 
									Map<Character, Boolean> used, Set<Character> loop, StringBuffer res) {
		used.put(cur, true);
		loop.add(cur);
		
		if (dic.containsKey(cur)) {
			Iterator<Character> it = dic.get(cur).iterator();
			while (it.hasNext()) {
				char adj = it.next();
				if (loop.contains(adj)) return true; // dic has a loop --> input is wrong, so return ""
				if (topologicalSort(adj, dic, used, loop, res)) {
					return true;
				}
			}
		}
		res.insert(0, cur);  // insert to the front, similar to stack
		return false;
	}
	
}
