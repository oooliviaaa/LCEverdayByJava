package FirstAttempt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {

	// https://segmentfault.com/a/1190000003797291
	/**
	 * 中序遍历法, 时间 O(N) 空间 Max(O(K),O(H))
	 * 
	 * 二叉搜索树的中序遍历就是顺序输出二叉搜索树，所以我们只要中序遍历二叉搜索树，同时维护一个大小为K的队列，
	 * 前K个数直接加入队列，
	 * 之后每来一个新的数（较大的数），如果该数和目标的差，相比于队头的数离目标的差来说，更小，则将队头拿出来，将新数加入队列。
	 * 如果该数的差更大，则直接退出并返回这个队列，因为后面的数更大，差值也只会更大。
	 * */
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        TreeNode cur = root;
        while (true) {
        	while (cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	
        	if (stack.isEmpty()) {
        		break;
        	}
        	
        	cur = stack.pop();
        	if (queue.size() < k) {
        		queue.offer(cur.val);
        	} else {
        		int first = queue.peek();
        		if (Math.abs(first - target) > Math.abs(cur.val - target)) {
        			queue.poll();
        			queue.offer(cur.val);
        		} else {
        			break;
        		}
        	}
        	
        	// 中序遍历的代码, 此处不check cur.right是不是null ！！！！！
        	cur = cur.right;
        	
        }
        return new ArrayList<Integer>(queue);
    }
	
	public static void main(String[] agrs) {
		ClosestBinarySearchTreeValueII cb = new ClosestBinarySearchTreeValueII();
		
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		
		List<Integer> res = cb.closestKValues(root, 2147483647.0, 1);
		for (int r : res) System.out.println(r);
	}
}
