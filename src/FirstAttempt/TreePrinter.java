package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {

	public static void printBinaryTree(TreeNode root) {
		List<TreeNode> l1 = new ArrayList<TreeNode>();
		l1.add(root);
		List<TreeNode> l2 = new ArrayList<TreeNode>();
		
		while (!isAllStar(l1)) {
			for (TreeNode n : l1) {
				if (n.val == -100) print('*');
				else print(n.val);
				if (n.left == null) l2.add(new TreeNode(-100));
				else l2.add(n.left);
				if (n.right == null) l2.add(new TreeNode(-100));
				else l2.add(n.right);
			}
			print("\n");
			l1 = new ArrayList<TreeNode>(l2);
			l2.clear();
		}
	}
	
	private static <T extends Object> void print(T c) {
		System.out.print(c.toString() + " ");
	}
	
	private static boolean isAllStar(List<TreeNode> l) {
		for (TreeNode n : l) {
			if (n.val != -100) return false;
		}
		return true;
	}
	
}
