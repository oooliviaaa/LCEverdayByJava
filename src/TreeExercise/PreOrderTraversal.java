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
		s.add(root);
		
		while(!s.isEmpty()) {
			TreeNode cur = s.pop();
			res.add(cur);
			
			if(cur.left != null) s.add(cur.left);
			if(cur.right != null) s.add(cur.right);
		}
		return res;
	}
	
}
