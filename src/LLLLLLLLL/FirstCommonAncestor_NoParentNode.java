package LLLLLLLLL;

public class FirstCommonAncestor_NoParentNode {
	
	// 没有parent node
	public Node commonAncestor(Node root, Node a, Node b) {
		if (root == null || a == root || b == root) {
			return root;
		}
		
		Node left = commonAncestor(root.left, a, b);
		Node right = commonAncestor(root.right, a, b);
		if (left != null && right != null) {
			return root;
		} else {
			return left != null ? left : right;
		}
	}
	
	class Node {
	    final Node left;
	    final Node right;
	 
	 
	    public Node(Node left, Node right) {
	        this.left = left;
	        this.right = right;
	    }
	}
	
}


