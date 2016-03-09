package TreeExercise;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

	public ArrayList<TreeNode> postOrderIteration(TreeNode root) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(root == null) return res;
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			TreeNode cur = s1.pop();
			s2.add(cur);
			
			if(cur.left != null) s2.push(cur.left);
			if(cur.right != null) s1.push(cur.right);
		}
		
		while(!s2.isEmpty()) {
			TreeNode tmp = s2.pop();
			res.add(tmp);
		}
		return res;
		
	}
}
