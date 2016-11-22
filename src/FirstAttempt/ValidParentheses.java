package FirstAttempt;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        
        Stack<Character> st = new Stack<Character>();
        String left = "([{";
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(left.contains(String.valueOf(c))) {
        		st.push(c);
        	}
        	else {
        		if(st.isEmpty()) return false;   ///////Remember!!! Check isEmpty() before pop out!!!
        		char t = st.pop();
        		if(!isMatch(t, c)) return false;
        	}
        }
        return st.isEmpty();
    }
	
	private static boolean isMatch(char a, char b){
		
        if((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')){
        	return true;
        } 
        return false;
    }
	
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		boolean res = vp.isValid("()");
		System.out.println(res);
	}
}
