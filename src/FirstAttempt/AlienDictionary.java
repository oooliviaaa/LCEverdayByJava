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
		if (words == null || words.length <= 0) return "";
		if (words.length == 1) {
			StringBuffer sb = new StringBuffer(words[0]);
			return sb.reverse().toString();
		}
		
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
				
		for (int i = 1; i < words.length; i++) {      //////////////////////    !!!!!
			String pre = words[i-1];
			String cur = words[i];
			int j = 0;
			while (j < pre.length() && j < cur.length()) {
				char p = pre.charAt(j);
				char c = cur.charAt(j);
				if (p != c) {      //////////////////////    !!!!!
					if (!dic.containsKey(p)) {
						List<Character> l = new ArrayList<Character>();
						l.add(c);
						dic.put(p, l);
					}
					else {
						List<Character> l = dic.get(p);
						if (!l.contains(c)) l.add(c);
					}
					break;                        //////////////////////    !!!!!
				}
				j++;                             //////////////////////    !!!!!
			}
		}
		
		// topological sort on dic
		StringBuffer res = new StringBuffer();
		Iterator<Character> it = dic.keySet().iterator(); //////////////////////  Iterator<>  !!!!!
		while (it.hasNext()) {
			char cur = it.next();
			if (!used.get(cur)) {
				Set<Character> loop = new HashSet<Character>();  ///////////// topological sort only works for DAG
				if (topologicalSort(cur, dic, used, loop, res)) {  ////so need to watch out loop for each start!!!!!
					return "";
				}
			}
		}
		
		// take care of the nodes which are in used, but not in dic
		it = used.keySet().iterator();
		while (it.hasNext()) {
			char cur = it.next();  
            if(!used.get(cur))    // this char is never used
                res.insert(0, cur);                    //////////////////////    !!!!!
		}
		return res.toString();
	}
	
	private boolean topologicalSort(char cur, Map<Character, List<Character>> dic, 
									Map<Character, Boolean> used, Set<Character> loop, StringBuffer res) {
		used.put(cur, true);  // see if a char is used at least once
		loop.add(cur);		  // see if this round has a loop   !!!!!

		if (dic.containsKey(cur)) {
			Iterator<Character> it = dic.get(cur).iterator();
			while (it.hasNext()) {
				char adj = it.next();
				if (loop.contains(adj)) {
					return true; // dic has a loop --> input is wrong, so return ""
				}
				if (!used.get(adj)) {  // prevent dup recursion
					if (topologicalSort(adj, dic, used, loop, res)) {
						return true;
					}
				}
			}
		}
		loop.remove(cur);       //////////////////////    back tracking !!!!!!!!!!
		res.insert(0, cur);  // insert to the front, similar to stack          !!!!!
		return false;
	}
	
	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		
		String[] words = new String[]{"wnlb"};
		String res = ad.alienOrder(words);
		System.out.println(res);
		
		words = new String[]{"a", "b", "ca", "cb"};
		res = ad.alienOrder(words);
		System.out.println(res);
		
		words = new String[]{"a", "b", "c"};
		res = ad.alienOrder(words);
		System.out.println(res);
	} 
}
