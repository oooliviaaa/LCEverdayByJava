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
	
	////////////////////////
	// find the merge point
	public boolean solution2(Node head1, Node head2) {
		if (head1 == null || head2 == null) return false;
		
		Node p = head1;
		int count1 = 0;
		while (p != null) {
			count1++;
			p = p.next;
		}
		
		Node q = head2;
		int count2 = 0;
		while (q != null) {
			count2++;
			q = q.next;
		}
		
		int diff = Math.abs(count2 - count1);
		Node h1 = count1 >= count2 ? head1 : head2;
		Node h2 = count1 < count2 ? head1 : head2;
		
		for (int i = 0; i < diff; i++) {
			h1 = h1.next;
		}
		
		while (h1 != null && h2 != null) {
			if (h1 == h2) return true;
			h1 = h1.next;
			h2 = h2.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.next = n2; n2.next = n3; n3.next = n6; n6.next = n7;
		n8.next = n4; n4.next = n5; //n5.next = n6; 
		
		TwoLinkedListMerged tl = new TwoLinkedListMerged();
		boolean res = tl.solution2(n1, n8);
		System.out.println(res);
	}
	
}


