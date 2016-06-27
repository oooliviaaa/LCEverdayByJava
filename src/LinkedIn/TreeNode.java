package LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	int val;
	List<TreeNode> children;
	
	public TreeNode(int val) {
		this.val = val;
		children = new ArrayList<TreeNode>();
	}
	
	public void addChild(TreeNode c) {
		this.children.add(c);
	}
}
