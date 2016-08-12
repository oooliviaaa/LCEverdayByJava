package FirstAttempt;

public class ReorderList {

	// http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
	public void reorderList(ListNode head) {
        if (head == null) return;
        
        // get the mid point of the linkedlist
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        ListNode another = slow.next;     //////// !!!
        slow.next = null;           //////// !!!
        
        // reverse the 2nd list
        another = reverseLinkedList(another);
        
        // merge two lists
        ListNode p = head;
        ListNode q = another;
        while (q != null) {    ////////// !!! because 1st list goes first
        	ListNode pNext = p.next;
        	ListNode qNext = q.next;
        	
        	p.next = q;
        	q.next = pNext;
        	
        	p = pNext;
        	q = qNext;
        }
    }
	
	private ListNode reverseLinkedList(ListNode head) {
		if (head == null) return head;
		
		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
}
