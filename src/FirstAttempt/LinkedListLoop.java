package FirstAttempt;

public class LinkedListLoop {

	boolean hasLoop(ListNode first) {
		ListNode slow = first;
		ListNode fast = first;

	    while(fast != null && fast.next != null) {   ///////////// !!! check fast.next not null!!!
	        slow = slow.next;          // 1 hop
	        fast = fast.next.next;     // 2 hops 

	        if(slow == fast)  // fast caught up to slow, so there is a loop
	            return true;
	    }
	    return false;  // fast reached null, so the list terminates
	}
}
