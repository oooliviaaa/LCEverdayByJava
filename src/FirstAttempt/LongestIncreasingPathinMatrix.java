package FirstAttempt;

public class LongestIncreasingPathinMatrix {
	
	public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   /////////// !!!!

	public int longestIncreasingPath(int[][] matrix) {
        
		int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return max;
        
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		int len = getMaxLength(matrix, i, j, new int[matrix.length][matrix[0].length]);
        		max = Math.max(len, max);
        	}
        }
		return max;
		
		
    }
	
	private int getMaxLength(int[][] matrix, int i, int j, int[][] record) {
		if (record[i][j] != 0) return record[i][j];   /////////// record不是用来存储是否访问过，而是存储之前计算出的结果。可以直接利用其他dfs path得出的的结果!!!!
		int max = 1;
		
		for (int[] dir : directions) {
			int x = i + dir[0]; int y = j + dir[1];
			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length 
					|| matrix[x][y] <= matrix[i][j]) continue;               ///////////  !!! logic is here!!!
			int len = 1 + getMaxLength(matrix, x, y, record);
			max = Math.max(max, len);
			
		}
		record[i][j] = max;    /////////// fill in the record !!!!
		return max;     /////////// !!!!
	}
}
