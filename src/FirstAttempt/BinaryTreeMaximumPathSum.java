package FirstAttempt;

public class BinaryTreeMaximumPathSum {

	// http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
	/**
	 * 1) Recursively solve this problem
	 * 2) Get largest left sum and right sum
	 * 3) Compare to the stored maximum
	 * */
	
	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        return max;
    }
	
	private int helper(TreeNode node) {
		if (node == null) return 0;
		
		int left = helper(node.left);
		int right = helper(node.right);
		
		int curMax = node.val + (left > 0 ? left : 0) + (right > 0 ? right : 0); // 当前node作为left right的连接点时，加上左右两侧的结果，可以得到当前最大值
		
		max = Math.max(curMax, max);
		
		int cur = node.val + Math.max(0, Math.max(left, right));   // 当前node作为path中一员时，只能从left right中取一个。
		return cur;
	}
}
