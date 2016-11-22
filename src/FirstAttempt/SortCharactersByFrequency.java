package FirstAttempt;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	// https://discuss.leetcode.com/topic/66024/java-o-n-bucket-sort-solution-o-nlogn-priorityqueue-solution-easy-to-understand
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
        		new PriorityQueue<Map.Entry<Character, Integer>>(new Comparator<Map.Entry<Character, Integer>>() {

			public int compare(Map.Entry<Character, Integer> o1,
					Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
        	
        });
        
        pq.addAll(map.entrySet());
        StringBuffer res = new StringBuffer();
        
        while (!pq.isEmpty()) {
        	Map.Entry<Character, Integer> entry = pq.poll();
        	char key = entry.getKey();
        	int val = entry.getValue();
        	for (int i = 0; i < val; i++) {
        		res.append(key);
        	}
        }
        return res.toString();
    }
}
