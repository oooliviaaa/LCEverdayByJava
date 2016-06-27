package FirstAttempt;

import java.util.ArrayList;

public class MaximumDepthBinaryTree {

	///////////recursion////////////
	public int maxDepthRecursion(TreeNode root) {
		if (root == null) return 0;
		return getDepth(root, 1); // root != null --> current existing nodes start with 1
	} 
	
	private int getDepth(TreeNode node, int currentDepth) {
		int left = currentDepth;  // Initialized
		int right = currentDepth;
		
		if (node.left != null) left = getDepth(node.left, currentDepth+1);
		if (node.right != null) right = getDepth(node.right, currentDepth+1);
		
		return left > right ? left : right;
	}
	
	
	///////////iteration//////////
	public int maxDepthIteration(TreeNode root) {
        if(root == null)    return 0;
         
        // Non-recursive, use level order triversal
        ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);
        int depth = 0;
         
        while(!curLevel.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node : curLevel) {
                if(node.left != null)   nextLevel.add(node.left);
                if(node.right != null)  nextLevel.add(node.right);
            }
            curLevel = new ArrayList<TreeNode>(nextLevel);
            depth++;
        }
         
        return depth;
    }
	
}
