package InterestingQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Yahoo Qiao 同事编的
public class StringStackManipulate {

	public boolean isSatckManipulated(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) return false;
		Stack<Character> stack = new Stack<Character>();
		int p = 0; int q = 0;
		while (p < a.length()) {
			char ac = a.charAt(p);
			char bc = b.charAt(q);
			if (ac == bc) {
				p++;
				q++;
				continue;
			}
			
			while (!stack.isEmpty() && bc == stack.peek()) {
				stack.pop();
				q++;
			}
			stack.push(ac);
			p++;
		}
		
		while (q < b.length() && !stack.isEmpty()) {
			int cur = stack.pop();
			if (cur != b.charAt(q)) return false;
			q++;
		}
		return q == b.length();
	}
	
	/////////////////
	// follow up: print out all the qualified string b
	public List<String> isSatckManipulated(String s) {
		List<String> res = new ArrayList<String>();
		Stack<Character> stack = new Stack<Character>();
		
		backtracking(s, 0, "", stack, res);
		return res;
	}
	
	private void backtracking(String s, int index, String tmp, Stack<Character> stack, List<String> res) {
		if (index == s.length()) {
            Stack<Character> st = (Stack<Character>) stack.clone();  ///// 不能在原stack上进行pop!!!会破坏backtracking
			while (!st.isEmpty()) {
				char c = st.pop();
				tmp += c;
			}
			res.add(tmp);			
			return;
		}
				
		if (!stack.isEmpty()) {
			char c = stack.pop();
			backtracking(s, index, tmp+c, stack, res);
			stack.push(c);
		}
		stack.push(s.charAt(index));
		backtracking(s, index+1, tmp, stack, res);
		stack.pop();
	}
	
	
	/////////////////
	// test cases
	public static void main(String[] args) {
		StringStackManipulate ss = new StringStackManipulate();
		String a = "abcd";
		String b = "dcba";  //dcba, cdab, abcd  // dabc
		boolean res = ss.isSatckManipulated(a, b);
		System.out.println(res);
		
		String s = "abcd";
		List<String> res2 = ss.isSatckManipulated(s);
		for (String r : res2) {
			System.out.println(r);
		}
	}
}
