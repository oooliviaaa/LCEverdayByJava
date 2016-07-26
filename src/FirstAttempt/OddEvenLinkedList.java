package FirstAttempt;

public class OddEvenLinkedList {

	// http://www.programcreek.com/2015/03/leetcode-odd-even-linked-list-java/
	public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode p = head;
        ListNode q = head.next;
        ListNode connectNode = head.next;
        
        while (p != null && q != null) {
        	if (q.next == null) {
        		break;    ///////////// 如果有偶数个，就要在p，q变成null之前跳出
        	}
        	
        	p.next = q.next;
        	p = p.next;
        	q.next = p.next;
        	q = q.next;
        	
        }
        p.next = connectNode;
        return head;
    }
}
