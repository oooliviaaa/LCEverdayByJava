package FirstAttempt;

public class Search2DMatrixII {

	// http://www.programcreek.com/2014/04/leetcode-search-a-2d-matrix-ii-java/
	// solution 2, O(m + n)	
		
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int i = matrix.length-1; ///// !!!!!
        int j = 0;
        
        while (i >= 0 && j < matrix[0].length) {
        	int cur = matrix[i][j];
        	if (target < cur) {
        		i--;
        	} else if (target > cur) {
        		j++;
        	} else {
        		return true;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{-5}};
		Search2DMatrixII sm = new Search2DMatrixII();
		boolean res = sm.searchMatrix(matrix, -10);
		System.out.println(res);
		
	}
}
