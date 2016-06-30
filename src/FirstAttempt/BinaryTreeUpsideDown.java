package FirstAttempt;

public class BinaryTreeUpsideDown {

	// http://blog.csdn.net/whuwangyi/article/details/43186045
	// process one by one
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        
        TreeNode parent = null;
        TreeNode preRight = null;
        while (root != null) {
        	TreeNode left = root.left;
        	root.left = preRight; // 此轮处理的node的left应该是上轮得到的right
        	preRight = root.right;  //下一轮的right就应该是此轮node的right child
     
        	root.right = parent; // 此轮处理的node的right应该是上轮的parent
        	parent = root;   //而下轮的parent就应该是此轮处理的的node
        	
        	root = left;  // 下轮该处理的node就应该是此轮node的left了
        }
        
        return parent;
    }
}
