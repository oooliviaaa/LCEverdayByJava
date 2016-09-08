package FirstAttempt;

public class JumpGame {

	// http://www.programcreek.com/2014/03/leetcode-jump-game-java/
	public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	if (max <= i && nums[i] == 0) {
        		return false;
        	}
        	max = Math.max(max, nums[i]+i);
        	
        	if (max >= nums.length-1) {
        		return true;
        	}
        }
        return false;
    }
}
