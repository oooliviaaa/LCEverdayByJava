package FirstAttempt;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	// https://segmentfault.com/a/1190000003894670
	public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        	
        });
        
        
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
        	Interval cur = intervals[i];
        	
        	if (cur.start < end) return false;
        	end = Math.max(end, cur.end);
        } 
        return true;
    }
}
