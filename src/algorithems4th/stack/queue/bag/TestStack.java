package algorithems4th.stack.queue.bag;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * The test client
 * @author Amber
 *
 */
public class TestStack {

	public static void main(String[] args)
	{
		ArrayStack astack = new ArrayStack(10);
		LinkedListStack lstack = new LinkedListStack();
		if((StdIn.readString()).equals("array")) {
			System.out.println("test array stack");
			while (!StdIn.isEmpty())
			{
				
				String s = StdIn.readString();

				if (s.equals("-")) StdOut.println(astack.pop());
				else astack.push(s);
				
				System.out.println("array test "+astack.size()+" left");
			}
			
			
		}else {
			System.out.println("test linkedlist stack");
			while  (!StdIn.isEmpty())
			{
				String s = StdIn.readString();

				if (s.equals("-")) StdOut.println(lstack.pop());
				else lstack.push(s);
				System.out.println("linked list test "+lstack.size()+" left");

			}
			
		}
	}

}
