package FirstAttempt;

import java.util.Arrays;

public class RotateImage {

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
		
		int n = matrix.length - 1;   ///////////////////// !!!
		if (n < 1) return;
		
		for(int i = 0; i <= n / 2; i++) {  ///////////////////// !!!
			for(int j = i; j < n - i; j++) {  ///////////////////// !!!
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j][i];
				matrix[n - j][i] = matrix[n - i][n - j];
				matrix[n - i][n - j] = matrix[j][n - i];
				matrix[j][n - i] = tmp;
			}
		}
    }
	
	public static void main(String[] args) {
		int[][] m1 = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		int[][] m2 = new int[][]{
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		
		RotateImage ri = new RotateImage();
		printMatrix(m1);
		System.out.println("---------");
		ri.rotate(m1);
		printMatrix(m1);
		System.out.println("==========");
		
		printMatrix(m2);
		System.out.println("---------");
		ri.rotate(m2);
		printMatrix(m2);
	}

	private static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		
	}
}
