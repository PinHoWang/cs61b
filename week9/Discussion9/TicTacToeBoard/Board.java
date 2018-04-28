
public class Board {
	public static final int SIZE = 3; // Tic Tac Toe Boards are always 3x3

	private Piece[][] pieces;
	private boolean isXTurn; // ???

	public Board() {
		pieces = new Piece[SIZE][SIZE];
	}


	public boolean equals(Object o) {
		Piece[][] otherBoard = (Piece[][]) o;
		return Arrays.equals(this.pieces, o.pieces);
	}

	public int hashCode() {
		// Using binary value to represent the 3x3 (9 pieces) hashcode
		int code = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(pieces[i][j] == "X") code += 2^((3*i)+j);
			}
		}
		return code;
	}
}