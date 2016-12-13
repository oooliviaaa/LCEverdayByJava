package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

	class Point {

		int x;
		int y;
		
		Point() { x = 0; y = 0; }
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public  int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            int x = point.x;
            int y = point.y;
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int vert = 0;
            int dup = 1;   ///// 先算上i自己
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;  ///// !!!!!
                Point p = points[j];
                int px = p.x;
                int py = p.y;
                if (px == x && py == y) dup++;
                else if (px == x) {
                    vert++;
                } else {
                    double slope = (double)(y - py) / (double)(x - px);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope)+1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
            for (int val : map.values()) {
                res = Math.max(res, val+dup);
            }
            res = Math.max(res, vert+dup);
        }
        return res;
	}
}
