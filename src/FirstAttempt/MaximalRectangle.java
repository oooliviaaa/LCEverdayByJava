package FirstAttempt;

import java.util.Stack;

public class MaximalRectangle {

	// http://www.cnblogs.com/springfor/p/3869492.html
	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int row = matrix.length;
        int col = matrix[0].length;
        
        int max = 0;
        
        int[] heights = new int[col];
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (matrix[i][j] == '0') {
        			heights[j] = 0;
        		} else {
        			heights[j] += 1;
        		}
        	}
        	max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }
	
	// same with largest rectangle histogram
	private int largestRectangleArea(int[] heights) {
		int len = heights.length;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int i = 0;
		
		while (i < len) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int heightIndex= stack.pop();
				int height = heights[heightIndex];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, height * width);
			}
		}
		
		while (!stack.isEmpty()) {
			int heightIndex= stack.pop();
			int height = heights[heightIndex];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, height * width);
		}
		
		return max;
	}
}
