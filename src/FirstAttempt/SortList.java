package FirstAttempt;

public class SortList {

	// http://www.cnblogs.com/springfor/p/3869372.html
	
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // 求出list长度
        ListNode p = head;
        int count = 0;
        while (p != null) {
        	count++;
        	p = p.next;
        }
        
        // 找middle
        p = head;
        for (int i = 1; i < count / 2; i++) {   ///// !!!!!
        	p = p.next;
        }
        ListNode secHead = p.next;
        p.next = null;  ///// 别忘解耦 !!!!!
        
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(secHead);
        
        return mergeSort(h1, h2);
        
    }
	
	private ListNode mergeSort(ListNode head1, ListNode head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		if (head1 == head2) return head1;
		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		while (head1 != null && head2 != null) {
			if (head1.val > head2.val) {
				p.next = head2;
				head2 = head2.next;
			} else {
				p.next = head1;
				head1 = head1.next;
			}
			p = p.next;
		}
		
		if (head1 != null) {
			p.next = head1;
		}
		
		if (head2 != null) {
			p.next = head2;
		}
		return dummy.next;
	}
}
