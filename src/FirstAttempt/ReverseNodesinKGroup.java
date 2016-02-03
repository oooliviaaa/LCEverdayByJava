package FirstAttempt;

public class ReverseNodesinKGroup {

	// http://www.jiuzhang.com/solutions/reverse-nodes-in-k-group/
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;   ///////////// every time you do reverse, pass in the previous one!!! start from dummy!!!
        while(pre.next != null) {
        	pre = reverseNextK(pre, k);
        }
        
        return dummy.next;
    }
	
	private ListNode reverseNextK(ListNode pre, int k) {
		// check if there is enough nodes to reverse
		ListNode p = pre;
		for(int i = 0; i < k; i++) {
			if(p.next == null) {  // check k times
				return p;
			}
			p = p.next;
		}
		
		// reverse
		ListNode cur = pre.next;
		p = pre;
		for(int i = 0; i < k; i++) { // do k times reverse
			ListNode next = cur.next;
			cur.next = p;
			p = cur;
			cur = next;
		}
		
		ListNode newP = pre.next;
		newP.next = cur;
		pre.next = p;
		return newP;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		ReverseNodesinKGroup rn = new ReverseNodesinKGroup();
		ListNode res = rn.reverseKGroup(n1, 2);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
