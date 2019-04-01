package algorithems4th.stackandqueue;

/**
 * Array implmention for stack(LIFO)
 * @author Amber
 * void push(String item)
 * String pop()
 * boolean isEmpty()
 * int size()
 */
public class ArrayStack {
	private String[] list;
	private int counter;
	public ArrayStack(int capacity) {
		list = new String[capacity];
		counter = 0;
	}
	void push(String item) {
		list[counter] = item;
		counter++;
	}
	String pop() {
		counter--;
		String s = list[counter];		
		list[counter] = null;		
		return s;
	}
	 boolean isEmpty() {
		return list[0] == null;
	}
	
	int size() {
		return counter;
	}

}
