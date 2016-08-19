package FirstAttempt;

public class PalindromeLinkedList {

	/* We can use a fast and slow pointer to get the center of the list, 
	 * then reverse the second list and compare two sublists. 
	 * The time is O(n) and space is O(1).
	*/
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {   //////// !!!!! 保证fast不跳出list
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;   //////// !!!!!
        second = reverseLinkedList(second);
        
        ListNode p = head;
        ListNode q = second;
        while (p != null && q != null) {
        	if (p.val != q.val) return false;
        	p = p.next;
        	q = q.next;
        }
        return true;
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
