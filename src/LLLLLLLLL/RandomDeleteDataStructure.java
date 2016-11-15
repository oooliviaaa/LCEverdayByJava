package LLLLLLLLL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Design a data structure that supports add(T val), remove(T val) and T removeRandomElement() all in O(1) time
public class RandomDeleteDataStructure<T> {

    private Set<T> elements;
    private Map<Integer, T> indexElement;
    private Map<T, Integer> elementIndex;
    
    public RandomDeleteDataStructure() {
    	elements = new HashSet<T>();
    	indexElement = new HashMap<Integer, T>();
    	elementIndex = new HashMap<T, Integer>();
    }

    public boolean add(T element) {
    	if(!elements.contains(element)) {
        	elements.add(element);
        	indexElement.put(elements.size(), element);
        	elementIndex.put(element, elements.size());
            return true;
        }
        return false;
    }

    public boolean remove(T element) {
        if (elements.contains(element)) {
            int index = elementIndex.get(element);
            indexElement.remove(index);
            elementIndex.remove(element);
            if (elements.size() > 1) { // if this is the last element, do NOT update. 否则用最后一个element替换现在这个element的位子
                T lastElement = indexElement.get(elements.size() - 1);
                indexElement.remove(elements.size() - 1);
                indexElement.put(index, lastElement);
                elementIndex.put(lastElement, index);    // no need to remove: this is a replacement
            }
            elements.remove(element);
            return true;
        }
        return false;
    }

    public T removeRandomElement() {
        if(elements.size() == 0) {
            return null;
        }
        int randIndex = new Random().nextInt(elements.size());
        T element = indexElement.get(randIndex);
        remove(element);
        return element;
    }

}