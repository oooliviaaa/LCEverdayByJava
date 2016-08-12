package FirstAttempt;

public class ConvertSortedList2BST {

	// http://blog.csdn.net/worldwindjp/article/details/39722643
	// 自底向上
	
	ListNode currentHead = null;     ///////////////// !!!!!
	public TreeNode sortedListToBST(ListNode head) {
    
        if (head == null) return null;
        
        int len = 0;
        currentHead = head;
        while (head != null) {
        	len++;
        	head = head.next;
        }
        
        TreeNode tHead = helper(0, len-1);
        return tHead;
    }
	
	private TreeNode helper(int st, int ed) {
		
		if (st > ed) return null;
		int mid = (st + ed) / 2;
		
		TreeNode left = helper(st, mid-1);
		TreeNode cur = new TreeNode(currentHead.val);
		
		cur.left = left;
		currentHead = currentHead.next;     /////////// this listNode is used, move to the next one!!!!!
		
		TreeNode right = helper(mid+1, ed);
		cur.right = right;
		return cur;
		
	}
	
	public static void main(String[] args) {
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		l0.next = l1; l1.next = l2; l2.next = l3; l3.next = l4; 
		l4.next = l5; l5.next = l6; l6.next = l7; l7.next = l8; l8.next = l9; 
		
		ConvertSortedList2BST cs = new ConvertSortedList2BST();
		TreeNode head = cs.sortedListToBST(l0);
		TreePrinter.printBinaryTree(head);
	}
}
