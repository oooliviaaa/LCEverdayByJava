package InterestingQuestions;

public class PalindromLinkedlist {

	class ListNode {
		ListNode next;
		int val;
		ListNode(int val) {
			this.val = val;
		}
	}
	
	
	// http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
	// solution 3
	ListNode first;
	
	public boolean solution(ListNode head) {
		first = head;
		
		return myIsPalindrom(head);
	}
	
	boolean myIsPalindrom(ListNode last) {
		if (last == null) {
			return true;
		} 

		boolean pre = myIsPalindrom(last.next);
	 
		if(!pre) {
			return false;
		}
		
		if (first.val != last.val) return false;
		first = first.next;
		return true;
	}
	
	public static void main(String[] args) {
		PalindromLinkedlist pl = new PalindromLinkedlist();
		
		ListNode n1 = pl.new ListNode(1);
		ListNode n2 = pl.new ListNode(4);
		ListNode n3 = pl.new ListNode(3);
		ListNode n4 = pl.new ListNode(4);
		ListNode n5 = pl.new ListNode(1);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		
		boolean res = pl.solution(n1);
		System.out.print(res);
	}
}
