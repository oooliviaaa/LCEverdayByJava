package FirstAttempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {

	// http://www.programcreek.com/2012/12/leetcode-merge-intervals/
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty())
			return res;
		
		Collections.sort(intervals, new Comparator<Interval>(){  //////////// !!!!!
			public int compare(Interval o1, Interval o2) {
				if (o1.start != o2.start) {
					return o1.start - o2.start;
				} else {
					return o1.end - o2.end;
				}
			}
		});
		
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (pre.end < cur.start) {
				res.add(pre);
				pre = cur;
			} else {
				Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merged;
			}
		}
		res.add(pre);        ////////////         !!!!!
		return res;
    }
}
