package FirstAttempt;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DesignPhoneDirectory {
	
	// http://www.programcreek.com/2014/08/leetcode-design-phone-directory-java/
	Queue<Integer> queue;
	Set<Integer> hs;
	int max;
	
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public DesignPhoneDirectory(int maxNumbers) {
		queue = new LinkedList<Integer>();
		hs = new HashSet<Integer>();
		
		for (int i = 0; i < maxNumbers; i++) {
			queue.offer(i);
		}
		max = maxNumbers - 1;
	}

	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
		if(queue.isEmpty()) return -1;
		int num = queue.poll();
	    hs.add(num);
	    return num;
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number) {
	    return !hs.contains(number) && number <= max;
	}
	
	/** Recycle or release a number. */
	public void release(int number) {
	    if (hs.contains(number)) {
	    	hs.remove(number);
	    	queue.offer(number);
	    }
	}
}
