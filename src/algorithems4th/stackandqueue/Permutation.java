package algorithems4th.stackandqueue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		int k = Integer.parseInt(args[0]);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item != null && item.length() > 0) {
				q.enqueue(item);
			}
		}

		while (k > 0) {
			StdOut.println(q.dequeue());
			k--;
		}
	}
}