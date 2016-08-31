package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeI_II {

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	// 此方法适用于both I and II ！！
	public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
        	int len = queue.size();
        	for (int i = 0; i < len; i++) {
        		TreeLinkNode node = queue.poll();
        		if (i == len-1) {
        			node.next = null;
        		} else {
        			node.next = queue.peek();
        		}
    			if (node.left != null) queue.add(node.left);
        		if (node.right != null) queue.add(node.right);
        	}
        }
    }
}
