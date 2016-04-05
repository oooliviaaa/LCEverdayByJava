package TreeExercise;

import java.util.ArrayList;
import java.util.Stack;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}

public class PreOrderTraversal {
	
	
	public ArrayList<TreeNode> preOrderIteration(TreeNode root) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(root == null) return res;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		
		while(!s.isEmpty()) {
			TreeNode cur = s.pop();
			res.add(cur);
			
			if(cur.right != null) s.push(cur.right);  ///////// !!! right first
			if(cur.left != null) s.push(cur.left);
			
		}
		return res;
	}
	
}
