package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormTriangle {

	public List<int[]> solution(int[] input) {
		List<int[]> res = new ArrayList<int[]>();
		Arrays.sort(input);
		for (int i = 2; i < input.length; i++) {
			int a = input[i-2];
			int b = input[i-1];
			int c = input[i];
			if (isValidTriangle(a, b, c)) {
				res.add(new int[]{a,b,c});
			}
		}
		return res;
	}
	
	private boolean isValidTriangle(int a, int b, int c) {
		return a + b > c;
	}
}
