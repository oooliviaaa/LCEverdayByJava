package LLLLLLLLL;

import java.util.Collection;


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	Collection<TreeNode> children;
	TreeNode parent;

	TreeNode(int x) {
		val = x;
	}
	
	Collection<TreeNode> getChildren() {
		return children;
	}
	 
	  // Get the parent of a node
	  TreeNode parent() {
		  return parent;
	  }
}
