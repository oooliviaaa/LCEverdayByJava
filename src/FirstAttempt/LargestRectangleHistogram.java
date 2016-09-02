package FirstAttempt;

import java.util.Stack;

public class LargestRectangleHistogram {

	// The key to solve this problem is to maintain a stack to store bars' indexes. 
	// The stack only keeps the increasing bars.
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
    	int max = 0;
    	int i = 0;
    	
    	while (i < heights.length) {
    		int curHeight = heights[i];
    		
    		//push index to stack when the current height is larger than the previous one
    		if (stack.isEmpty() || curHeight >= heights[stack.peek()]) {  /// >= !!!!!
    			stack.push(i);  ///// storing the index !!! not the height !!!
    			i++;
    		} else {
    			int maxHeightIndex = stack.pop();
    			int maxHeight = heights[maxHeightIndex];
    			int width = stack.isEmpty() ? i : (i - stack.peek() - 1);   //如果只有一个长方形，其实宽度是算作0的 
    			max = Math.max(max, maxHeight * width);
    			// i stays the same and go to the next round !!!
    		}
    	}
    	
    	while (!stack.isEmpty()) {  ////////////  !!!!!
    		int maxHeightIndex = stack.pop();
			int maxHeight = heights[maxHeightIndex];
			int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
			max = Math.max(max, maxHeight * width);
    	}
    	
    	return max;
    }
}
