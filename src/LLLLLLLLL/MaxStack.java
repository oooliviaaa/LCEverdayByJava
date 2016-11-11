package LLLLLLLLL;

import java.util.Stack;

public class MaxStack<T extends Comparable<T>> {

	Stack<T> stack;
	Stack<T> max;
	
	public MaxStack() {
		stack = new Stack<T>();
		max = new Stack<T>();
	}
	
	// The standard three Stack methods - push adds an element to the stack
    public void push(T toPush) {
    	
    }

    // Peek returns the top value on the stack
    public T peek() {
    	
    }
    // Pop removes and returns the top value on the stack
    public T pop() {
    	
    }
     
    // Two special methods, so this isn't just 'implement a stack'
    // PeekMax() returns the highest value in the stack (remember that T must implement Comparable)
    public T peekMax() {
    	
    }
    // popMax() removes and returns the highest value in the stack
    public T popMax() {
    	
    }
}
