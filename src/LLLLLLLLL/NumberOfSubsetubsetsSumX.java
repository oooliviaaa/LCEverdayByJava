package LLLLLLLLL;

public class NumberOfSubsetubsetsSumX {

	int numSubsets(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		return helper(array, 0, 0, target);
	}
	
	private int helper(int[] array, int index, int sum, int target) {
		if (index >= array.length) {
			return 0;
		}
		
		int count = 0;
		for (int i = index; i < array.length; i++) {
			int cur = array[i];
			if (sum+cur == target) {
				count++;
			}
			count += helper(array, i+1, sum+cur, target);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] array = {1,4,6,-1,-2,-4};
		NumberOfSubsetubsetsSumX ns = new NumberOfSubsetubsetsSumX();
		int res = ns.numSubsets(array, 0);
		System.out.println(res);
	}
}
