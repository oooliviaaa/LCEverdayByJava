package FirstAttempt;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	// http://blog.csdn.net/xudli/article/details/46784153
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if (!s2.isEmpty()) s2.pop();    /// 一定要把s2上面的都consume完再fill in s1里面的
    	else {
            while (!s1.isEmpty()) {
        	    s2.push(s1.pop());
            }
            s2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (!s2.isEmpty()) return s2.peek();    /// 一定要把s2上面的都consume完再fill in s1里面的
        else {
        	while (!s1.isEmpty()) {
            	s2.push(s1.pop());
            }
        	return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
