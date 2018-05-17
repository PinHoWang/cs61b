package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class Percolation {

	/* Grids */
	private class Grids {

		public boolean o;	// Record whether block is open.
		public boolean f;	// Record whether block is full.
		private int index;	// Global index using in disjoint set

		public Grids(int i) {
			o = false;
			f = false;
			index = i;
		}

	}

	private Grids[][] grid;
	// private Grids topSite = new Grids(-1);
	// private Grids bottumSite = new Grids(-2);
	private int number;
	private WeightedQuickUnionUF uf;

	// create N-by-N grid, with all sites initially blocked
	public Percolation(int N) {

		if(N <= 0) throw new IllegalArgumentException();

		grid = new Grids[N][N];
		number = N;
		uf = new WeightedQuickUnionUF(N*N);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// (i*N + j) as global index
				grid[i][j] = new Grids(globalIndex(i, j));
				if(j == 0) uf.union(globalIndex(i, j), -1);
				if(j == N - 1) uf.union(globalIndex(i, j), -2);
			}
		}
	}         

	// Calculate Global Index
	private int globalIndex(int r, int c) {
		return r*number + c;
	}

	// Check if connect with the top site
	private boolean isConnectTop(int r, int c) {
		return uf.connected(globalIndex(r, c), -1);
	}

	// Connect the opened neighborhood
	private void connectNeighbor(int r, int c) {
		// Top Grids
		if(c != 0) {
			if(isOpen(r, c-1))
				uf.union(globalIndex(r, c-1), globalIndex(r, c));
		}

		// Bottum Grids
		if(c != number) {
			if(isOpen(r, c+1))
				uf.union(globalIndex(r, c+1), globalIndex(r, c));
		}

		// Left Grids
		if(r != 0) {
			if(isOpen(r-1, c))
				uf.union(globalIndex(r-1, c), globalIndex(r, c));
		}

		// Right Grids
		if(r != number) {
			if(isOpen(r+1, c))
				uf.union(globalIndex(r+1, c), globalIndex(r, c));
		}
	}

	// open the site (row, col) if it is not open already
	public void open(int row, int col) {
		if(row > number || col > number) throw new IndexOutOfBoundsException();
		grid[row][col].o = true;
		connectNeighbor(row, col);
		if(isConnectTop(row, col)) grid[row][col].f = true;

	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if(row > number || col > number) throw new IndexOutOfBoundsException();
		return grid[row][col].o;
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		if(row > number || col > number) throw new IndexOutOfBoundsException();
		return grid[row][col].f;
	}

	// number of open sites
	public int numberOfOpenSites() {
		return 0;
	}

	// does the system percolate?
	public boolean percolates() {
		return false;
	}
	// public static void main(String[] args)   // unit testing (not required)
}                       
