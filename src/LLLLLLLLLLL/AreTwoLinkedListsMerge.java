package LLLLLLLLLLL;

public class AreTwoLinkedListsMerge {

	public boolean solution(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) return false;
		
		ListNode loop1 = findListLoop(head1);
		ListNode loop2 = findListLoop(head2);
		
		if (loop1 == null && loop2 == null) {
			return areNonCycleListsMerged(head1, head2);
		} else if (loop1 != null && loop2 != null) {
			return areCycleListsMerged(loop1, loop2);
		} else {
			return false;
		}
	}
	
	private boolean areNonCycleListsMerged(ListNode head1, ListNode head2) {
		while (head1 != null && head1.next != null) {
			head1 = head1.next;
		}
		while (head2 != null && head2.next != null) {
			head2 = head2.next;
		}
		return head1 == head2;
	}
	
	private boolean areCycleListsMerged(ListNode n1, ListNode n2) {
		if (n1 == n2) return true;
		ListNode p = n1;
		do {
			p = p.next;
			if (p == n2) return true;
		} while (p != n1);
		return false;
	}
	
	
	private ListNode findListLoop(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) break;
		}
		
		if (fast == null || fast.next == null) return null;
		return fast;
	}
}


class ListNode {
	public ListNode next;
	public int val;
	
	public ListNode(int val) {
		this.val = val;
	}
}