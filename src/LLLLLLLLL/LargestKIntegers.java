package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestKIntegers<V extends Comparable<V>> {
	 
	  private final int size;
	  private final PriorityQueue<V> pq;
	 
	  public LargestKIntegers(int size) {
	    this.size = size;
	    this.pq = new PriorityQueue<V>(Math.max(size, 1));
	  }
	 
	  public void add(V val) {
	    // The first two conditions merely optimize for special cases:
		  if (size <= 0) return;
		  if (val.compareTo(pq.peek()) <= 0) return;
		  pq.offer(val);
		  while (pq.size() > size) {
			  pq.poll();
		  }
	  }
	 
	  public Collection<V> getTop() {
	    return new ArrayList<V>(pq);
	  }
}
