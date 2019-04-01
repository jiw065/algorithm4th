package algorithems4th.unionfind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private final int SIZE; // n*n site
	private int count; // count open sites
	private boolean[] flag; // is opened flag
	private WeightedQuickUnionUF tuf; // union-find from top
	private WeightedQuickUnionUF buf; // union-find from bottom
	int topNode;
	int bottomNode;
	boolean isPercolated;

	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Cannot create " + n + " * " + n + " site!");
		}
		SIZE = n;
		count = 0;
		flag = new boolean[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			flag[i] = false;
		}
		tuf = new WeightedQuickUnionUF(SIZE * SIZE + 1);
		buf = new WeightedQuickUnionUF(SIZE * SIZE + 1);
		topNode = SIZE * SIZE;
		bottomNode = SIZE * SIZE;
		isPercolated = false;
		// connect to virtual nodes
		for (int i = 1; i < SIZE + 1; i++) {
			tuf.union(xyTo1D(1, i), topNode);
			buf.union(xyTo1D(SIZE, i), bottomNode);
		}
	}

	private int xyTo1D(int row, int col) {
		if (row < 1 || row > SIZE) {
			throw new IllegalArgumentException("rows index out of bounds");
		} else if (col < 1 || col > SIZE) {
			throw new IllegalArgumentException("cols index out of bounds");
		}
		return (row - 1) * SIZE + (col - 1);
	}

	public void open(int row, int col) {
		if (!isOpen(row, col)) {
			int index = xyTo1D(row, col);
			flag[index] = true;
			// top
			if (row - 1 >= 1 && isOpen(row - 1, col)) {
				tuf.union(index, xyTo1D(row - 1, col));
				buf.union(index, xyTo1D(row - 1, col));
			}
			// bottom
			if (row + 1 <= SIZE && isOpen(row + 1, col)) {
				tuf.union(index, xyTo1D(row + 1, col));
				buf.union(index, xyTo1D(row + 1, col));
			}
			// left
			if (col - 1 >= 1 && isOpen(row, col - 1)) {
				tuf.union(index, xyTo1D(row, col - 1));
				buf.union(index, xyTo1D(row, col - 1));
			}
			// top
			if (col + 1 <= SIZE && isOpen(row, col + 1)) {
				tuf.union(index, xyTo1D(row, col + 1));
				buf.union(index, xyTo1D(row, col + 1));
			}
			count++;

			isPercolated = isPercolated || (tuf.connected(index, topNode) && buf.connected(index, bottomNode));
		}
	}

	public boolean isOpen(int row, int col) {
		return flag[xyTo1D(row, col)];
	}

	public boolean isFull(int row, int col) {
		return tuf.connected(xyTo1D(row, col), topNode) && isOpen(row, col);
	}

	public int numberOfOpenSites() {
		return count;
	}

	public boolean percolates() {
		return isPercolated;
	}

	public static void main(String[] args) {
		Percolation pr = new Percolation(3);
		pr.open(2, 2);
		pr.open(3, 2);
		pr.open(1, 2);
		System.out.println(pr.percolates());

	}
}