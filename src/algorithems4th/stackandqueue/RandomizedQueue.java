package algorithems4th.stackandqueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * public RandomizedQueue() // construct an empty randomized queue public
 * boolean isEmpty() // is the randomized queue empty? public int size() //
 * return the number of items on the randomized queue public void enqueue(Item
 * item) // add the item public Item dequeue() // remove and return a random
 * item public Item sample() // return a random item (but do not remove it)
 * public Iterator<Item> iterator() // return an independent iterator over items
 * in random order public static void main(String[] args) // unit testing
 * (optional)
 * 
 * @author Amber
 *
 * @param <Item>
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] rqList = (Item[]) new Object[8];
	private int N = 0;

	private class RQIterator<Item> implements Iterator<Item> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			int index = --i;
			if (index < 0 || index > N)
				throw new NoSuchElementException("invalid item");
			return (Item) rqList[index];
		}

		public void remove() {
			throw new UnsupportedOperationException("remove method is not under support");
		}

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Cannot add empty value");
		}
		;
		if (N == rqList.length) {
			resize(2 * rqList.length);
		}
		rqList[N++] = item;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("cannot remove an item from empty list");
		}
		int index = StdRandom.uniform(N);
		Item item = rqList[index];
		N--;
//		for (int i = index; i < N; i++) {
//			rqList[i] = rqList[i + 1];
//		}
		rqList[index] = rqList[N];
		rqList[N] = null;
		if (N > 0 && N == rqList.length / 4) {
			resize(rqList.length / 2);
		}
		return item;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("cannot sample an item from empty list");
		}
		int index = StdRandom.uniform(N);
		return rqList[index];
	}

	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = rqList[i];
		}
		rqList = copy;

	}

	public Iterator<Item> iterator() {
		return new RQIterator();
	}

//	public void printQueue() {
//		for(Object i:rqList){
//			System.out.print(i+" ");
//		}
//		System.out.println();
//	}
	// unit testing
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {

			String s = StdIn.readString();

			if (s.equals("-"))
				StdOut.println(rq.dequeue());
			else
				rq.enqueue(s);
			// rq.printQueue();
			System.out.println("array test " + rq.size() + " left");
		}

	}

}
