package LLLLLLLLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomGetSet<T> {

	List<Integer> list;
	Map<Integer, Integer> map;
	Random r;
	
    /** Initialize your data structure here. */
    public RandomGetSet() {
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
    
    /** Get a random element from the set. */
    public int getRandom() {
        int ranIndex = r.nextInt(list.size());
        return list.get(ranIndex);
    }
}
