package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

	// http://www.cnblogs.com/yrbbest/p/5065457.html
	
	
	class TreeColNode {           //////////  create a new private class !!!!!
		TreeNode node;
		int col;
		TreeColNode(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}
	
	public List<ArrayList<Integer>> verticalOrder(TreeNode root) {
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		Queue<TreeColNode> queue = new LinkedList<TreeColNode>();
		queue.offer(new TreeColNode(root, 0));
		
		Map<Integer, ArrayList<Integer>> levelCollect = new HashMap<Integer, ArrayList<Integer>>();  ////// list of integers!!!!! only store val
		
		int curLevelNum = 1;   /////////// !!!!!
		int nextLevelNum = 0;
		int maxCol = 0;       /////////// !!!!!
		int minCol = 0;
		while (!queue.isEmpty()) {
			
			// process this level
			TreeColNode cur = queue.poll();
			curLevelNum--;
			ArrayList<Integer> list = levelCollect.get(cur.col);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(cur.node.val);
			levelCollect.put(cur.col, list);
			
			// process next level
			if (cur.node.left != null) {
				nextLevelNum++;
				queue.offer(new TreeColNode(cur.node.left, cur.col-1));
				minCol = Math.min(minCol, cur.col-1);                     /////////// !!!!!
			}
			
			if (cur.node.right != null) {
				nextLevelNum++;
				queue.offer(new TreeColNode(cur.node.right, cur.col+1));
				maxCol = Math.max(maxCol, cur.col+1);
			}
			
			if (curLevelNum == 0) {
				curLevelNum = nextLevelNum;
				nextLevelNum = 0;
			}
		}
		
		for (int i = minCol; i <= maxCol; i++) {
			ArrayList<Integer> nodes = levelCollect.get(i);
			res.add(nodes);
		}
		
		return res;
    }
}
