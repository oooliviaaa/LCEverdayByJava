package FirstAttempt;

public class ClosestBinarySearchTreeValue {

	// https://segmentfault.com/a/1190000003797291
	public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        
        while (root != null) {
        	closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
        	TreeNode nextRoot = target > root.val ?  root.right : root.left;
        	root = nextRoot;
        }
        return closest;
    }
}
