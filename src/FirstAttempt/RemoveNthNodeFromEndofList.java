package FirstAttempt;

public class RemoveNthNodeFromEndofList {

	// two pointers
	// http://www.jiuzhang.com/solutions/remove-nth-node-from-end-of-list/
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
		for(int i = 0; i < n; i++) {
			if(head == null) return null;
			head= head.next;
		}
		
		while(head != null) {
			head = head.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		
		return dummy.next;
    }
}
