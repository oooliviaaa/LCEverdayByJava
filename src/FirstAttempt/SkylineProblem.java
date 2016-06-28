package FirstAttempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {

	/**
	 * 如果按照一个矩形一个矩形来处理将会非常麻烦，我们可以把这些矩形拆成两个点，一个左上顶点，一个右上顶点。
	 * 将所有顶点按照横坐标排序后，我们开始遍历这些点。
	 * 遍历时，通过一个堆来得知当前图形的最高位置。堆顶是所有顶点中最高的点，只要这个点没被移出堆，说明这个最高的矩形还没结束。
	 * 对于左顶点，我们将其加入堆中。对于右顶点，我们找出堆中其相应的左顶点，然后移出这个左顶点，同时也意味这这个矩形的结束。
	 * 具体代码中，为了在排序后的顶点列表中区分左右顶点，左顶点的y值是正数，而右顶点y值则存的是负数。
	 * */
	
	// https://segmentfault.com/a/1190000003786782
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
        	return res;
        }
        
        List<int[]> points = new ArrayList<int[]>();
        for (int[] b : buildings) {
        	points.add(new int[]{b[0], -b[2]});
        	points.add(new int[]{b[1], b[2]});
        }
        
        // sort the list primarily according to x, secondary according to y
        Collections.sort(points, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
        });
        
        // Max heap. collect all the heights so far, get the highest one
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;                   /////// max heap !!!!!
			}
        });
        
        pq.offer(0);                   /////// add in the base !!!!!
        int prePeek = 0;
        for (int[] p : points) {
        	int curX = p[0];
        	int curY = p[1];
        	if (curY < 0) {  // left point
        		pq.offer(-curY);
        	} else {        // right point
        		pq.remove(curY);
        	}
        	int peek = pq.peek();  // get the current highest height, without move it out
        	if (peek != prePeek) {   // new peek shows up means the previous peek got moved out
        		res.add(new int[]{curX, peek});
        		prePeek = peek;
        	}
        }
        return res;
    }


}
