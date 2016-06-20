package FirstAttempt.MaxPointsOnLine;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

	public  int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			Point p = points[i];  
			int px = p.x;
			int py = p.y;
			// Map<gradient, how many nodes>
			Map<Double, Integer> hm = new HashMap<Double, Integer>();
			hm.put((double)Integer.MAX_VALUE, 1);
			int dup = 0; // how many exactly same node
			
			for (int j = i+1; j < points.length; j++) {
				Point q = points[j];
				int qx = q.x;
				int qy = q.y;
				if (qx == px && qy == py) {
					dup++;
				} else if (qx == px) {
					hm.put((double)Integer.MAX_VALUE, hm.get(Integer.MAX_VALUE)+1);
				} else {
					double key = (double)(qy - py) / (double)(qx - px);
					if (hm.containsKey(key)) {
						hm.put(key, hm.get(key)+1); // add point q
					} else {
						hm.put(key, 2);  // add point p and q
					}
				}
				
			}
			for (int val : hm.values()) {
				if (val + dup > max) {
					max = val + dup;
				}
			}
			
		}
		return max;
	}
}
