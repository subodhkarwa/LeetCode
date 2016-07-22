/*
 *  Design and implement a data structure for Least Recently Used (LRU) cache.
 *   It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 */

package Misc;

import java.util.Hashtable;

public class LRUCache {

    class DLLNode
    {
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
    }
    
    private Hashtable<Integer,DLLNode> cache= new Hashtable<Integer,DLLNode>();
    int count=0,capacity=0;
    DLLNode head,tail;

	public LRUCache(int capacity) {
	    this.capacity=capacity;
	    this.count=0;
	    
	    head=new DLLNode();
	    head.prev=null;
	    
	    tail=new DLLNode();
	    tail.next=null;
	    
	    head.next=tail;
	    tail.prev=head;
	}

	public int get(int key) {
	    DLLNode node= this.cache.get(key);
	    
	    if(node==null)
	        return -1;
	   
	    bringtoFront(node);
	    return node.value;
	}


	public void set(int key, int value) {
	    DLLNode node= this.cache.get(key);
	    
	    if(node==null)
	    {
	        DLLNode newN=new DLLNode();
	        newN.key=key;
	        newN.value=value;
	        
	        this.cache.put(key,newN);
	        this.add(newN);
	        ++count;
	        
	        if(count>capacity)
	        {
	            DLLNode tailNode=removeTail();
	            this.cache.remove(tailNode.key);
	            --count;
	        }
	    }
	    else
	    {
	        node.value=value;
	        bringtoFront(node);
	    }
	}
	
	public DLLNode removeTail()
	{
	    DLLNode temp=tail.prev;
	    remove(temp);
	    return temp;
	}
	
	public void bringtoFront(DLLNode node)
	{
	    this.remove(node);
	    this.add(node);
	}
	
	public void add(DLLNode node)
	{
	    node.prev=head;
	    node.next=head.next;
	    
	    head.next.prev=node;
	    head.next=node;
	}
	
	public void remove(DLLNode node)
	{
	    DLLNode nextNode=node.next;
	    
	    node.prev.next=node.next;
	    node.next.prev=node.prev;
	}
}