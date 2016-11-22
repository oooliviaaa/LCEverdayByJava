package FirstAttempt;

public class SerializeAndDeserializeBST {

	// https://discuss.leetcode.com/topic/65847/java-easy-to-understand-o-n-2-solution/2
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) return sb.toString();
        preorder(root, sb);
        return sb.toString().substring(0, sb.length()-1);
    }
    
    private void preorder(TreeNode root, StringBuffer sb) {
    	if (root == null) return;
    	
    	sb.append(root.val);
    	sb.append("#");
    	preorder(root.left, sb);
    	preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null || data.length() == 0) return null;
        String[] array = data.split("#");
        return buildTree(array, 0, array.length-1);
    }
    
    private TreeNode buildTree(String[] array, int bg, int ed) {
    	if (bg > ed) return null;
    	TreeNode root = new TreeNode(Integer.parseInt(array[bg]));
    	int index = findIndex(array, Integer.parseInt(array[bg]), bg, ed);
    	root.left = buildTree(array, bg+1, index-1);   ///// bg+1
    	root.right = buildTree(array, index, ed);
    	return root;
    }
    
    private int findIndex(String[] array, int target, int left, int right) {
    	int i = left;
    	for (; i <= right; i++) {
    		if (target < Integer.parseInt(array[i])) break;
    	}
    	return i;
    }
}
