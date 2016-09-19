package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_DataStructureDesign {
	
	Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
	
	// Add the number to an internal data structure.
	public void add(int number) {
	    if (hm.containsKey(number)) {
	    	hm.put(number, hm.get(number) + 1);
	    } else {
	    	hm.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Integer num : hm.keySet()) {
	    	int pair = value - num;
	    	if (hm.containsKey(pair)) {
	    		if (num == pair && hm.get(pair) < 2) {  // 不够凑一对
	    			continue;
	    		}
	    		return true;
	    	}
	    }
	    return false;
	}
}
