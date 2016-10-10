package FirstAttempt;

public class BinaryTreeLongestConsecutiveSequence {

	
	public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        return findLongest(root, 0, root.val-1);   ///// 为了能够符合recursion规律，现将preVal设置成root.val-1
    }
	
	private int findLongest(TreeNode node, int len, int preVal) {
		if (node == null) return len;
		
		int curLen = (node.val == preVal+1) ? len+1 : 1;
		return Math.max(curLen, Math.max(findLongest(node.left, curLen, node.val), findLongest(node.right, curLen, node.val)));
	}
}
