package LLLLLLLLL.FilterIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIteratorImpl<T> extends FilterIterator<T> {

	boolean findNext;
	T next;
	
	public FilterIteratorImpl(Predicate<T> selector, Iterator<T> source) {
		super(selector, source);
		findNext =  false;
	}

	@Override
	public boolean hasNext() {
		while (!findNext && source.hasNext()) {
			next = source.next();
			findNext = selector.apply(next);
		}
		return findNext;
	}

	@Override
	public T next() {
		if (!findNext) {
			throw new NoSuchElementException();
		}
		
		findNext = false;
		return next;
	}

}
