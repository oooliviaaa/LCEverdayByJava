package FirstAttempt;

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		ListNode p = head;
		int count = 0;
		while(p != null) {
			count++;
			p = p.next;
		}
		if (count == 0) return head;  ///// 防止length=0
		k = k % count;               ///// 防止k比length长，取余！
		if (k == 0) return head;
		
		ListNode left = head;
		ListNode right = head;
		
		int i = 0;
		while (right != null && i < k) {
        	right = right.next;
        	i++;
        }
		

		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		
		right.next = head;
		head = left.next;
		left.next = null;
		return head;
    }
}
