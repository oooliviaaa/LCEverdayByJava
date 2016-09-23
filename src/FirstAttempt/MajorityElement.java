package FirstAttempt;

public class MajorityElement {

	// http://www.programcreek.com/2014/02/leetcode-majority-element-java/
	
	// Java Solution 3 - Linear Time Majority Vote Algorithm
	public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (count == 0) {   /////////////// res 变换的时刻！！！！！
        		res = nums[i];
        		count = 1;
        	} else if (res == nums[i]) {
        		count++;
        	} else {
        		count--;
        	}
        }
        return res;
    }
}
