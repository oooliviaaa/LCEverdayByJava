package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	/** https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution/13
	 * 1. Pick out tallest group of people and sort them in a subarray (S). 
	 * 2. Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
	 * 
	 * For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
	 * 
	 * E.g.
	 * input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 * subarray after step 1: [[7,0], [7,1]]
	 * subarray after step 2: [[7,0], [6,1], [7,1]]
	 * 
	 * yaozk's answer
	 * */
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return people;
        
        // 相当于把people排序，people[0]大的排前面，people[0]相等的，people[1]小的排前面
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
			}
        });
        
        List<int[]> res = new ArrayList<int[]>();
        for (int[] p : people) {
			int height = p[0];
			int num = p[1];
        	if (num > res.size()) {
        		res.add(p);
        	} else {
        		res.add(num, p);
        	}
		}
        return res.toArray(new int[people.length][]);
    }
}
