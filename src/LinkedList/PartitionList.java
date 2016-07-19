/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 *  greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the two partitions.

	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5. 
 */

package LinkedList;


public class PartitionList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


    public ListNode partition(ListNode head, int x) {
        	    if(head==null || head.next==null)
	        return head;
    
        ListNode firstHead=new ListNode(0);
        ListNode secondHead=new ListNode(0);
        
        firstHead.next=head;
        ListNode current=head;
        ListNode prev=firstHead,afterSecond=secondHead;
        
        while(current!=null)
        {
            if(current.val<x)
            {
                current = current.next;
                prev=prev.next;
            }
            else
            {
                afterSecond.next=current;
                afterSecond=afterSecond.next;
                
                //Previous  keeps track of tail of First List
                prev.next=current.next;
                current=prev.next;
            }            
        }
        
        prev.next=secondHead.next;
        afterSecond.next=null;
        
        return firstHead.next;
   
    }
}
