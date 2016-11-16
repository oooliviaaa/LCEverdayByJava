package LLLLLLLLL;

public class FirstCommonAncestor_ParentNode {

	public Node commonAncestor(Node a, Node b) {
        int depthA = depth(a);
        int depthB = depth(b);
        int delta = Math.abs(depthA - depthB);
 
        Node longer = depthA > depthB ? a : b;
        Node shorter = depthA > depthB ? b : a;
 
        // first is deeper, so we moving it to the same level as second has
        for (int i = 0; i < delta; i++) {
            longer = longer.parent;
        }
 
        // now first and second are on the same level,
        // so moving up one level at a time will eventually result in a referencing the same node
        // (root node in a worst case)
        while (longer != shorter) {
        	longer = longer.parent;
        	shorter = shorter.parent;
        }
 
        return longer;
    }
 
    private static int depth(Node node) {
        int depth = 0;
        Node p = node;
        while (!p.isRoot()) {
            depth++;
            p = p.parent;
        }
        return depth;
    }
    
    class Node {
   	 
        final Node parent;
        final Node left;
        final Node right;
     
     
        public Node(Node parent, Node left, Node right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
     
        boolean isRoot() {
            return parent == null;
        }
    }
}


