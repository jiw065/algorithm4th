
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

public class DequeArray<Item> {
	private Item[] dq;
	private int N = 0;
	private int first, last;

	public DequeArray(int capacity) {
		dq = (Item[]) new Object[capacity];

		last = 0;
		first = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void addFirst(Item item) {
		dq[first] = item;
		first = (dq.length - 1) - first;
		N++;
		if (first == last) {

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
