package FirstAttempt;

public class LowestCommonAncestorOfBST {
	// iteration
	
	
	
	// recursion
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
            return null;
        }
		
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
     
        return root;  // 第一次root.val在p.val、 q.val之间时，就是分叉之处
    }
    
}
