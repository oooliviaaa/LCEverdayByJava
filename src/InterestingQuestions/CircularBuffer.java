package InterestingQuestions;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class CircularBuffer<T> {

  private T[] buffer;
  private int tail;
  private int head;
  private int size;
  private int maxSize;

  @SuppressWarnings("unchecked")
  public CircularBuffer(int n) {
    buffer = (T[]) new Object[n];
    tail = 0;
    head = 0;
    size = 0;
    maxSize = n;
  }

  public void add(T toAdd) {
    if (!isFull()) {
    	size++;
        buffer[head++] = toAdd;
    } else {
        throw new BufferOverflowException();
    }
    head = head % buffer.length;
  }

  public T get() {
    T t = null;
    if (!isEmpty()) {
    	size--;
        t = (T) buffer[tail++];
        tail = tail % buffer.length;
    } else {
        throw new BufferUnderflowException();
    }
    return t;
  }

  public boolean isEmpty() {
      return size == 0;
  }
  /** function to check if buffer is full **/
  public boolean isFull() {
      return size == maxSize;
  } 
  
  public String toString() {
    return "CircularBuffer(size=" + buffer.length + ", head=" + head + ", tail=" + tail + ")";
  }

}