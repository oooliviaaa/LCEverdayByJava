package FirstAttempt;

public class LargestBSTSubtree {

	// http://blog.csdn.net/likecool21/article/details/44080779
	// 简单做法是对于每个node都进行一遍isBST的测试，找出最大的那个。 - top-down的访问
	public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
		if (isBST(root)) {
        	return size(root);
        }
		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
	
	private int size(TreeNode node) {
		if (node == null) return 0;
		return 1 + size(node.left) + size(node.right);
	}
	
	private boolean isBST(TreeNode node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode node, int min, int max) {
		if (node == null) return true;
		if (node.val <= min || node.val >= max) return false;
		return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
	}
	
	
	////////////////////////////
	// solution 2
	/**
	 * bottom-up的方法，根据左子树和右子树返回的信息就可以判断当前子树是不是BST。每个子树需要返回的信息有三个：
	 * 	1. 子树是不是BST
	 * 	2.MAX VALUE in this sub tree
	 * 	3.min value in this sub tree
	 * 首先递归得到左右子树的结果，然后如果当前node.val>left.max&&node.val<right.min，切左右子树都是BST，则已当前node为根的子树也是BST。
	 * */
	
	private int res = 0;
	public int largestBSTBetter(TreeNode root){
		largestBSTHelper(root);
		return res;
	}
	
	private Data largestBSTHelper(TreeNode root){
		Data curr = new Data();
		if(root == null){
			curr.isBST = true;
			curr.size = 0;
			return curr;
		}
		
		Data left = largestBSTHelper(root.left);
		Data right = largestBSTHelper(root.right);
		
		curr.min = Math.min(root.val, Math.min(right.min,left.min));
		curr.max = Math.max(root.val, Math.max(right.max, left.max));
		if(left.isBST && root.val > left.max && right.isBST && root.val < right.min){
			curr.isBST = true;
			curr.size = 1 + left.size + right.size;
			if(curr.size > res)
				res = curr.size;
		}
		else{
			curr.size = 0;
		}
		return curr;
	}



	
	// Test cases
	public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n1 = new TreeNode(1);
		
		n5.left = n3; n3.left = n2; n3.right = n4;
		n5.right = n6; n6.right = n1;
		
		LargestBSTSubtree ls = new LargestBSTSubtree();
		int res = ls.largestBSTSubtree(n5);
		System.out.println(res);
	}
}

class Data{
	boolean isBST = false;
	//the minimum for right sub tree or the maximum for right sub tree
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	//if the tree is BST, size is the size of the tree; otherwise zero
	int size;
}
