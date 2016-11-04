package FirstAttempt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {

	/**http://www.programcreek.com/2014/08/leetcode-line-reflection-java/
	 * we first find the smallest and largest x-value for all points and get the line's x-axis is (minX + maxX) / 2, 
	 * then for each point, check if each point has a reflection points in the set.
	 * */
	public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2) return true;
		
		int smallestX = Integer.MAX_VALUE;
        int largestX = Integer.MIN_VALUE;
        
        Map<Integer, Set<Integer>> hm = new HashMap<Integer, Set<Integer>>();  // key = 横坐标，val = 有相同横坐标的点的纵坐标
        for (int[] point : points) {
        	int x = point[0]; int y = point[1];
        	smallestX = Math.min(smallestX, x);
        	largestX = Math.max(largestX, x);
        	
        	Set<Integer> hs = hm.get(x);
        	if (hs == null) {
        		hs = new HashSet<Integer>();
        		hm.put(x, hs);
        	}
        	hs.add(y);
        }
        
        int sum = smallestX + largestX;
        for (int[] point : points) {
        	int x = point[0]; int y = point[1];
        	int oppo = sum - x;
        	if (!hm.containsKey(oppo) || !hm.get(oppo).contains(y)) {
        		return false;
        	}
        }
        return true;
    }
}
