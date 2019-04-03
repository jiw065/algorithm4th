package algorithems4th.stackandqueue;


/**
 * Linked list implementation for stack(LIFO)
 * @author Amber
 * void push(String item)
 * String pop()
 * boolean isEmpty()
 * int size()
 */
public class LinkedListStack<Item> {
   
	private Node sentiniel;
	private int counter = 0;
	
	public LinkedListStack(Item a){
		sentiniel = new Node(a,null);
	}
	
  
    
	private class Node{
    	Item item;
    	Node next;
    	public Node(Item s,Node n) {
    		item = s;
    		next = n;
    	}
    	
    }
    
	
	
	void push(Item item) {
		Node n = new Node(item,null);
		
		Node temp = this.sentiniel.next;
		this.sentiniel.next = n;
		n.next = temp;		
		counter++;
	}
	
	Item pop() {
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
	
	void printStack() {
		Node current = sentiniel.next;
		for(int i = 0;i<size();i++) {
			System.out.print(current.item+" ");
			current = current.next;
		}
		System.out.println();
	}

}
