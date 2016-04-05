package TreeExercise;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

	
	public ArrayList<TreeNode> inOrderIteration(TreeNode root) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(root == null) return res;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		TreeNode cur = root;
		while(true) {	
			// put all left children in stack
			while(cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			
			if(s.isEmpty()) break;
			
			cur = s.pop();
			res.add(cur);
			cur = cur.right;
		}
		return res;
	}
}
