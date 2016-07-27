package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	// https://leetcode.com/submissions/detail/4355243/
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		int row = matrix.length;
		int col = matrix[0].length;
		
		int ro = row;
		int co = col;
		int offset = 0;
		
		while (ro > 0 && co > 0) {
			
			if (ro == 1 && co == 1) {
				res.add(matrix[ro][co]);
			} else if (ro == 1) {
				for (int a = offset; a < ro - offset; a++) {
					res.add(matrix[ro][a]);
				}
				break;
			} else if (co == 1) {
				for (int b = offset; b < co - offset; b++) {
					res.add(matrix[b][offset]);
				}
				break;
			} 
			
			for (int a = offset; a < col-offset-1; a++) {   // use col, not co !!!
				res.add(matrix[offset][a]);
			}
			for (int b = offset; b < row-offset-1; b++) {
				res.add(matrix[b][col-offset-1]);
			}
			for (int c = col-offset-1; c > offset; c--) {
				res.add(matrix[row-offset-1][c]);
			}
			for (int d = row-offset-1; d > offset; d--) {
				res.add(matrix[d][offset]);
			}
			
			offset++;
			co = col - 2 * offset;
			ro = row - 2 * offset;
			
		}
		return res;
    }
}
