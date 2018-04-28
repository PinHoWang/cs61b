

public class Piece {
	private String type; // Will be either "X" or "O"

	public boolean equals(Object o) {
		Piece otherPiece = (Piece) o;
		return this.type.equals(otherPiece.type); // Using the equals() method in String
	}

	public int hashCode() {
		if(this.type == "X") return 1;
		else if(this.type == "O") return 0;
		return -1; // For unknown type;
	}
}