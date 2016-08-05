package FirstAttempt;

public class SpiralMatrixII {

	// http://www.cnblogs.com/springfor/p/3887890.html
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        
        int num = 1;
        
        while (left < right && top < bottom) {
        	
        	for (int i = left; i < right; i++) {
        		res[top][i] = num++;
        	}
        	
        	for (int j = top; j < bottom; j++) {
        		res[j][bottom] = num++;
        	}
        	
        	for (int i = right; i > left; i--) {
        		res[bottom][i] = num++;
        	}
        	
        	for (int j = bottom; j > top; j++) {
        		res[j][top] = num++;
        	}
        	
        	top++;
        	bottom--;
        	left++;
        	right--;
        }
        
        if (n % 2 == 1) {
        	res[n/2][n/2] = num;
        }
        return res;
    }
}
