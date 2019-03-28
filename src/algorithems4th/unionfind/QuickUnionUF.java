package algorithems4th.unionfind;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import edu.princeton.cs.algs4.Accumulator;

public class QuickUnionUF {
	private int[] id;
	private int[] sz;
	private int[] max;

	public void intializeUF(int n) {
		id = new int[n];
		sz = new int[n];
		max = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	/**
	 *    quick union 
	 *    
	 *    0 1 2 3 4 5 6 7 8 9 
	 *    1 1 1 8 3 0 5 1 8 8 
	 **/
//	public int root(int i) {
//		while(id[i] != i) {
//			i= id[i];
//		}		
//		return i;
//	}
	
//	public void Union(int p,int	q) {
//		int rootp = root(p);
//		int rootq = root(q);
//		id[rootp] = rootq;
//
//	}
	
/**
 * weighted quick union path compression 
 *  0 1 2 3 4 5 6 7 8 9 
 *  1 1 1 3 3 1 1 1 3 3 
 */
	public void Union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		if (sz[rootp] <= sz[rootq]) {
			id[rootp] = rootq;
			sz[rootq] += sz[rootp];
		} else {
			id[rootq] = rootp;
			sz[rootp] += sz[rootq];
		}
	}

	public int root(int i) {
		while (id[i] != i) {
		
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	
	public int find(int i) {
		int min = Integer.MIN_VALUE;
		while (id[i] != i) {
			if(i>min) {
				min = i;
			}
			
			i = id[i];
		}
		return min;
	}
	/**
	 * quick union path compression
	 * 
	 * 0 1 2 3 4 5 6 7 8 9 
	 * 1 1 1 8 8 0 1 1 8 8 
	 */
//	public int root(int i) {
//		while(id[i] != i) {
//			id[i] = id[id[i]]; 
//			i= id[i];
//		}		
//		return i;
//	}
	
//	public void Union(int p,int	q) {
//	int rootp = root(p);
//	int rootq = root(q);
//	id[rootp] = rootq;
//
//}
	
	/**
	 * quick union by height
	 * 0 1 2 3 4 5 6 7 8 9 
	 * 5 1 1 3 3 1 5 1 3 3 
	 * 
	 */
//	public int root(int i) {
//		while(id[i] != i) {			
//			i= id[i];
//		}		
//		return i;
//	}
//	
//	
//	
//	public void Union(int p,int	q) {
//		int rootp = root(p);
//		int rootq = root(q);
//		if(sz[rootp]<sz[rootq]) {
//		id[rootp] = rootq;
//		}else if(sz[rootp]>sz[rootq]) {
//			id[rootq] = rootp;
//		}else {
//			id[rootq] = rootp;
//			sz[rootq] ++;
//
//		}
//	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int count() {
		int count = 0;
		for (int i = 0; i < id.length - 1; i++) {
			if (id[i] == i) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		QuickUnionUF uf = new QuickUnionUF();
		Accumulator test = new Accumulator();
		uf.intializeUF(10);
		uf.Union(4, 3);
		uf.Union(3, 8);
		uf.Union(6, 5);
		uf.Union(9, 4);
		uf.Union(2, 1);
		uf.Union(5, 0);
		uf.Union(7, 2);
		uf.Union(6, 1);

		System.out.println(uf.connected(0, 6));
		System.out.println(uf.find(1));
		for (int i = 0; i < uf.id.length; i++) {

			System.out.print(i + " ");
		}

		System.out.println();
		for (int i = 0; i < uf.id.length; i++) {

			System.out.print(uf.id[i] + " ");

		}
	

	}

}
