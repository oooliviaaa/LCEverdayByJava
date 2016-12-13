package LLLLLLLLL;

public class SerializeDeserializeBST {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuffer res = new StringBuffer();
        preorder(root, res);
        return res.toString();
    }
    
    private void preorder(TreeNode root, StringBuffer res) {
        if (root == null) return;
        res.append(root.val + ",");
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().length() == 0) return null;
        String[] array = data.trim().split(",");
        
        return build(array, 0, array.length-1);
    }
    
    private TreeNode build(String[] array, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(Integer.parseInt(array[left]));
        int index = findIndex(array, Integer.parseInt(array[left]), left, right);
        root.left = build(array, left+1, index-1);
        root.right = build(array, index, right);
        return root;
    }
    
    private int findIndex(String[] array, int val, int left, int right) {
        int i = left;
        for (; i <= right; i++) {
            int cur = Integer.parseInt(array[i]);
            if (cur > val) break;
        }
        return i;
    }
}
