package FirstAttempt;

public class LowestCommonAncestorofBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!(isInThisTree(root, p) && isInThisTree(root, q))) {
        	return null;
        }
        return findAncestor(root, p, q);
    }
	
	private boolean isInThisTree(TreeNode root, TreeNode p) {
		if (root == null || p == null) return false;
		if (root == p) return true;
		return isInThisTree(root.left, p) || isInThisTree(root.right, p);
	}
	
	private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p || root == q) return root;
		
		boolean isOnLeft_p = isInThisTree(root.left, p);
		boolean isOnLeft_q = isInThisTree(root.left, q);
		
		if (isOnLeft_p != isOnLeft_q) return root;
		TreeNode nextRoot = isOnLeft_p ? root.left : root.right;
		return findAncestor(nextRoot, p, q);
		
	}
}
