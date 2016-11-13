package LLLLLLLLL; 


public class TwoLinkedListMerged {

	// 每个list都找到最后一个node，如果是一样的就是merged的
	public boolean solution(Node head1, Node head2) {
		if (head1 == null || head2 == null) return false;
		
		while (head1.next != null) {
			head1 = head1.next;
		}
		while (head2.next != null) {
			head2 = head2.next;
		}
		
		return head1 == head2;
	}
	
}


