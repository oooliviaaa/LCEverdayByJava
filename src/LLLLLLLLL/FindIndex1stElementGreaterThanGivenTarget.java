package LLLLLLLLL;

public class FindIndex1stElementGreaterThanGivenTarget {

	// sorted array
	public int solution(int[] input, int target) {
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (input[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		if (right == input.length - 1 && input[right] <= target) {
			return 0;
		}
		return input[right];
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,5};
		FindIndex1stElementGreaterThanGivenTarget fi = new FindIndex1stElementGreaterThanGivenTarget();
		int res = fi.solution(input, 9);
		System.out.println(res);
	}
}
