package FirstAttempt;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
	
	private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
}
