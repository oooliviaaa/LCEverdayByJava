package InterestingQuestions;

import java.util.ArrayList;
import java.util.List;

// Amazon lab126 Qi onsite
public class MergeTwoBinarySearchTrees {

	public TreeNode solution(TreeNode root1, TreeNode root2) {
		if (root1 == null) return root2;
		if (root2 == null) return root1;
		
		List<TreeNode> merged = new ArrayList<TreeNode>();
		
		List<TreeNode> l1 = inorder(root1);
		List<TreeNode> l2 = inorder(root2);
		
		int i = 0; int j = 0;
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i).val < l2.get(j).val) {
				merged.add(l1.get(i));
				i++;
			} else {
				merged.add(l2.get(j));
				j++;
			}
		}
		
		while (i < l1.size()) {
			merged.add(l1.get(i));
			i++;
		}
		
		while (j < l2.size()) {
			merged.add(l2.get(j));
			j++;
		}
		
		return constructBST(merged);
	}
	
	private List<TreeNode> inorder(TreeNode node) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (node == null) {
			return res;
		}
		inorderHelper(node, res);
		return res;
	}
	
	private void inorderHelper(TreeNode node, List<TreeNode> res) {
		if (node == null) {
			return;
		}
		
		inorderHelper(node.left, res);
		res.add(node);
		inorderHelper(node.right, res);
	}
	
	private TreeNode constructBST(List<TreeNode> merged) {
		if (merged == null || merged.size() == 0) return null;
		return constructHelper(merged, 0, merged.size()-1);
	}
	
	private TreeNode constructHelper(List<TreeNode> merged, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;
		TreeNode node = merged.get(mid);
		node.left = constructHelper(merged, left, mid-1);
		node.right = constructHelper(merged, mid+1, right);
		return node;
	}
}


class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	
	TreeNode(int val) {
		this.val = val;
	}
}