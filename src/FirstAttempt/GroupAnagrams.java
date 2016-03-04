package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	// https://cheonhyangzhang.wordpress.com/2015/09/22/49-leetcode-java-group-anagrams-medium/
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0) return res;
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		for(String s : strs) { 
			char[] charS = s.toCharArray();    ////////////!!!
			Arrays.sort(charS);                ////////////!!!
			String sortS = new String(charS);  ////////////!!!
			if(hm.containsKey(sortS)) {        ////////////!!!
				hm.get(sortS).add(s);
			}
			else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                hm.put(sortS,list);
            }
		}
		
		for(ArrayList<String> ele : hm.values()) {
			Collections.sort(ele);
			res.add(ele);
		}
		return res;
    }
}
