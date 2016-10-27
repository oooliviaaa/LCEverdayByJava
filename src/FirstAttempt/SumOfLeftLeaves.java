package FirstAttempt;

public class SumOfLeftLeaves {
	
	// https://discuss.leetcode.com/topic/64614/java-recursive
	public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
