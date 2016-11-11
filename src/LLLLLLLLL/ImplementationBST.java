package LLLLLLLLL;

public class ImplementationBST {

	BSTNode root;
	
	public void insert(int val) {
		insert(new BSTNode(val, null, null));
	}
	
	public void insert(BSTNode node) {
		BSTNode p = root;
		BSTNode pre = null;
		while (p != null) {
			pre = p;

			if (p.val > node.val) {
				p = p.getLeftChild();
			} else {
				p = p.getRightChild();
			}
		}
		
		if (pre == null) {
			root = node;
		} else if (pre.val > node.val){
			pre.setLeftChild(node);
		} else {
			pre.setRightChild(node);
		}
	}
}


class BSTNode {
	int val;
	BSTNode leftChild;
	BSTNode rightChild;
	
	public BSTNode(int val, BSTNode left, BSTNode right) {
		this.val = val;
		this.leftChild = left;
		this.rightChild = right;
	}
	
	public BSTNode getLeftChild() {
		return leftChild;
	}
	
	public BSTNode getRightChild() {
		return rightChild;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setLeftChild(BSTNode node) {
		this.leftChild = node;
	}
	
	public void setRightChild(BSTNode node) {
		this.rightChild = node;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
}