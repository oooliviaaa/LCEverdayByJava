package FirstAttempt;

public class HouseRobberIII {

	// http://www.programcreek.com/2015/03/leetcode-house-robber-iii-java/
	// recursion
	/**
	 * Traverse down the tree recursively. 
	 * We can use an array to keep 2 values: 
	 * the maximum money when a root is selected and the maximum value when a root if NOT selected.
	 * */
	public int rob(TreeNode root) {
		if(root == null)
	        return 0;
	 
		// res[0] is when root is selected, result[1] is when not. 
	    int[] res = getMaxMoney(root);
	    return Math.max(res[0], res[1]);
	}
	
	private int[] getMaxMoney(TreeNode root) {
		if(root == null){
	        int[] result = {0, 0};
	        return result;
	    }
		
		int[] left = getMaxMoney(root.left);
		int[] right = getMaxMoney(root.right);
		
		int[] res = new int[2];
		res[0] = root.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
		
	}
}
