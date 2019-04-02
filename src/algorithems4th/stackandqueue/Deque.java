package algorithems4th.stackandqueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Amber public Deque() // construct an empty deque public boolean
 *         isEmpty() // is the deque empty? public int size() // return the
 *         number of items on the deque public void addFirst(Item item) // add
 *         the item to the front public void addLast(Item item) // add the item
 *         to the end public Item removeFirst() // remove and return the item
 *         from the front public Item removeLast() // remove and return the item
 *         from the end public Iterator<Item> iterator() // return an iterator
 *         over items in order from front to end public static void
 *         main(String[] args) // unit testing (optional)
 * 
 */

public class Deque<Item> implements Iterable<Item> {

	private Node sNode, tail;
	private int count = 0;
	private class Node {
		Item item;
		Node next;

		private Node(Item i) {
			item = i;
			next = null;
		}
	}

	private class DQIterator implements Iterator<Item> {

		private Node current = sNode.next;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException("the iterator contains empty item");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove method is not under support");
		}

	}


	public Deque() {
		String a = "test";
		sNode = new Node((Item) a);
	}

	public boolean isEmpty() {
		return sNode.next == null;
	}

	public int size() {
		return count;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Cannot add empty value");
		}
		;
		Node n = new Node(item);
		Node temp = sNode.next;
		sNode.next = new Node(item);
		sNode.next.next = temp;
		if (isEmpty())
			tail = n;

		count++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Cannot add empty value");
		}
		;
		Node oldTail = tail;
		tail = new Node(item);

		if (isEmpty()) {
			sNode.next = tail;
		} else {
			oldTail.next = tail;
		}
		count++;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("cannot remove an item from empty list");
		}
		Item temp = sNode.next.item;
		sNode.next = sNode.next.next;
		if (isEmpty())
			tail = null;
		count--;
		return temp;
	}

	/**
	 * this is not constant worst case think about arraydeque later;
	 * null pointer exception error see grade description
	 */
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("cannot remove an item from empty list");
		}
		Item temp = tail.item;
		count--;
		if (sNode.next.next == null) {
			sNode.next = null;
			return temp;
		}
		Node current = sNode.next;
		Node prev = current;
		while (current.next != null) {
			prev = current;
			current = current.next;
		}
		tail = prev;
		tail.next = null;

		return temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DQIterator();
	}

//	public void printQueue() {
//		Iterator<Item> r = this.iterator();
//		while(r.hasNext()) {
//			System.out.print(r.next()+" ");
//		}
//		System.out.println();
//	}
	public static void main(String[] args) {
		Deque<String> q = new Deque<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();

			if (s.equals("-"))
				StdOut.println(q.removeFirst());
			else if (s.equals("+"))
				StdOut.println(q.removeLast());
			else if (s.contains("-") && !s.equals("-"))
				q.addFirst(s);
			else if (s.contains("+") && !s.equals("+"))
				q.addLast(s);
			System.out.println("dqueue test " + q.size() + " left");
			// q.printQueue();

		}

	}

}