/*
 * You are given two linked lists representing two non-negative numbers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 */

package LinkedList;

public class AddTwoNumbers {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null && l2==null)
			return null;

		if(l1==null)
			return l2;
		if(l2==null)
			return l1;

		int sum=0,carry=0;
		ListNode newHead=new ListNode(0);
		ListNode current=newHead;

		while(l1!=null || l2!=null)
		{
			sum=carry + (l1!=null ? l1.val:0) + (l2!=null ? l2.val:0); 
			if(sum>9)
			{
				sum=sum%10;
				carry=1;
			}
			else
				carry=0;

			ListNode temp=new ListNode(sum);
			current.next=temp;
			current=current.next;

			if(l1!=null)    l1=l1.next;
			if(l2!=null)    l2=l2.next;
		}

		if(carry!=0)
		{
			ListNode temp=new ListNode(carry);
			current.next=temp;
			current=current.next;
		}

		current.next=null;        
		return newHead.next;
	}

}
