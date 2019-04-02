package algorithems4th.stackandqueue;

import org.omg.CORBA.Current;

/**
 * Linked list implementation for stack(LIFO)
 * @author Amber
 * void push(String item)
 * String pop()
 * boolean isEmpty()
 * int size()
 */
public class LinkedListStack {
   
	private Node sentiniel = new Node("dummy",null);
  
    private int counter = 0;
	private class Node{
    	String item;
    	Node next;
    	public Node(String s,Node n) {
    		item = s;
    		next = n;
    	}
    	
    }
    
	
	
	void push(String item) {
		Node n = new Node(item,null);
		
		Node temp = this.sentiniel.next;
		this.sentiniel.next = n;
		n.next = temp;		
		counter++;
	}
	
	String pop() {
		Node n = this.sentiniel.next;
		this.sentiniel.next = n.next;
		counter--;
		return n.item;
	}
	
	boolean isEmpty() {
		return this.sentiniel.next == null;
	}
	
	int size() {
		return counter;		
	}

}
