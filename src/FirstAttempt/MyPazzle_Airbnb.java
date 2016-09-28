package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class MyPazzle_Airbnb {  // question from Qi

	int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public void solution(int[][] input) {
		int spacex = 0;
		int spacey = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 0) {
					spacex = i;
					spacey= j;
					break;
				}
			}
		}
		
		Set<String> record = new HashSet<String>(); 
		String s = convertArrayToString(input);
		record.add(s);
		
		boolean res = dfs(input, record, spacex, spacey);
		System.out.println(res);
	}
	
	private boolean dfs(int[][] input, Set<String> record, int spacex, int spacey) {
		if (isCorrect(input)) {
			printMatrix(input);
			return true;
		}
		
		for (int[] dir : dirs) {
			int x = spacex + dir[0];
			int y = spacey + dir[1];
			
			if (x >= 0 && x < input.length && y >= 0 && y < input[0].length) {
				swap(input, spacex, spacey, x, y);
				String s = convertArrayToString(input);
				if (!record.contains(s)) {
					record.add(s);
					if (dfs(input, record, x, y)) {
						return true;
					} 
					record.remove(s);
				}				
				swap(input, spacex, spacey, x, y);
			}			
		}
		return false;
		
	}
	
	private String convertArrayToString(int[][] input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				sb.append(input[i][j]);
			}
		}
		return sb.toString();
	}
	
	private boolean isCorrect(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] != (int)(i * input.length + j + 1) && i != input.length-1 && j != input[0].length-1) {
					return false;
				}
			}
		}
		
		if (input[input.length-1][input[0].length-1] != 0) return false;
		return true;
	}
	
	private void swap(int[][] input, int i, int j, int x, int y) {
		int tmp = input[i][j];
		input[i][j] = input[x][y];
		input[x][y] = tmp;
	}
	
	private void printMatrix(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[][] input = {{4,0,6}, {7,1,5}, {8,3,2}};
		int[][] small = {{2,0},{1,3}};
		MyPazzle_Airbnb p = new MyPazzle_Airbnb();
		p.solution(input);
		p.printMatrix(input);
		
//		int[][] test = {{1,2},{0,3}};
//		boolean b = p.isCorrect(test);
//		System.out.println("test: " + b);
	}
}
