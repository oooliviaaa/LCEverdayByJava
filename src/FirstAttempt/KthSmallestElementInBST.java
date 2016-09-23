package FirstAttempt;

import java.util.Stack;

public class KthSmallestElementInBST {

	// http://www.programcreek.com/2014/07/leetcode-kth-smallest-element-in-a-bst-java/
	// in order traversal --> find kth element
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (true) {
        	while (cur != null) {
        		s.push(cur);
        		cur = cur.left;
        	}
        	
        	if (s.isEmpty()) break;
        	
        	cur = s.pop();
        	k--;
        	
        	if (k == 0) return cur.val;
        	
        	cur = cur.right;
        }
        
        return -1;
    }
}
