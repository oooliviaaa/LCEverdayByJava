package LLLLLLLLL;

import java.util.LinkedList;
import java.util.Queue;

public class SerializationDeserializationBinaryTree {


	public String serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root == null) return sb.toString();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur != null) {
					sb.append(cur.val + ",");
					queue.offer(cur.left);
					queue.offer(cur.right);
				} else {
					sb.append("#,");
				}
			}
		}
		return sb.toString().substring(0, sb.length()-1);
	}	
	
	public TreeNode deserialize(String s) {
		if (s == null || s.trim().length() == 0) return null;
		String[] array = s.trim().split(",");
		TreeNode root = new TreeNode(Integer.parseInt(array[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				continue;
			}
			
			String leftVal = array[i];
			if (leftVal.equals("#")) {
				queue.offer(null);
				cur.left = null;
			} else {
				TreeNode left = new TreeNode(Integer.parseInt(leftVal));
				cur.left = left;
				queue.offer(left);
			}
			
			i++;
			String rightVal = array[i];
			if (rightVal.equals("#")) {
				queue.offer(null);
				cur.right = null;
			} else {
				TreeNode right = new TreeNode(Integer.parseInt(rightVal));
				cur.right = right;
				queue.offer(right);
			}
			i++;
		}
		return root;
	}
	
}
