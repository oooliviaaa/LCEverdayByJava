package FirstAttempt;

import java.util.Stack;

public class RemoveDuplicateLetters {

	// https://discuss.leetcode.com/topic/43469/java-o-n-solution-using-stack-with-detail-explanation
	/**
	 * go from the beginning of the string and start removing one if there is still the same character left and a smaller character is after it. 
	 * Given "bcabc", when you see a 'b', keep it and continue with the search, then keep the following 'c', then we see an 'a'. 
	 * Now we get a chance to get a smaller lexi order, you can check if after 'a', there is still 'b' and 'c' or not. 
	 * We indeed have them and "abc" will be our result.
	 * 
	 * Come to the implementation, we need some data structure to store the previous characters 'b' and 'c', 
	 * and we need to compare the current character with previous saved ones, 
	 * and if there are multiple same characters, we prefer left ones. This calls for a stack.
	 * 
	 * From the intuition, we know that we need to know if there are still remaining characters left or not. 
	 * So we need to iterate the array and save how many each characters are there. 
	 * 
	 * A visited array is also required since we want unique character in the solution. 
	 * The line while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) checks that the queued character should be removed or not, 
	 * like the 'b' and 'c' in the previous example. After removing the previous characters, push in the new char and mark the visited array.
	 * 
	 * Time complexity: O(n), n is the number of chars in string. Space complexity: O(n) worst case.
	 * */
	
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        
        Stack<Character> stack = new Stack<Character>();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	count[c-'a'] += 1;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	count[c-'a'] -= 1;
        	
        	if (visited[c-'a']) continue;
        	
        	while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) {
        		char pre = stack.pop();
        		visited[pre-'a'] = false;
        	}
        	
        	visited[c-'a'] = true;
        	stack.push(c);
        }
        
        StringBuffer res = new StringBuffer();
        
        // the for-each loop for Java's Stack iterates from the bottom of the stack.
        for (char c : stack) {
        	res.append(c);
        }
        return res.toString();
    }
	
}
