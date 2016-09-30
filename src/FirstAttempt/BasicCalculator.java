package FirstAttempt;

import java.util.Stack;

public class BasicCalculator {

	// http://blog.csdn.net/ljiabin/article/details/46489997
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();  // stack是用来存储每个数字的符号的
        stack.push(1);
        stack.push(1);
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		int num = c - '0';
        		int j = i+1;
        		while (j < s.length() && Character.isDigit(s.charAt(j))) {
        			num = num * 10 + (s.charAt(j) - '0');
        			j++;
        		}
        		res += stack.pop() * num;
        		i = j-1;   ///// !!!!!
        	} else if (c == '+' || c == '(') {  // 同号
        		stack.push(stack.peek());
        	} else if (c == '-') {   // 异号
        		stack.push(-1 * stack.peek());
        	} else if (c == ')') {  // 这个closure结束了，相当于'('括号前的那个符号影响力结束了，要把它pop出去。
        		stack.pop();
        	}
        	
        }
        
        return res;
    }
}
