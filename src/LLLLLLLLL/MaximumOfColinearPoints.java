package LLLLLLLLL;

import java.util.HashMap;
import java.util.Map;

public class MaximumOfColinearPoints {

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
        		
        		Double slope = 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
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
}
