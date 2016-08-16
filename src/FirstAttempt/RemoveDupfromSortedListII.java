package FirstAttempt;

public class RemoveDupfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode dummyHead = pre;
        ListNode cur = head;
        ListNode next = head.next;
        boolean dupFlag = false;
        
        while (next != null){
            if (cur.val == next.val) {
                dupFlag = true;
                next = next.next;
                
            } else { 
                if (dupFlag) {
                    pre.next = next;
                    cur = next;
                    next = next.next;
                    dupFlag = false;
                }
                else {
                    pre = cur;
                    cur = next;
                    next = next.next;                   
                }
                
            }
        }
        
        if (dupFlag) {  //the last element is in the duplicate list
            pre.next = next;
        }
        
        return dummyHead.next;
	}
	
	
	//////////////////////////////////////
	// my solution, 太繁了，不太好。
	public ListNode deleteDuplicates_mine(ListNode head) {
		if (head == null) return head;
		
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		ListNode next = head.next;
		
		while (next != null) {
			if (next.val == cur.val) {
				while (next != null && next.val == cur.val) {  // find the first not same, remember to add "next != null" !!!
					next = next.next;
				} 
				pre.next = next;   // dump all the nodes with dup val
				if (next == null) break;

			} else {
				pre = cur;
			}
			cur = next;
			next = next.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l0 = new ListNode(0); ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0); ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(2); ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(3); ListNode l7 = new ListNode(4);
		ListNode l8 = new ListNode(4); 
		l0.next = l1; l1.next = l2; l2.next = l3; l3.next = l4;
		l4.next = l5; l5.next = l6; l6.next = l7; l7.next = l8;
		
		RemoveDupfromSortedListII rd = new RemoveDupfromSortedListII();
		ListNode res = rd.deleteDuplicates(l0);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
	
}
