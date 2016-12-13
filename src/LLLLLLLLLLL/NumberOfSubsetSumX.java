package LLLLLLLLLLL;

public class NumberOfSubsetSumX {

	int numSubsets(int[] array, int target) {
		if (array == null || array.length == 0) return 0;
		return helper(array, target, 0);
	}
	
	private int helper(int[] array, int sum, int index) {
		int count = 0;
		if (index >= array.length) {
			return count;
		}
		
		for (int i = index; i < array.length; i++) {
			int cur = array[i];
			if (sum == cur) {
				count++;
			}
			count += helper(array, sum-cur, i+1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] array = {1,4,6,-1,-2,-4, 0};
		NumberOfSubsetSumX ns = new NumberOfSubsetSumX();
		int res = ns.numSubsets(array, 0);
		System.out.println(res);
	}
}
