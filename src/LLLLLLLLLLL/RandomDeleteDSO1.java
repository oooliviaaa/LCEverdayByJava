package LLLLLLLLLLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomDeleteDSO1 {
	List<Integer> list;
	Map<Integer, Integer> map;   // element - index
	Random r;
	
	/** Initialize your data structure here. */
    public RandomDeleteDSO1() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
        	return false;
        }
    	list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size()-1) { // not the last one than swap the last one with this val
        	int last = list.get(list.size()-1);
        	list.set(index, last);
        	map.put(last, index);
        }
        map.remove(val);
    	list.remove(list.size()-1);
        return true;
    }
    
    /** Delete a random element from the set. */
    public boolean deleteRandom() {
        int ele = list.get(r.nextInt(list.size()));
        return remove(ele);
    }
}
