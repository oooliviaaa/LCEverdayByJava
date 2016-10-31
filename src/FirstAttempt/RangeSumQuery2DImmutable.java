package FirstAttempt;

public class RangeSumQuery2DImmutable {

	// http://buttercola.blogspot.com/2015/12/leetcode-range-sum-query-2d-immutable.html
	// dp
	/**
	 * Construct a 2D array sums[row+1][col+1]
	 * (notice: we add additional blank row sums[0][col+1]={0}
	 * and blank column sums[row+1][0]={0} to remove the edge case checking),
	 * so, we can have the following definition:
	 * sums[i+1][j+1] represents the sum of area from matrix[0][0] to matrix[i][j]
	 * */
	int[][] matrix;
	int[][] sum;
	public RangeSumQuery2DImmutable(int[][] matrix) {
        this.matrix = matrix;
        
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row+1][col+1];  ///// !!!!!i,j表示前i行前j列所有数的和
        for (int i = 1; i <= row; i++) {
        	for (int j = 1; j <= col; j++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);