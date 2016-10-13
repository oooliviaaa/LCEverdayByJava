package FirstAttempt;

public class ConstructBTfromInorderPostorderTraversal {

	// http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
	/**
	 * From the post-order array, we know that last element is the root. 
	 * We can find the root in in-order array. 
	 * Then we can identify the left and right sub-trees of the root from in-order array.
	 * Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. 
	 * Recursively, we can build up the tree.
	 * */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
	
	private TreeNode helper(int[] postorder, int startPost, int endPost, int[] inorder, int startIn, int endIn) {
		if (startPost > endPost || startIn > endIn) return null;
		
		int rootVal = postorder[endPost];
		TreeNode root = new TreeNode(rootVal);
		
		int k = 0;
		for (int i = startIn; i <= endIn; i++) {
			if (rootVal == inorder[i]) {
				k = i;
				break;
			}
		}
		
		root.left = helper(postorder, startPost, startPost-startIn+k-1, inorder, startIn, k-1);
		root.right = helper(postorder, startPost-startIn+k, endPost-1, inorder, k+1, endIn);
		return root;
	}
}
