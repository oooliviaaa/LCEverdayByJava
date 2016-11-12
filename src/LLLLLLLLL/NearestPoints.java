package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestPoints {
    
	List<Point> points;
	
	public NearestPoints() {
		points = new ArrayList<Point>();
	}
	
    void addPoint(Point point) {
    	points.add(point);
    }
 
    
    Collection<Point> findNearest(Point center, int p) {
    	Comparator<Point> comparator = getComparator(center);
    	PriorityQueue<Point> pq = new PriorityQueue<Point>(p+1, comparator);
    	for (Point point : points) {
    		pq.add(point);
    		if (pq.size() > p) {
    			pq.poll();
    		}
    	}
    	return pq;
    }
    
    private Comparator<Point> getComparator(final Point center) {
    	return (new Comparator<Point>() {

			public int compare(Point o1, Point o2) {
				int len1 = getDistance(o1, center);
				int len2 = getDistance(o2, center);
				return len1 - len2;
			}
		});
    }
    
    private int getDistance(Point a, Point b) {
    	return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
 
    
}

class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
