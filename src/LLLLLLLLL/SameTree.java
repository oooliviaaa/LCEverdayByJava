package LLLLLLLLL;

public class SameTree {
	
	// Understand that the time complexity is on the order of the number of nodes for the smaller tree
	// Understand that the recursive solution might fail for very deep trees (stack overflow).
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
