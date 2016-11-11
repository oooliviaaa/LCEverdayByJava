package InterestingQuestions;

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
	
	public static void main(String[] args) {
		StringStackManipulate ss = new StringStackManipulate();
		String a = "abcd";
		String b = "dcba";  //dcba, cdab, abcd  // dabc
		boolean res = ss.isSatckManipulated(a, b);
		System.out.println(res);
	}
}
