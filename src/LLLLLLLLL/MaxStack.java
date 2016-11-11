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
    	if (max.isEmpty() || max.peek().compareTo(toPush) < 0) {
    		max.push(toPush);
    	}
    	stack.push(toPush);
    }

    // Peek returns the top value on the stack
    public T peek() {
    	if (stack.isEmpty()) return null;
    	return stack.peek();
    }
    // Pop removes and returns the top value on the stack
    public T pop() {
    	if (stack.isEmpty()) return null;
    	T top = stack.pop();
    	if (!max.isEmpty() && top.equals(max.peek())) {
    		max.pop();
    	}
    	return top;
    }
     
    // Two special methods, so this isn't just 'implement a stack'
    // PeekMax() returns the highest value in the stack (remember that T must implement Comparable)
    public T peekMax() {
    	if (max.isEmpty()) return null;
    	return max.peek();
    }
    // popMax() removes and returns the highest value in the stack
    public T popMax() {
    	if (max.isEmpty() || stack.isEmpty()) return null;
    	T curMax = max.pop();
    	while (!stack.isEmpty() && curMax != stack.peek()) {
    		stack.pop();
    	}
    	return curMax;
    }
}
