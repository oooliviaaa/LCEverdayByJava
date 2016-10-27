package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

	// http://www.cnblogs.com/yrbbest/p/5065457.html
	class ColTreeNode {
        TreeNode node;
        int col;
        
        public ColTreeNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        Queue<ColTreeNode> queue = new LinkedList<ColTreeNode>();
        queue.offer(new ColTreeNode(root, 0));
        
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        
        int maxLevel = 0;
        int minLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                ColTreeNode cur = queue.poll();
                int level = cur.col;
                TreeNode node = cur.node;
                List<Integer> list = hm.get(level);
                if (list == null) {
                    list = new ArrayList<Integer>();
                }
                list.add(node.val);
                hm.put(level, list);
                
                minLevel = Math.min(minLevel, level);
                maxLevel = Math.max(maxLevel, level);
                if (node.left != null) {
                    queue.offer(new ColTreeNode(node.left, level-1));
                }
                if (node.right != null) {
                    queue.offer(new ColTreeNode(node.right, level+1));
                }
            }
        }
        
        for (int i = minLevel; i <= maxLevel; i++) {
            res.add(hm.get(i));
            
        }
        return res;
    }
}
