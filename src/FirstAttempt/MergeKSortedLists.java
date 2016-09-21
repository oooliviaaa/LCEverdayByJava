package FirstAttempt;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	
	
	// min-heap --> PriorityQueue
	public ListNode mergeKLists(ListNode[] lists) {
        int num = lists.length;
        if(num == 0) return null;
        if(num == 1) return lists[0];
        
        ////////////REMEBER!!! new PriorityQueue<Object>(size, comparator);
        // compare(l1, l2), l1 and l2 are what's inside the priority queue --> ListNode
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
																		public int compare(ListNode o1, ListNode o2) {
																			return o1.val - o2.val;
																		}
        															});
        
        for(ListNode list : lists) {
        	if(list != null) pq.add(list);
        }
        
        ListNode head = new ListNode(0);
        ListNode point = head;
        
        while(pq.size() > 0) {
        	ListNode tmp = pq.poll();
        	point.next = tmp;
        	
        	// keep adding next element of each list
        	if(tmp.next != null) pq.add(tmp.next);
        	
        	point = point.next;
        }
        
        return head.next;
        
    }
}
