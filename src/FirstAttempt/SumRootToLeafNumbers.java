package FirstAttempt;

public class SumRootToLeafNumbers {

	int sum = 0;
	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		helper(root, 0);
		return sum;
    }
	
	private void helper(TreeNode root, int num) {
		if (root == null) return;
		
		num = num * 10 + root.val;
		
		if (root.left == null && root.right == null) {  // leaf
			sum += num;
			return;
		}
		
		helper(root.left, num);
		helper(root.right, num);
		
	}
	
	
	//////////////////
	// http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/
	// solution 2
	public int sumNumbers_2(TreeNode root) {
	    if(root == null) 
	        return 0;
	 
	    return dfs(root, 0, 0);
	}
	 
	public int dfs(TreeNode node, int num, int sum){
	    if(node == null) return sum;
	 
	    num = num*10 + node.val;
	 
	    // leaf
	    if(node.left == null && node.right == null) {
	        sum += num;
	        return sum;
	    }
	 
	    // left subtree + right subtree
	    sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
	    return sum;
	}
}
