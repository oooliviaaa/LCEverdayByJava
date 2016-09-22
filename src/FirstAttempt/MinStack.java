package FirstAttempt;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> s1;
	Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= s2.peek()) {
        	s2.push(x);
        }
    }
    
    public void pop() {
    	if (s1.isEmpty()) return;
        int x = s1.pop();
        if (!s2.isEmpty() && x == s2.peek()) {
        	s2.pop();
        }
    }
    
    public int top() {
        if (!s1.isEmpty()) return s1.peek();
        else return Integer.MAX_VALUE;
    }
    
    public int getMin() {
    	if (!s2.isEmpty()) return s2.peek();
    	else return Integer.MAX_VALUE;
    }
}
