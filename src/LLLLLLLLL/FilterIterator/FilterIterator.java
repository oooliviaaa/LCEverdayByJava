package LLLLLLLLL.FilterIterator;

import java.util.Iterator;

public abstract class FilterIterator<T> {
  public Predicate<T> selector;
  public Iterator<T> source;
 
  public FilterIterator(Predicate<T> selector, Iterator<T> source) {
	  this.selector = selector;
	  this.source = source;
  }
 
  /** A call to next() would not throw a NoSuchElementException. */
  public abstract boolean hasNext();
 
  /** Returns the next element in the underlying iterator that passes this FilterIterator's Predicate
   * @throws NoSuchElementException if there are no more elements passing the Predicate available
   */
  public abstract T next();
}
 
/* This is a supporting interface, it does not need to be implemented */

