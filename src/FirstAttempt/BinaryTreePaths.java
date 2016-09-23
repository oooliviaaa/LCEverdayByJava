package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	// https://discuss.leetcode.com/topic/21567/binary-tree-paths-dfs-java-solution
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		
		dfs(root, "", res);
		return res;
    }
	
	private void dfs(TreeNode node, String tmp, List<String> res) {
		if (node == null) return;
		
		tmp += node.val;
		if (node.left == null && node.right == null) {
			res.add(tmp);
			return;
		}
		
		tmp += "->";
		
		dfs(node.left, tmp, res);
		dfs(node.right, tmp, res);

	}
}
