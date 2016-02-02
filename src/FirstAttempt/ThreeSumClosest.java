package FirstAttempt;

import java.util.Arrays;

public class ThreeSumClosest {
	
	// http://www.jiuzhang.com/solutions/3sum-closest/
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MAX_VALUE;
        
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE / 2; // otherwise it will overflow for operation (closet-target) !!!
        for(int i = 0; i < nums.length - 2; i++) {
        	int bg = i+1;
        	int ed = nums.length-1;
        	while(bg < ed) {
        		int sum = nums[i] + nums[bg] + nums[ed];
        		if(sum == target) return sum;
        		else if(sum < target) bg++;
        		else ed--;
        		closest = Math.abs(sum - target) < Math.abs(closest - target)? sum : closest;
        	}
        }
        return closest;
    }
}
