package FirstAttempt;

public class CountUnivalueSubtrees {

	private int count = 0;  ///// !!!!!
	
	public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
        	return count;
        }
        
        isUnivalTree(root);
        return count;
    }
	
	private boolean isUnivalTree(TreeNode root) {
		if (root == null) return true;
		if (root.left == null && root.right == null) {
			count++;
			return true;
		}
		
		boolean left = isUnivalTree(root.left) ;   ///// 一定要这样分开写！！而不是写进if条件中，
		boolean right = isUnivalTree(root.right);  ///// 因为if条件中&&中如果前一个条件为false，后面的都不会执行，这样会count变小
		if (left && right
			&& (root.left == null || root.left.val == root.val)         ///// !!!!!
			&& (root.right == null || root.right.val == root.val)) {    ///// !!!!!
			count++;
			return true;
		}
		return false;
	}
}
