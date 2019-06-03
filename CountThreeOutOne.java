package javase;

import java.lang.reflect.Array;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

// TODO: Auto-generated Javadoc
/**
 * The Class CountThreeOutOne.
 */
public class CountThreeOutOne {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
//		int[] test = createList(13);
//		System.out.println(test.length);
//		int[] copy = new int[test.length];
//		printArray(test);
//		// printArray(moveLeft(test, 7));
//		System.arraycopy(test, 0, copy, 0, test.length);
//		printArray(copy);
//		 playGame(test);

		boolean[] test = createBooleanList(180);
		enhancedPlayGame(test);
		
		boolean[] test1 = createBooleanList(180);
		enhancedPlayGame2(test1);

	}

	/**
	 * Print sorted array.
	 *
	 * @param d the d
	 */
	public static void printArray(int[] d) {
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Creates the list.
	 *
	 * @param n the n
	 * @return the int[]
	 */
	public static int[] createList(int n) {
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		return a;
	}

	/**
	 * Creates the boolean list.
	 *
	 * @param n the n
	 * @return the boolean[]
	 */
	public static boolean[] createBooleanList(int n) {
		boolean[] a = new boolean[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = true;
		}
		return a;
	}

	/**
	 * Move left.
	 *
	 * @param b the b
	 * @param r the r
	 * @return the int[]
	 */
	public static int[] moveLeft(int[] b, int r) {
		int[] na = new int[b.length - 1];
		int preIndex = r;
		for (int i = r + 1; i < b.length; i++) {
			b[preIndex] = b[i];
			preIndex++;
		}

		// copy to new array
		for (int i = 0; i < na.length; i++) {
			na[i] = b[i];
		}
		return na;
	}

	/**
	 * Play game.
	 *
	 * @param a the a
	 */
	public static void playGame(int[] a) {
		int counter = a.length;
		int remove = 0;
		int start = 0;
		int[] aa = a;
		while (counter > 1) {
			remove = remove + 2;
			System.out.println("removeIndex " + remove + " counter: " + counter);

			if (remove > counter) {
				remove = remove % counter;
				start = remove;
			} else if ((counter - remove) == 1) {
				start = 0;
			} else if (counter == remove) {
				remove = 0;
				start = 1;
			} else {
				start = remove;
			}

			aa = moveLeft(aa, remove);
			// printArray(aa);

			counter--;
			if (aa.length == 1) {
				break;
			}
		}
		System.out.println("Last Person " + aa[0]);
	}

	/**
	 * Enhanced play game.
	 *
	 * @param a the a
	 */
	public static void enhancedPlayGame(boolean[] a) {
		int index = 0;
		int counter = a.length;
		int play = 0;

		while (counter > 1) {
			if (a[index] == true) {
				play++; // when a[index] still play the game increase play
			}
			if (play == 3) { // when count to 3 set a[index] quit the game replay the game to set play = 0.
								// the play person--
				a[index] = false;
				play = 0;
				counter--;
			}

			index++;
			if (index == a.length) { // when index = a.length start over the list
				index = 0;
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] == true) {
				System.out.println(i);
			}
		}

	}

	// rewrite for practice
	public static void enhancedPlayGame2(boolean[] a) {
		int counter = a.length;
		int index = 0;
		int play = 0;  
		while(counter > 1) {
			if(a[index]) {
				play++;
			}
			
			if(play == 3) {
				a[index] = false;
				play = 0;
				counter--;
			}
			
			index++;
			if(index > a.length -1) {
				index = 0; 
			}				
					
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == true) {
				System.out.println(i);
			}
		}
		
	}
}
