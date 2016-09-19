package FirstAttempt;

public class TwoSumII_InputArraySorted {

	// http://www.programcreek.com/2014/03/two-sum-ii-input-array-is-sorted-java/
	// use two points to scan the array from both sides
	public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
        	int sum = numbers[left] + numbers[right];
        	
        	if (sum < target) {
        		left++;
        	} else if (sum > target) {
        		right--;
        	} else {
        		return new int[]{left+1, right+1};  // 注意题目要求，返回的是第几个数
        	}
        }
        return null;
    }
}
