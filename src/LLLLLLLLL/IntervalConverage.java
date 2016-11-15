package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalConverage {
	 
    List<Pair> pairs;
    int converage;
    
    public IntervalConverage() {
    	pairs = new ArrayList<Pair>();
    	converage = 0;
    }
	
    void addPair(int from, int to) {
    	if (to < from) return;
    	
    	Pair newPair = new Pair(from, to);

        List<Pair> tmp = new ArrayList<Pair>();
        int count = 0;
		
		for (Pair cur : pairs) {
			if (cur.to < newPair.from) {
				count += (cur.to - cur.from);
				tmp.add(cur);
			} else if (cur.from > newPair.to) {
				count += (newPair.to - newPair.from);
				tmp.add(newPair);
				newPair = cur;  ///// avoid adding multiple times !!!!!
			} else {  // has collision!
				int st = Math.min(cur.from, newPair.from);
				int ed = Math.max(cur.to, newPair.to);
				newPair = new Pair(st, ed);   /////////// !!!!!
			}
		}
		this.converage = count + newPair.to - newPair.from;
		tmp.add(newPair);
		pairs = tmp;
    }
    
 
    int getTotalCoveredLength() {
    	return converage;
    }
    
    
    
    public static void main(String[] args) {
    	IntervalConverage ic = new IntervalConverage();
    	ic.addPair(2, 5); ic.addPair(7, 9); ic.addPair(11, 12);
    	int res1 = ic.getTotalCoveredLength();
    	System.out.println(res1);
    	
    	ic.addPair(4, 8);
    	int res2 = ic.getTotalCoveredLength();
    	System.out.println(res2);
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