package LLLLLLLLL;

import java.util.ArrayList;
import java.util.List;

public class IntervalConverage {
	 
    List<Pair> pairs;
    
    public IntervalConverage() {
    	pairs = new ArrayList<Pair>();
    }
	
    void addInterval(int from, int to) {
    	if (to < from) return;
    	
		pairs.add(new Pair(from, to));    	
    	
    	Pair pre = pairs.get(0);
    	for (int i = 1; i < pairs.size(); i++) {
    		Pair cur = pairs.get(i);
    		if (pre.to < cur.from) {
    			pre = cur;
    		} else {
    			
    		}
    	}
    }
 
    int getTotalCoveredLength() {
    	
    }
 
}

class Pair {
	int from;
	int to;
	
	public Pair(int from, int to) {
		this.from = from;
		this.to = to;
	}
}