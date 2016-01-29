package FirstAttempt;

public class ContainerWithMostWater {

	// http://blog.csdn.net/wzy_1988/article/details/17248209
	// water can be stored within every height, 
	// even 2 heights near side by side
	public int maxArea(int[] height) {
		if(height.length <= 1) return 0;
		
		int maxVol = 0;
        int i = 0;
        int j = height.length - 1;        
        
        while(i < j) {
        	int hi = height[i];
        	int hj = height[j];
        	int tmp = Math.min(hi, hj) * (j - i);
        	maxVol = Math.max(maxVol, tmp);
        	
        	if(hi < hj) {
        		while(i < j && hi >= height[i]) {
        			i++;
        		}
        	}
        	else {
        		while(i < j && hj >= height[j]) {
        			j--;
        		}
        	}
        }
        return maxVol;
    }
}
