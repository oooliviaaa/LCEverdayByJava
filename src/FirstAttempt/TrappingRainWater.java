package FirstAttempt;

public class TrappingRainWater {

	// http://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
	public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        
        int res = 0;
        
        // Find the index of the max height
        int maxIndex = 0;
        for(int i = 1; i < height.length; i++) {
        	if(height[i] > height[maxIndex]) maxIndex = i;
        }
        
        int maxLeft = 0;
        for(int i = 1; i < maxIndex; i++) {   //////// just scan before maxIndex
        	if(height[i] < height[maxLeft]) {
        		res += height[maxLeft] - height[i];
        	} 
        	else {
        		maxLeft = i;
        	}
        }
        
        int maxRight = height.length-1;
        for(int i = height.length-2; i > maxIndex; i--) {    /////// just scan after maxIndex
        	if(height[i] < height[maxRight]) {
        		res += height[maxRight] - height[i];
        	}
        	else {
        		maxRight = i;
        	}
        }
        return res;
    }
}
