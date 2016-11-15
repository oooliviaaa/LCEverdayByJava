package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FallingLeaves {
	
	/**
	 * level(leaf node) = 0
	 * level(any other node) = max(levels of child nodes + 1)
	 * */
	public List<Set<TreeNode>> fallingLeaves(TreeNode root) {
		List<Set<TreeNode>> res = new ArrayList<Set<TreeNode>>();
		Map<Integer, Set<TreeNode>> levelMap = new HashMap<Integer, Set<TreeNode>>();
		int levels = getHeight(root,  levelMap);
		for (int i = 0; i <= levels; i++) {
			if (levelMap.get(i) != null) {
				res.add(levelMap.get(i));
			}
		}
		return res;
	}
	
	private int getHeight(TreeNode node, Map<Integer, Set<TreeNode>> levelMap) {
		if (node == null) {
			return -1;
		}
		int level = 0;
		Collection<TreeNode> children = node.getChildren();
		if (children != null) {
			for (TreeNode child : node.getChildren()) {
				level = Math.max(level, getHeight(child, levelMap) + 1);
			}
		}
		
		if (!levelMap.containsKey(level)) {
			Set<TreeNode> list = new HashSet<TreeNode>();
			levelMap.put(level, list);
		}
		levelMap.get(level).add(node);
		return level;
	}
	
	
	public static void main(String[] args) {
		FallingLeaves fl = new FallingLeaves();
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		List<TreeNode> children1 = new ArrayList<TreeNode>();
		children1.add(node2); children1.add(node3);
		root.children = children1;
		
		List<TreeNode> children2 = new ArrayList<TreeNode>();
		children2.add(node4); children1.add(node5);
		node2.children = children2;
		
		List<TreeNode> children3 = new ArrayList<TreeNode>();
		children3.add(node6); children3.add(new TreeNode(7));
		node3.children = children3;
		
		List<TreeNode> children4 = new ArrayList<TreeNode>();
		children4.add(new TreeNode(8)); children1.add(new TreeNode(9));
		node4.children = children4;
		
		List<TreeNode> children6 = new ArrayList<TreeNode>();
		children6.add(new TreeNode(10)); 
		node6.children = children6;
		
		List<Set<TreeNode>> res = fl.fallingLeaves(root);
		for (Set<TreeNode> re : res) {
			for (TreeNode r : re) {
				System.out.print(r.val + " ");
			}
			System.out.println();
		}
	}
}


