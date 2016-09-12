package FirstAttempt;

public class MoveZeroes {

	// http://www.programcreek.com/2014/05/leetcode-move-zeroes-java/
	// need to maintain the relative order of the non-zero elements.
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        int left = 0;
        int right = 0;
        
        while (right < nums.length) {
        	if (nums[right] == 0) {  // right用来寻找下一个非0的数字
        		right++;
        	} else {
        		nums[left] = nums[right];
        		left++;
        		right++;
        	}
        }
        
        while (left < nums.length) {  ///// 别忘了!!!!!
        	nums[left] = 0;
        	left++;
        }
    }
}
