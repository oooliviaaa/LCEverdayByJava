package FFFFFFFFF;

import java.util.Random;

public class RandomGeneratorAccordingToWeight {

	Random r = new Random();
	
	public int solution(int[] input) {
		int[] prefix = new int[input.length];
		prefix[0] = input[0];
		for (int i = 1; i < input.length; i++) {
			prefix[i] = prefix[i-1] + input[i];
		}
		
		int x = r.nextInt(18);
		System.out.println(x);
		int index = binarySearchClosest(prefix, x);
		return input[index];
	}
	
	private int binarySearchClosest(int[] input, int x) {
		int left = 0;
		int right = input.length-1;
		while (left < right) {
			int mid = (left + right) / 2;
			if ((mid == 0 || (mid > 0 && x >= input[mid-1])) && x < input[mid]) {
				return mid;
			} else if (x >= input[mid]) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return right;
	}
	
	
	public static void main(String[] args) {
		int[] input = {5,1,3,7,2};
		RandomGeneratorAccordingToWeight rg = new RandomGeneratorAccordingToWeight();
		int res = rg.solution(input);
		System.out.println(res);
	}
}
