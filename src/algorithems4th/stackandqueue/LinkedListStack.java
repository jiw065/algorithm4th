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
    private Node head = null;
    private int counter = 0;
	private class Node{
    	String item;
    	Node next;
    }
    
   
	void push(String item) {
		Node n = new Node();
		n.item = item;
		
		Node temp = this.head;
		this.head = n;
		n.next = temp;		
		counter++;
	}
	
	String pop() {
		Node n = this.head;
		this.head = n.next;
		counter--;
		return n.item;
	}
	
	boolean isEmpty() {
		return this.head == null;
	}
	
	int size() {
		return counter;		
	}

}
