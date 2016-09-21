package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine {

	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	// http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
	public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;
        
        for (int i = 0; i < points.length; i++) {
        	int dup = 1;   // add itself !!!!!
        	int vert = 0;
        	Map<Double, Integer> hm = new HashMap<Double, Integer>();
        	
        	for (int j = i+1; j < points.length; j++) {
        		Point p1 = points[i];
        		Point p2 = points[j];
        		
        		if (p1.x == p2.x) {
        			if (p1.y == p2.y) {
        				dup++;
        			} else {
        				vert++;
        			}
        			continue;
        		}
        		
        		Double slope = p2.y == p1.y ? 0.0 : 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
        		if (hm.containsKey(slope)) {
        			hm.put(slope, hm.get(slope)+1);
        		} else {
        			hm.put(slope, 1);
        		}
        		
        	}
        	
        	for (int count : hm.values()) {
    			res = Math.max(res, count + dup);
    		}
        	
        	res = Math.max(res, dup + vert);
        }
        return res;
    }
	
	public static void main(String[] args) {
		Point p1 = new MaxPointOnLine().new Point(2,3);  // http://stackoverflow.com/questions/18690770/no-enclosing-instance-of-type-is-accessible
		Point p2 = new MaxPointOnLine().new Point(3,3);
		Point p3 = new MaxPointOnLine().new Point(-5,3);
		Point[] input = new Point[]{p1, p2, p3};
		
		int res = new MaxPointOnLine().maxPoints(input);
		System.out.println(res);
	}
}
