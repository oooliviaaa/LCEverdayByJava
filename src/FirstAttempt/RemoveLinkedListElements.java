package FirstAttempt;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
        	if (p.next.val == val) {
        		p.next = p.next.next;
        	}
        	else p = p.next;  //  这里必须加else！！！否则main里面的例子会fail
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		RemoveLinkedListElements re = new RemoveLinkedListElements();
		ListNode res = re.removeElements(n1, 1);
		System.out.println(res);
	}
}
