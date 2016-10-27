package FirstAttempt;

public class PathSumIII {

	// https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method
	public int pathSum(TreeNode root, int sum) {
        
    }
	
	
	
	
	
	
	/////////
	// 我的错误答案：必须从root到leaf满足和是sum才对
	public int pathSum_wrong(TreeNode root, int sum) {
        if (root == null || (root.left == null && root.right == null && root.val != sum)) return 0;
        if (root.left == null && root.right == null && sum == root.val) {
            return 1;
        }
        
        return pathSum_wrong(root.left, sum-root.val) + pathSum_wrong(root.right, sum-root.val);
    }
}
