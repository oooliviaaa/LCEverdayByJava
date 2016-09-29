package FirstAttempt;

public class CountCompleteTreeNodes {

	// http://blog.csdn.net/xudli/article/details/46385011
	// http://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int left = getLeftMostHeight(root.left) + 1;
        int right = getRightMostHeight(root.right) + 1;
        
        if (left == right) return (2<<(left-1))-1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
	
	private int getLeftMostHeight(TreeNode root) {
		int count = 0;
		while (root != null) {
			root = root.left;
			count++;
		}
		return count;
    }
    
    private int getRightMostHeight(TreeNode root) {
		int count = 0;
		while (root != null) {
			root = root.right;
			count++;
		}
		return count;
    }
}
