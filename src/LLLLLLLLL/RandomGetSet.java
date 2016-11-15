package LLLLLLLLL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomGetSet<T> {

	Set<T> elements;
	Map<Integer, T> indexElementMap;
	Map<T, Integer> elementIndexMap;
	
	public RandomGetSet() {
		elements = new HashSet<T>();
		indexElementMap = new HashMap<Integer, T>();
		elementIndexMap = new HashMap<T, Integer>();
	}
	
	boolean insert(T element) {
		
	} 
	
	boolean delete(T element) {
		
	}
	
	T randomGet() {
		if(elements.size() == 0) {
            return null;
        }
        int randIndex = new Random().nextInt(elements.size());
        T element = indexElementMap.get(randIndex);
        return element;
	}
}
