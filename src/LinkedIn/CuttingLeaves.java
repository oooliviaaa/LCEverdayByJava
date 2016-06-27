package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CuttingLeaves {

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		
		n0.addChild(n5); n0.addChild(n8); n0.addChild(n11);
		n5.addChild(n1); n5.addChild(n2);
		n8.addChild(n7); n8.addChild(n9); n8.addChild(n10);
		n7.addChild(n6); n7.addChild(n4);
		n6.addChild(n3);
		
		CuttingLeaves cl = new CuttingLeaves();
		Map<Integer, List<TreeNode>> res = cl.solution(n0);
		for (int i : res.keySet()) {
			System.out.println("level " + i + " :");
			List<TreeNode> nodes = res.get(i);
			for (TreeNode n : nodes) System.out.println(n.val);
		}
	}
	
	public Map<Integer, List<TreeNode>> solution(TreeNode root) {
		if (root == null) return null;
		Map<Integer, List<TreeNode>> res = new HashMap<Integer, List<TreeNode>>();
		getHeight(root, res);
		return res;
	}
	
	private int getHeight(TreeNode root, Map<Integer, List<TreeNode>> res) {
		if (root == null) return 0;
		
		List<TreeNode> children = root.children;
		int h = 0;
		if (children != null && !children.isEmpty()) {
			for (TreeNode n : children) {
				int tmp = getHeight(n, res);
				h = tmp > h ? tmp : h;
			}
		}
		addIntoResult(h+1, root, res);
		return h+1;
	}
	
	private void addIntoResult(int height, TreeNode node, Map<Integer, List<TreeNode>> res) {
		List<TreeNode> nodes = res.get(height);
		if (nodes == null) {
			nodes = new ArrayList<TreeNode>();
		}
		nodes.add(node);
		res.put(height, nodes);
	}
}
