package LLLLLLLLL.FilterIterator;

public interface Predicate<T> {
	  /** @return true if the given T passes this predicate, and false otherwise */
	  public boolean apply(T sample);
}
