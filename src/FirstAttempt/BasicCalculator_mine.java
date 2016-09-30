package FirstAttempt;

import java.util.Stack;

public class BasicCalculator_mine {

	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<String> stack = new Stack<String>();
        
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		int j = i+1;
        		int num = c - '0';
        		while (j < s.length() && Character.isDigit(s.charAt(j))) {
        			num = num * 10 + s.charAt(j);
        		}
        		stack.push(num+"");
        		i = j-1;
        	} else if (c == ')') {
        		int num = 0;
        		int pre = Integer.parseInt(stack.pop());
        		while (!stack.isEmpty() && stack.peek() != "(") {
        			String cur = stack.pop();
        			if (cur == "+") {
        				num += pre;
        			} else if (cur == "-") {
        				num -= pre;
        			} else {
        				pre = Integer.parseInt(cur);
        			}
        		}
        		stack.pop();
        		stack.push(num+"");
        	} else {
        		stack.push(c+"");
        	}
        	
        }
        
        int num = 0;
        int pre = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
			String cur = stack.pop();
			System.out.println(cur);
			if (cur == "+") {
				num += pre;
			} else if (cur == "-") {
				num -= pre;
			} else {
				pre = Integer.parseInt(cur);
			}
		
        }
        return num;
    }
	
	
	
	///////奇淫技巧/////////// 
	// http://blog.csdn.net/ljiabin/article/details/46489997
	public int calculate2(String s) {  
        Stack<Integer> stack = new Stack<Integer>();  
        stack.push(1);  
        stack.push(1);  
        int res = 0;  
        for (int i = 0; i < s.length(); i++) {  
            char c = s.charAt(i);  
            if (Character.isDigit(c)) {  
                int num = c - '0';  
                int j = i + 1;  
                while (j < s.length() && Character.isDigit(s.charAt(j))) {  
                    num = 10 * num + (s.charAt(j) - '0');  
                    j++;  
                }  
                res += stack.pop() * num;  
                i = j - 1;  
            } else if (c == '+' || c == '(') {  
                stack.push(stack.peek());  
            } else if (c == '-') {  
                stack.push(-1 * stack.peek());  
            } else if (c == ')') {  
                stack.pop();  
            }  
        }  
        return res;  
    }  
	
	public static void main(String[] args) {
		BasicCalculator_mine bc = new BasicCalculator_mine();
		int res = bc.calculate("1-(15-3)");
		System.out.println(res);
	}
}
