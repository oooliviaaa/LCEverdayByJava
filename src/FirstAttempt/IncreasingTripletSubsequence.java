package FirstAttempt;

public class IncreasingTripletSubsequence {

	/**http://www.programcreek.com/2015/02/leetcode-increasing-triplet-subsequence-java/
	 * This problem can be converted to be finding if there is a sequence 
	 * such that the_smallest_so_far < the_second_smallest_so_far < current. 
	 * We use x, y and z to denote the 3 number respectively.
	 * */
	public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
        	int cur = nums[i];
        	
        	if (cur <= small) {
        		small = cur;
        	} else if (cur <= middle) {   // 一定是else if!!!!! 因为如果数组是递减的话，一定只有small1被更新，只要small2被更新，就说明出现了长度为2的上升
        		middle = cur;
        	} else {
        		return true;
        	}
        }
        return false;
    }
}
