package FirstAttempt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	// http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/
	// solve by using a queue. On each level of the tree, we add the right-most element to the results.
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		 
	    if(root == null) return res;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    
	    while (!queue.isEmpty()) {
	    	int size = queue.size();
	    	
	    	for (int i = 0; i < size; i++) {
	    		TreeNode node = queue.poll();
	    		
	    		if (i == 0) res.add(node.val);
	    		
	    		if (node.right != null) queue.offer(node.right);
	    		if (node.left != null) queue.offer(node.left);
	    	}
	    }
	    return res;
    }
}
