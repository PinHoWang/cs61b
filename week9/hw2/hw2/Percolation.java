package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	/* Grids */
	private class Grids {

		public boolean o;	// Record whether block is open.
		public boolean f;	// Record whether block is full.

		public Grids() {
			o = false;
			f = false;
		}

	}

	private Grids[][] grid;
	private int number;

	// create N-by-N grid, with all sites initially blocked
	public Percolation(int N) {
		grid = new Grids[N][N];
		number = N;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = new Grids();
			}
		}
	}         

	// open the site (row, col) if it is not open already
	public void open(int row, int col) {
		grid[row][col].o = true;
		if(row == 0 && col < number) {
			grid[row][col].f = true;
		}
	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		return grid[row][col].o;
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
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
