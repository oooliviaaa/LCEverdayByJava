package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {

	// http://www.cnblogs.com/grandyang/p/4944875.html
	// 因为是要找最少去除记个-->BFS
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		Set<String> visited = new HashSet<String>();   ///// 去重 + 防止dead loop !!!!!
		visited.add(s);
		Queue<String> queue = new LinkedList<String>();
		queue.offer(s);
		boolean findShortest = false;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (isValid(cur)) {
					res.add(cur);
					findShortest = true;
				} 
				if (findShortest) continue;   ///// 一旦找到答案，就再也不往queue里加东西了!!!!!
				
				// if cur is invalid && haven't found any valid
				for (int j = 0; j < cur.length(); j++) {
					if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
						String next = cur.substring(0, j) + cur.substring(j+1);
						if (!visited.contains(next) && next.length() >= 0) {
							queue.offer(next);
							visited.add(next);
						}
					}
				}
			}
		}
		
		return res;
    }
	
	private boolean isValid(String s) {
		if (s == null) return false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push('(');
			} else if (c == ')') {
				if (stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.size() == 0;
	}
	
	public static void main(String[] args) {
		String s = "()(((((((()";
		RemoveInvalidParentheses rp = new RemoveInvalidParentheses();
		List<String> res = rp.removeInvalidParentheses(s);
		
		for (String r : res) System.out.println(r);
				
	}
}
