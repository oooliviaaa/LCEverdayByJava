package SortingAlgorithms;

public class BubbleSort {

	
	public void solution(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - i; j++) {
				if (nums[j] < nums[j-1]) {
					swap(nums, j, j-1);
				}
			}
			
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] input = {4,2,6,1,3,7};
		BubbleSort bs = new BubbleSort();
		bs.solution(input);
		
		for (int i : input) {
			System.out.println(i);
		}
	}
}
