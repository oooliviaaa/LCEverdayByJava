package LLLLLLLLL;

public class InfluencerFinder {

	// https://leetcode.com/problems/find-the-celebrity/
	public int getInfluencer(boolean[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
		
		int left = 0;
		int right = matrix.length-1;
		while (left < right) {
			if (matrix[left][right]) {
				left++;
			} else {
				right--;
			}
		}
		
		int candidate = left;
		for (int i = 0; i < matrix.length; i++) {
			if (candidate != i && (!matrix[i][candidate] || matrix[candidate][i])) {
				return -1;
			}
		}
		return candidate;
	}
}
