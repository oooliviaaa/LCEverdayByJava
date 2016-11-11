package LLLLLLLLL;

import java.util.Collection;
import java.util.Iterator;

public class DeepIteratorImpl<T> implements Iterator<T> {
    // Constructor
    public DeepIteratorImpl (Collection<Data<T>> c) {
        // Implementation here
    }
    public T next() {
        // Implementation here
    }
    public boolean hasNext() {
        // Implementation here
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
