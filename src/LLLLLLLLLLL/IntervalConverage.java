package LLLLLLLLLLL;

import java.util.ArrayList;
import java.util.List;

public class IntervalConverage {

	List<Pair> list;
	public IntervalConverage() {
		list = new ArrayList<Pair>();
	}
	
	
	void addInterval(int from, int to) {
		list.add(new Pair(from, true));
		list.add(new Pair(to, false));
	}
	
	int getTotalCoveredLength() {
		int count = 0;
		int len = 0;
		int start = 0;
		
		for (int i = 0; i < list.size(); i++) {
			Pair cur = list.get(i);
			if (cur.isStart) {
				count++;
			} else {
				count--;
			}
			
			if (cur.isStart && count == 1) {
				start = i;
			}
			if (!cur.isStart && count == 0) {
				len += (i - start);
			}
		}
		return len;
	}
	
}

class Pair {
	public int pos;
	public boolean isStart;
	
	public Pair(int pos, boolean isStart) {
		this.pos = pos;
		this.isStart = isStart;
	}
}