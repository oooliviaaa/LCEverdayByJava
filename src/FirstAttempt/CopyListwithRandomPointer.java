package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

	class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
	};
	
	// http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
	// solution 2
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<RandomListNode, RandomListNode> note = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        note.put(head, newHead);
        
        RandomListNode p = head;
        RandomListNode q = newHead;
        p = p.next;
        
        // 1st round: fill in all the nodes
        while (p != null) {
        	RandomListNode newP = new RandomListNode(p.label);
        	note.put(p, newP);
        	q.next = newP;
        	q = q.next;
        	p = p.next;
        }
        
        p = head;
        q = newHead;
        
        // 2nd round: fill in random pointers
        while (p != null) {
        	if (p.random != null) {
        		q.random = note.get(p.random); ///// !!!!!
        	}
     
    		p = p.next;
    		q = q.next;
        }
        return newHead;
    }
}
