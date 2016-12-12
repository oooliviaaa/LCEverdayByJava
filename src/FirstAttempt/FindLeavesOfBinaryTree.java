package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

	// https://discuss.leetcode.com/topic/49194/10-lines-simple-java-solution-using-recursion-with-explanation
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        getHeight(root, res);
        return res;
    }
    
    private int getHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return -1;
        }
        
        int height = Math.max(getHeight(node.left, res), getHeight(node.right, res)) + 1;
        if (height >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(node.val);
        return height;
    }
}
