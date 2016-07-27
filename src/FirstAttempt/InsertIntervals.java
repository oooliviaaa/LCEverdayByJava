package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		
		for (Interval cur : intervals) {
			if (cur.end < newInterval.start) {
				res.add(cur);
			} else if (cur .start > newInterval.end) {
				res.add(newInterval);
				newInterval = cur;  ///// avoid adding multiple times !!!!!
			} else {  // has collision!
				int st = Math.min(cur.start, newInterval.start);
				int ed = Math.max(cur.end, newInterval.end);
				newInterval = new Interval(st, ed);   /////////// !!!!!
			}
		}
		res.add(newInterval);   ////////// remember to add !!!!!
		return res;
		
    }
	
	
	
	
	
	class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
