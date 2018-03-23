
import java.lang.Math.*;

/* OffByN.java implement CharacterComparator interface */
public class OffByN implements CharacterComparator {

	private int distance;

	public OffByN(int N) {
		/* The maximum N in alpha is 26 a<->z
		 * So, in this case N <= 26.
		 * If it's not in this case, comment is part */
		if(N > 26) {
			System.out.println("Error (PalindromeFinder.java: Line 8): N should not larger than 26.");
			System.exit(-1);
		}
		distance = N;
	}

	/* Return true for letters that are different by N letter */
	@Override
	public boolean equalChars(char x, char y) {
		/* Convert to ASCII more or less than 1 with each other */
		return (Math.abs(x - y) <= distance);
	}
}