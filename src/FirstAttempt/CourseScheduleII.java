package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

	// http://www.programcreek.com/2014/06/leetcode-course-schedule-ii-java/
	// BFS
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        
        //if there is no prerequisites, return a sequence of courses
        if (prerequisites == null || prerequisites.length == 0) {
        	int[] res = new int[numCourses];
            for(int m = 0; m < numCourses; m++){
                res[m] = m;
            }
            return res;
        }
        
        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] preCount = new int[numCourses];
        for (int[] pairs : prerequisites) {
        	preCount[pairs[0]] += 1;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < preCount.length; i++) {
        	if (preCount[i] == 0) {
        		queue.offer(i);
        	}
        }
        
        int nonPreCount = queue.size();
        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	res[i] = cur;    /////////////  add into result !!!!!
        	i++;
        	
        	for (int[] pair : prerequisites) {
        		if (cur == pair[1]) {
        			preCount[pair[0]] -= 1;
        			if (preCount[pair[0]] == 0) {
        				queue.add(pair[0]);
        				nonPreCount++;
        			}
        		}
        	}
        }
        
        if (nonPreCount == numCourses) return res;
        else return new int[0];
        
    }
}
