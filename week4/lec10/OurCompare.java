
/* OurCompare interface that allows the Maximizer.max method 
 * to do its job on ANY object implementing that interface. */

public interface OurCompare {
	/* Make compare between two Objects */
	public int compareTo(Object o);
}
