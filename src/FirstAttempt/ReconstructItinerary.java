package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	// http://www.jiuzhang.com/solutions/reconstruct-itinerary/
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<String>();
        
        Map<String, PriorityQueue<String>> hm = new HashMap<String, PriorityQueue<String>>();
        
        for (String[] pair : tickets) {
            if (!hm.containsKey(pair[0])) {
                PriorityQueue<String> pq = new PriorityQueue<String>();
                hm.put(pair[0], pq);
            }
            hm.get(pair[0]).offer(pair[1]);
        }
        
        dfs("JFK", hm, res);
        return res;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> hm, List<String> res) {
        PriorityQueue<String> pq = hm.get(airport);
        
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), hm, res);
        }
        
        res.add(0, airport);
    }
}
