package FirstAttempt;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	Integer cache;
	Iterator<Integer> iterator;
	
	// https://segmentfault.com/a/1190000003794961
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    cache = this.iterator.next();
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		Integer res = cache;
	    cache = iterator.hasNext() ? iterator.next() : null;
	    return res;
	}


	public boolean hasNext() {
	    return cache != null || iterator.hasNext();
	}
}
