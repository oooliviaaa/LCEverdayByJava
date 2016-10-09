package FirstAttempt;

import java.util.Stack;

public class InorderSuccessorInBST {

	// https://segmentfault.com/a/1190000003792039
	/**
	 * 路径入栈法, 时间 O(N) 空间 O(N)
	 * 
	 * 因为是BST，所以inorder就是从小到大的node的排列，找next也就是寻找比目标node大一点的那个node
	 * 
	 * 题目给定根节点和目标节点。目标节点如果有右节点的情况比较好处理，我们只要返回它的右节点的最左边的节点就行了（右节点自己没有左节点时则是右节点本身）。
	 * 如果目标节点没有右节点，说明比目标节点稍大的节点应该在上面，因为我们知道目标节点的左节点肯定是比目标节点要小的。
	 * 那怎么知道目标节点的上面是什么呢？这时就需要从根节点搜索到目标节点了。
	 * 这里要注意的是，目标节点的父亲不一定比目标节点大，因为有可能目标节点的是其父亲的右孩子。
	 * 所以我们要找的上面，实际上是从目标节点向根节点回溯时，第一个比目标节点大的节点。最
	 * 差的情况下，如果回溯到根节点还是比目标节点要小的话，说明目标节点就是整个数最大的数了，这时候返回空。
	 * 那怎么实现目标节点向根节点回溯，这里用一个栈就行了，在我们寻找目标节点时，把路径上的节点都压入栈中。
	 * */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (node != p) {
        	st.push(node);
        	if (p.val < node.val) {
        		node = node.left;
        	} else {
        		node = node.right;
        	}
        }
        
        if (node.right != null) {
        	node = node.right;
        	while (node.left != null) {
        		node = node.left;
        	}
        	return node;
        } else {
        	while (!st.isEmpty() && st.peek().val < p.val) {
        		st.pop();
        	}
        	return st.isEmpty() ? null : st.pop();
        }
    }
}
