package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {
	
	// https://discuss.leetcode.com/topic/30626/java-and-python-solutions-with-and-without-tables
	// Java solution with only one table for B (~150ms):
	public int[][] multiply(int[][] A, int[][] B) {
		if (A == null || A[0] == null || B == null || B[0] == null) return null;
		int rowA = A.length;
        int colA = A[0].length;
        
        int rowB = B.length;
        int colB = B[0].length;
        
        if (colA != rowB) return null;
        
        int[][] C = new int[rowA][colB];
        
        // pre-process table B
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<Integer, HashMap<Integer, Integer>>();
        for (int i = 0; i < rowB; i++) {
        	tableB.put(i, new HashMap<Integer, Integer>());
        	for (int j = 0; j < colB; j++) {
        		if (B[i][j] != 0) {  // 非零的才存入map
        			tableB.get(i).put(j, B[i][j]);
        		}
        	}
        }
        
        // go through table A
        // table A 第i列的数都要与table B第i行的数相乘，放入table C的第k行第j列上
        for (int k = 0; k < rowA; k++) {
        	for (int i = 0; i < colA; i++) {
        		if (A[k][i] != 0) {
        			for (int j : tableB.get(i).keySet()) {
            			C[k][j] += A[k][i] * B[i][j];	
        			}
        		}
        	}
        }
        return C;
    }
}
