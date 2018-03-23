
import java.lang.Math.*;

/* OffByOne.java implement CharacterComparator interface */
public class OffByOne implements CharacterComparator {

	/* Return true for letters that are different by one letter */
	@Override
	public boolean equalChars(char x, char y) {
		/* Convert to ASCII more or less than 1 with each other */
		return (Math.abs(x - y) <= distance);
	}
}