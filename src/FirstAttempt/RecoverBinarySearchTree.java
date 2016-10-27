package FirstAttempt;

import java.util.Stack;

public class RecoverBinarySearchTree {

	// Inorder traversal will return values in an increasing order. 
	// So if an element is less than its previous element, the previous element is a swapped node.
	public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
        	while (cur != null) {
        		s.push(cur);
        		cur = cur.left;
        	}
        	
        	if (s.isEmpty()) break;
        	
        	cur = s.pop();
        	if (pre != null) {
        		if (cur.val < pre.val) {
        			if (first == null) {
        				first = pre;
        			}
        			second = cur;
        		}
        	}
    		pre = cur;
    		
    		cur = cur.right;
        }
        
        if (first != null && second != null) {
        	int tmp = first.val;
        	first.val = second.val;
        	second.val = tmp;
        }
    }
}
