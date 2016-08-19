package FirstAttempt;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
        if (root != null) invertBinaryTree(root);
        return root;
    }
	
	private void invertBinaryTree(TreeNode node) {
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		
		if (node.left != null) invertBinaryTree(node.left);
		if (node.right != null) invertBinaryTree(node.right);
	}
}
