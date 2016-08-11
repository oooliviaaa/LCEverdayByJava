package FirstAttempt;

public class MinimumDepthBinaryTree {

	public int minDepth(TreeNode root) {
		if(root == null) return 0;
        int depth1 = minDepth(root.left);
        int depth2 = minDepth(root.right);
        
        if(depth1 == 0 && depth2 != 0) return depth2 + 1;
        if(depth2 == 0 && depth1 != 0) return depth1 + 1;
        
        return Math.min(depth1, depth2) + 1;
    }
}
