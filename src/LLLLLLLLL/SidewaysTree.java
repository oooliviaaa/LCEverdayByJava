package LLLLLLLLL;

public class SidewaysTree {

	/**
	 * for example, turn these:
	 *
	 *        1                1
	 *       / \              / \
	 *      2   3            2   3
	 *     / \
	 *    4   5
	 *   / \
	 *  6   7
	 *
	 * where 6 is the new root node for the left tree, and 2 for the right tree.
	 * oriented correctly:
	 *
	 *     6                  2
	 *    / \                / \
	 *   7   4              3   1
	 *      / \
	 *     5   2
	 *        / \
	 *       3   1
	 */
	public TreeNode reverse(TreeNode node) {
	    if (node == null || node.left == null) return node;
	    TreeNode newHead = reverse(node.left);
	    
	    node.left.right = node;
	    node.left.left = node.right;
	    
	    node.left = null;
	    node.right = null;
	    return newHead;
	}
	
	
	////////////////////
	
	public TreeNode reverse_iterate(TreeNode node) {
		  TreeNode top = node;
		  TreeNode currNode = node.left;
		  TreeNode right = node.right;
		  TreeNode newLeft;
		  TreeNode newRight;
		
		  node.left = null;  ///// !!!!! fix the root cycle problem
		  node.right = null;
		 
		  while (currNode != null) {
		    newLeft = currNode.left;
		    newRight = currNode.right;
		 
		    currNode.right = top;
		    currNode.left = right;
		 
		    top = currNode;
		    right = newRight;
		    currNode = newLeft;
		  }
		 
		  return top;
		}
}
