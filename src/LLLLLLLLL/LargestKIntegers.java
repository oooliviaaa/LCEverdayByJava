package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestKIntegers<V extends Comparable<V>> {
	 
	  private final int maxSize;
	  private final PriorityQueue<V> top;
	 
	  public LargestKIntegers(int maxSize) {
	    this.maxSize = maxSize;
	    this.top = new PriorityQueue<V>(Math.max(1, maxSize));
	  }
	 
	  public void add(V nextValue) {
	    // The first two conditions merely optimize for special cases:
	    if (maxSize <= 0) // silly, but well defined
	      return;
	    else if (top.size() >= maxSize && nextValue.compareTo(top.peek()) <= 0)
	      return;
	    // This is sufficient in all cases:
	    else if (top.add(nextValue) && top.size() > maxSize) {
	      top.poll();
	    }
	  }
	 
	  public Collection<V> getTop() {
	    return Collections.unmodifiableList(new ArrayList<V>(top)); // defensive wrapper
	  }
	

}
