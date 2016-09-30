package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	
	// http://blog.csdn.net/ljiabin/article/details/46489545
	// Solution 2. push: O(n)，pop: O(1)，top: O(1) 
	/**
	 * 每次push时，把新元素放到空的q2，然后把q1中元素逐个添加到q2的队尾，最后交换q1和q2。
	 * 这样q1队首的元素就是最后添加的元素，pop和top直接返回q1队首的元素就好。
	 * */
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
        	q2.offer(q1.poll());
        }
        
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
