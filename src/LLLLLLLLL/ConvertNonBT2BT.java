package LLLLLLLLL;

// BinaryTreeRepresentation
public class ConvertNonBT2BT {
	
	public int[][] convert(int[][] originalTree) {
		int num = originalTree.length;
        int[][] bt = new int[num][];
 
        for(int i = 0; i < num; i++) {
            convertNode(i, originalTree, bt);
        }
 
        return bt;
	}
	
	private void convertNode(int n, int[][] tree, int[][] bt) {

	}
}
