package LLLLLLLLL;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DeepIteratorImpl<T> implements Iterator<T> {
	
	Stack<Data<T>> stack;

    public DeepIteratorImpl (Collection<Data<T>> c) {
		stack = new Stack<Data<T>>();

    	if (c != null) {
        	for (Data<T> ele : c) {
        		stack.push(ele);
        	}
    	}
    	
    }
    
    public T next() {
        return stack.pop().getElement();
    }
    
    public boolean hasNext() {
        while (!stack.isEmpty()) {
        	Data<T> cur = stack.peek();
        	if (!cur.isCollection()) {
        		return true;
        	} else {
        		cur = stack.pop();
        		Collection<Data<T>> collection = cur.getCollection();
        		Collections.reverse((List<Data<T>>)collection);
        		for (Data<T> c : collection) {
        			stack.push(c);
        		}
        		
        	}
        }
        return false;
    }
}


 
interface Data<T> {
    // Does this Data hold a collection?   
    public boolean isCollection();
    // Returns the collection contained by this Data, or null if it is a single element
    public Collection<Data<T>> getCollection();
    // Returns the single element contained by this Data, or null if it is a collection
    public T getElement();
}
