package FirstAttempt;

public class RemoveDupfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode cur = head;
        while (cur != null) {
        	while (cur.next != null && cur.next.val == cur.val) { //////// while !!!!!
        		cur.next = cur.next.next;
        	}
        	cur = cur.next;
        }
        return head;
    }
}
