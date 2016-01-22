
public class AddTwoNumbers {
	
	// Add two numbers represented by a linked list, Numbers are Stored in FORWARD order
	// http://algorithms.tutorialhorizon.com/add-two-numbers-represented-by-a-linked-list-numbers-are-stored-in-forward-order/
	public int carry=0;
	public ListNode newHead = null;
	
	public ListNode add(ListNode h1, ListNode h2){
		//first we will make sure that both the Linked list has same no of nodes
		// to ensure that we will append 0 in front of shorter list
		int h1Len = getLength(h1);
		int h2Len = getLength(h2);
		if(h1Len > h2Len){
			return add(h2, h1);
		}
		else { 			
			int diff = h2Len - h1Len; 			
			while(diff > 0){
				ListNode n = new ListNode(0);
				n.next = h1;
				h1=n;
				diff--;
			}
		}
		
		return addBackRecursion(h1, h2);
	}
	
	public ListNode addBackRecursion(ListNode h1, ListNode h2){
		if(h1==null && h2==null){
			return null;
		}
		addBackRecursion(h1.next, h2.next);
		int a = h1.val + h2.val + carry;
		carry=0;
		//System.out.println(a);
		if(a>=10){
			carry =1;
			a = a%10;
		}
		ListNode n = new ListNode(a);
		if(newHead==null){
			newHead =n;
		}else{
			n.next = newHead;
			newHead = n;
		}
		//carry=0;
		return newHead;
	}
	
	public int getLength(ListNode head){
		int len=0;
		while(head!=null){
			len++;
			head = head.next;
		}
		return len;
	}
	
	public void display(ListNode head){
		ListNode currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.val);
			currNode=currNode.next;
		}		
	}
	
	public static void main(String args[]){
		AddTwoNumbers l = new AddTwoNumbers();
		ListNode h1 = new ListNode(1);
		h1.next= new ListNode(0);
		h1.next.next = new ListNode(0);
		h1.next.next.next = new ListNode(7);
		System.out.print("First Number : ");
		l.display(h1);
		ListNode h2 = new ListNode(9);
		h2.next= new ListNode(3);
		System.out.print("\n Second Number : ");
		l.display(h2);
		ListNode x = l.add(h1, h2);		
		System.out.print("\n Addition : ");
		l.display(x);
	}
	
	//////////////////
	//////////////////
	//////////////////
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        
        int carry = 0;
        while(l1 != null && l2 != null) {
        	int sum = l1.val + l2.val + carry;
        	carry = sum / 10;
        	ListNode nextNode = new ListNode(sum % 10);
        	point.next = nextNode;
        	
        	l1 = l1.next;
        	l2 = l2.next;
        	point = point.next;
        }
        
        while(l1 != null) {
        	int sum = l1.val + carry;
        	carry = sum / 10;
        	point.next = new ListNode(sum % 10);
        	
        	point = point.next;
        	l1 = l1.next;
        }
        
        while(l2 != null) {
        	int sum = l2.val + carry;
        	carry = sum / 10;
        	point.next = new ListNode(sum % 10);
        	
        	point = point.next;
        	l2 = l2.next;        	
        }
        
        if(carry != 0) {
        	point.next = new ListNode(carry);   /////// REMEMBER!!!
        }
        return dummy.next;
    }
	
	
	

}
