package LinkedList;

public class LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null)  
			return null;

		boolean isCycle=false;

		ListNode slow=head,fast=head;

		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;

			if(fast==slow)
			{
				isCycle=true;
				break;
			}
		}

		if(!isCycle)
			return null;

		fast=head;
		while(slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
	}
}
