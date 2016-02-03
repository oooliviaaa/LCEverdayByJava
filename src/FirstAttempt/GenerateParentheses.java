package FirstAttempt;

import java.util.ArrayList;

public class GenerateParentheses {

	//////////use StringBuilder/////////
	//  StringBuilder sb.append(c) will add to the same sb, so need to remove the previously added "(", and add new ")"
	// http://xiaochenchen.github.io/blog/2014/03/30/leetcode-generate-parentheses/
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if(n <= 0) return res;
		StringBuilder sb = new StringBuilder();
		helper(res, sb, n, n);   // n remain count for left parenthese, and right parenthese
		return res;
	}
	
	private void helper(ArrayList<String> res, StringBuilder tmp, int left, int right) {
		if(left == 0 && right == 0) {
			System.out.println("new result 1 >>>" + tmp);
			res.add(tmp.toString());
			return;   //////////////////// REMEMBER to return!!!
		}
		
		if(left > 0) {
			tmp.append("(");
			helper(res, tmp, left-1, right);
			tmp.deleteCharAt(tmp.length()-1);
		}
		if(right > 0 && right > left) {  //////////////// left must appear behind right. So right remain counter must bigger than left, then we can add more right
			tmp.append(")");
			helper(res, tmp, left, right-1);
			tmp.deleteCharAt(tmp.length()-1);
		}
	}
	
	
	//////////use String/////////
	// String+"" will create a new String, so no need to remove the newly added "(" or ")"
	// http://www.jiuzhang.com/solutions/generate-parentheses/
	public ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper2(result, "", n, n);
        return result;
    }
    
	public void helper2(ArrayList<String> result,
	                   String paren, // current paren
	                   int left,     // how many left paren we need to add
	                   int right) {  // how many right paren we need to add
		if (left == 0 && right == 0) {
			System.out.println("new result 2 >>>" + paren);
			result.add(paren);
			return;
		}

        if (left > 0) {
		    helper2(result, paren + "(", left - 1, right);
        }
        
        if (right > 0 && left < right) {
		    helper2(result, paren + ")", left, right - 1);
        }
	}
	
	
	
	
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		ArrayList<String> res1 = gp.generateParenthesis(8);
		ArrayList<String> res2 = gp.generateParenthesis2(8);
	}
        
}
