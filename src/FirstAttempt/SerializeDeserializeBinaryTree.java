package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
	
	// http://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) {
            return "";
        }
    	
    	StringBuffer sb = new StringBuffer();
        if (root == null) return sb.toString();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	if (node == null) {
        		sb.append("#,");
        	} else {
        		sb.append(node.val+",");
        		queue.offer(node.left);
            	queue.offer(node.right);
        	}
        	
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() == 0) return null;
    	
    	String[] s = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int i = 1;    //////////// start from the 2nd one !!!!!
        while(!queue.isEmpty()) {
        	TreeNode cur = queue.poll();
        	if (cur == null) {
        		continue;
        	}
        	
        	if (!s[i].equals("#")) {
        		cur.left = new TreeNode(Integer.parseInt(s[i]));
        		queue.offer(cur.left);  ///////// !!!!!
        	} else {
        		cur.left = null;
        		queue.offer(null);      ///////// !!!!!
        	}
        	 
        	i++;    ///////// !!!!!
        	if (!s[i].equals("#")) {
        		cur.right = new TreeNode(Integer.parseInt(s[i]));
        		queue.offer(cur.right);  ///////// !!!!!
        	} else {
        		cur.right = null;
        		queue.offer(null);      ///////// !!!!!
        	}
        	i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));