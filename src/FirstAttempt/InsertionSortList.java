package FirstAttempt;

public class InsertionSortList {

	// http://www.cnblogs.com/springfor/p/3862468.html
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			ListNode pre = dummy;
			while (pre.next != null && cur.val > pre.next.val) {
				pre = pre.next;
			}
			
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummy.next;
    }
}
