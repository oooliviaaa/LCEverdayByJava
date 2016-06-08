package random;

public class MoveZeroOne {

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,0,1,0,1,1,0,0,0,1};
		MoveZeroOne m = new MoveZeroOne();
		m.solution(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	public void solution(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int i = -1;
		int j = 0;
		
		while (j < nums.length) {
			if(nums[j] == 0) {
				i++;
				swap(nums, i, j);
			} 
			j++;
		}
		System.out.println("i: "+i+", j: "+j);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
