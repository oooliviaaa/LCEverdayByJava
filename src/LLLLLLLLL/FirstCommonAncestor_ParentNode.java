package LLLLLLLLL;

public class FirstCommonAncestor_ParentNode {

	public Node commonAncestor(Node a, Node b) {
        int depthA = depth(a);
        int depthB = depth(b);
        int delta = Math.abs(depthA - depthB);
 
        Node first = depthA > depthB ? a : b;
        Node second = depthA > depthB ? b : a;
 
        // first is deeper, so we moving it to the same level as second has
        for (int i = 0; i < delta; i++) {
            first = first.parent;
        }
 
        // now first and second are on the same level,
        // so moving up one level at a time will eventually result in a referencing the same node
        // (root node in a worst case)
        while (first != second) {
            first = first.parent;
            second = second.parent;
        }
 
        return second;
    }
 
    private static int depth(Node n) {
        int depth = 0;
        for (Node t = n; !t.isRoot(); t = t.parent) {
            depth++;
        }
        return depth;
    }
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
