package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	// http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
	// BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || numCourses == 0) return true;
                
        // counter for number of prerequisites for each course
        int preCount[] = new int[numCourses];
        for (int[] pair : prerequisites) {
        	preCount[pair[0]] += 1;
        }
        
        // store courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < preCount.length; i++) {
        	if (preCount[i] == 0) {
        		queue.add(i);
        	}
        }
        
        int noPreCourseNum = queue.size();
        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	for (int[] pair : prerequisites) {
        		if (pair[1] == cur) {
        			preCount[pair[0]] -= 1;
        			if (preCount[pair[0]] == 0) {
        				queue.add(pair[0]);
        				noPreCourseNum++;
        			}
        		}
        	}
        }
        return noPreCourseNum == numCourses;
    }
}
