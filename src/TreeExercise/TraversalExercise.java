package TreeExercise;

import java.util.Stack;

public class TraversalExercise {

	
	public static void preOrderTraversalIter(TreeNode head) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(head);
		
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			System.out.println(node.val);
			
			if (node.right != null) {
				s.push(node.right);
			}
			if (node.left != null) {
				s.push(node.left);
			}
		}
	}
	
	public static void inOrderTraversalIter(TreeNode head) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = head;
		while(true) {
			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			
			if(s.isEmpty()) break;
			
			cur = s.pop();
			System.out.println(cur.val);
			cur = cur.right;
			
		}
	}
	
	public static void postOrderTraversalIter(TreeNode head) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(head);
		while (!s1.isEmpty()) {
			TreeNode cur = s1.pop();
			s2.push(cur);
			
			if (cur.left != null) s1.push(cur.left);
			if (cur.right != null) s1.push(cur.right);
		}
		
		while (!s2.isEmpty()) {
			System.out.println(s2.pop());
		}
		
	}
}
