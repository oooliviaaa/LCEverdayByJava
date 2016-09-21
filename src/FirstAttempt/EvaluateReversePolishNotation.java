package FirstAttempt;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	// http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
	// stack
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
        	return 0;
        }
        
        String operators = "+-*/";
        Stack<Integer> s = new Stack<Integer>();
        
        for (int i = 0; i < tokens.length; i++) {
        	String c = tokens[i];
        	if (operators.contains(c)) {
        		int a = s.pop();
        		int b = s.pop();
        		switch (c) {
        			case "+":
        				s.push(a + b); 
        				break;
        			case "-":
        				s.push(b - a);
        				break;
        			case "*":
        				s.push(a * b);
        				break;
        			case "/":
        				s.push(b / a);
        				break;
        		}
        	} else {
        		s.push(Integer.parseInt(c));
        	}
        }
        
        return s.pop();
    }
}
