package FirstAttempt;

import java.util.Stack;

public class BinarySearchTreeIterator {

	// http://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
	Stack<TreeNode> stack;
	
	public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
        	stack.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {    // o(1) in average
    	TreeNode node = stack.pop();
    	int res = node.val;
    	
    	if (node.right != null) { ////// 为stack做准备
    		node = node.right;
    		while (node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    	}
    	return res; 
    }
}
