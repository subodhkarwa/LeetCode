/*
 *  Given a sorted linked list, delete all nodes that have duplicate numbers,
 *  leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
 */

package LinkedList;

public class RemoveDuplicatesfromSortedListII {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;

        ListNode prev=head,current=head.next,next=current;
        
        //Make the next of previous node null or it will point to the 'actual next'
        prev.next=null;

        boolean dup=false;
        
        while(current!=null)
        {
            dup=false;
            next=current.next;
            
            while(next!=null && current.val==next.val)
            {   
                dup=true;
                next=next.next;
            }
            
            if(dup==false)
            {
                prev.next=current;
                prev=prev.next;
                //Make the next of previous node null or it will point to the 'actual next'
                prev.next=null;  
            }           
            current=next;
        }        
        return dummy.next;
    }

}
