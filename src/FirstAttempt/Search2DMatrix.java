package FirstAttempt;

public class Search2DMatrix {

	// http://www.cnblogs.com/springfor/p/3857959.html
	// way 1: 2D --> 1D, 行数是position/columns，而列数是position%columns
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int row = matrix.length; 
		int col = matrix[0].length;
		
		int bg = 0;
		int ed = row * col - 1; 
		
		while (bg <= ed) {
			int mid = (bg + ed) / 2;
			int val = matrix[mid / col][mid % col];
			if (val == target) {
				return true;
			} else if (val < target) {
				bg = mid+1;
			} else {
				ed = mid-1;
			}
		}
		
		return false;
	}
	
	
	
	// way 2: 利用两次二分查找法。因为所给矩阵第一列也是升序排列的，所以可以先对第一列进行二分查找，锁定该元素所在行数，然后再对列进行二分查找.
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int rowLen = matrix.length; 
		int colLen = matrix[0].length;
		
		int bg = 0; int ed = rowLen;
		while (bg <= ed) {
			int mid = (bg + ed) / 2;
			int val = matrix[mid][0];
			
			if (val == target) {
				return true;
			} else if (val < target) {
				bg = mid+1;
			} else {
				ed = mid-1;
			}
		}
		
		int row = ed;  //当从while中跳出时，low指向的值肯定比target大，而high指向的值肯定比target小
		if (row < 0) return false;
		
		bg = 0; ed = colLen;
		while (bg <= ed) {
			int mid = (bg + ed) / 2;
			int val = matrix[row][mid];
			
			if (val == target) {
				return true;
			} else if (val < target) {
				bg = mid+1;
			} else {
				ed = mid-1;
			}
		}
		return false;
	}
	
}
