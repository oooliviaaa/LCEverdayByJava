package LLLLLLLLL;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(myMap.containsKey(nums[i])) {
        		int j = myMap.get(nums[i]);
        		if(i > j) {
        			res[0] = j+1;
        			res[1] = i+1;
        		}
        		
        	}
        	else {
        		myMap.put(target - nums[i], i);
        	}
        }
        return res;
    }
}
