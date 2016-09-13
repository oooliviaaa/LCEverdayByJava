package FirstAttempt;

public class ConvertSortedArray2BST {

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) return null;
		
		return helper(num, 0, num.length-1);
	}
	
	private TreeNode helper(int[] num, int st, int ed) {
		if (st < 0 || st >= num.length || ed < 0 || ed >= num.length || st > ed) {
			return null;   ////////////////// leave's kid  !!!!
		}
		
		int mid = (st + ed) / 2;
		TreeNode cur = new TreeNode(num[mid]);
		cur.left = helper(num, st, mid-1);
		cur.right = helper(num, mid+1, ed);
		return cur;        //////////////////    !!!!!
	}
}
