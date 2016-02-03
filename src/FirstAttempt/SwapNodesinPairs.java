package FirstAttempt;

public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while(pre.next!= null && pre.next.next != null) {
        	ListNode n1 = pre.next;
        	ListNode n2 = pre.next.next;
        	
        	pre.next = n2;
        	n1.next = n2.next;
        	n2.next = n1;
        	
        	pre = n1;
        }
        
        return dummy.next;
    }
}
