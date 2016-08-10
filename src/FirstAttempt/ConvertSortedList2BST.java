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
}
