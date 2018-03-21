
import static org.junit.Assert.*;

/* Give a JUnit test that StudentLinkedListDeque fails */
public class TestLinkedListDeque1B {

	public static void main(String[] args) {
		/* Create Testing AList result */
		StudentLinkedListDeque<Integer> result = new StudentLinkedListDeque<Integer>();
		/* Add methods */
		for(int i = 0; i < 5; i++) result.addFirst(i);
		for(int k = 0; k > -5; k--) result.addLast(k);


		/* Create Actually AList actual */
		LinkedListDequeSolution<Integer> actual = new LinkedListDequeSolution<Integer>();
		for(int j = 0; j < 5; j++) actual.addFirst(j);
		for(int m = 0; m > -5; m--) actual.addLast(m);

		/* Testing */
		/* Test size */
		assertEquals(result.size(), actual.size());
		/* Test isEmpty() */
		assertEquals(result.isEmpty(), actual.isEmpty());

		/* Test items position */
		for(int m = 0; m < actual.size(); m++) {
			assertEquals(result.get(m), actual.get(m));
		}


		/* Remove methods */
		for(int n = 0; n < 5; n++) result.removeLast();
		for(int o = 0; o < 5; o++) actual.removeLast();

		/* Testing */
		/* Test size */
		assertEquals(result.size(), actual.size());

		/* Test items position */
		for(int p = 0; p < actual.size(); p++) {
			assertEquals(actual.get(p), result.get(p));
			System.out.println(p);
		}
	}
}