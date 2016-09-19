package FirstAttempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	// http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
	// Solution 1: HashMap and Heap
	public List<Integer> topKFrequent(int[] nums, int k) {
		//count the frequency for each element
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
 
        // create a min heap !!!!! 因为要移除最小的，保留k个最大的。
        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
        		new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {

			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
        	
        });
        
        //maintain a heap of size k. 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        
      //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().getKey());
        }
        //reverse the order !!!!!
        Collections.reverse(result);
 
        return result;
    }
}
