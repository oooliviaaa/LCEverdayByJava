package FirstAttempt;

import java.util.Stack;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		if(s == null || s.length() <= 1) return 0;
		
		int accumulateLen = 0;
		int maxLen = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				st.push(i);
			}
			else {
				if(st.isEmpty()) {
					accumulateLen = 0;  // mismatch happens
				}
				else {
					int matchPos = st.pop();
					int matchLen = i - matchPos + 1;
					if(st.isEmpty()) {  // in order to remember the previous completed substrings (eg. "(()) ()" )
						accumulateLen += matchLen;
						matchLen = accumulateLen;
					}
					else {  
						System.out.println("HERE");
						matchLen = i - st.peek();  ////////////// Remember!!! The case needs considered!!! Be careful!!!
													///////////// eg. "(()()", the stack will never be empty, 
													///////////// but valid parentheses have to start at index=1 position.
					}
					maxLen = Math.max(matchLen, maxLen);
				}
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "(()()";
		LongestValidParentheses lv = new LongestValidParentheses();
		int res = lv.longestValidParentheses(s);
		System.out.println("res >>> " + res);
	}
}
