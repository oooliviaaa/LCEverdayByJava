package FirstAttempt;

public class ConstructBTfromPreorderInorderTraversal {

	// http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
	/**
	 * From the pre-order array, we know that first element is the root. 
	 * We can find the root in in-order array. 
	 * Then we can identify the left and right sub-trees of the root from in-order array.
	 * Using the length of left sub-tree of in-order array, we can identify left and right sub-trees in pre-order array. 
	 * Recursively, we can build up the tree. 
	 * */
	// preorder traversal，root是第一个，root.left是第二个，以此类推。。。
	// inorder traversal就像是把树从上往下拍平了。所以root在最中间，root.left在左半部的最中间，root.right在右半部的最中间，以此类推。。。
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length != preorder.length) {
            return null;
        }
		return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
		
	}
	
	private TreeNode helper(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
		if (startPre < endPre || startIn < endIn) {
			return null;
		}
		
		int rootVal = preorder[0];
		TreeNode root = new TreeNode(rootVal);
		
		// find the root position in inorder array
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			int val = inorder[i];
			if (rootVal == val) {
				k = i;
				break;
			}
		}
		
		// preorder的index比较不太好想，记得要减去startIn，
		// 因为k是inorder array中在startIn之后开始逐个遍历找到的一个位置，直接+k的位置是过长的，k需要减掉之前inorder array中startIn的位移
		root.left = helper(preorder, startPre+1, startPre+(k-startIn), inorder, startIn, k-1);  /////// startPre+k-startIn !!!!!
		root.right = helper(preorder, startPre+(k+1-startIn), endPre, inorder, k+1, endIn);    ////// startPre+k+1-startIn !!!!!
		return root;
    }
}
