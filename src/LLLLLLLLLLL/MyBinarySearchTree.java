package LLLLLLLLLLL;

public class MyBinarySearchTree {
	
	TreeNode root;
	
	public void insert(int val) {
		TreeNode p = root;
		TreeNode pre = null;
		
		while (p != null) {
			pre = p;
			if (p.val > val) {
				p = p.leftChild;
			} else {
				p = p.rightChild;
			}
		}
		
		TreeNode node = new TreeNode(val);
		if (pre == null) {
			root = node;
		} else if (pre.val < val) {
			pre.rightChild = node;
		} else {
			pre.leftChild = node;
		}
	}
	
	public boolean search(int val) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == val) {
				return true;
			} else if (p.val > val) {
				p = p.leftChild;
			} else {
				p = p.rightChild;
			}
		}
		return false;
	}
}


class TreeNode { 
    public int val;
    public TreeNode parent;
    public TreeNode leftChild;
    public TreeNode rightChild;
 
    public TreeNode(int key) {
        this.val = key;
    }
}