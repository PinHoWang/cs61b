
import static org.junit.Assert.*;

/* Give a JUnit test that StudentLinkedListDeque fails */
public class TestLinkedListDeque1B {

	private static StudentArrayDeque<Integer> result = new StudentArrayDeque<Integer>();
	private static ArrayDequeSolution<Integer> actual = new ArrayDequeSolution<Integer>();

	public static void TestAll() {
		/* Testing size */
		assertEquals("\nError: The actual Deque size is " + actual.size()
			+ "\nBut the result size is "
			+ result.size() + "\n", actual.size(), result.size());
		/* Testing items */
		for(int j = 0; j < actual.size(); j++) {
			assertEquals("\nError: The actual add items is " + actual.get(j)
				+ "\nBut the result item is " 
				+ result.get(j) + "\n", actual.get(j), result.get(j));
		}
	}

	public static void TestAddFirst() {
		for(int i = 0; i < 10; i++) {
			result.addFirst(i);
			actual.addFirst(i);
			System.out.println("addFirst(" + i + ")");
			TestAll();
		}
	}

	public static void TestAddLast() {
		for(int i = 0; i < 10; i++) {
			result.addFirst(i);
			actual.addFirst(i);
			System.out.println("addLast(" + i + ")");
			TestAll();
		}
	}

	public static void TestremoveFirst() {
		for(int i = 0; i < 10; i++) {
			result.removeFirst();
			actual.removeFirst();
			System.out.println("removeFirst()");
			TestAll();
		}
	}

	public static void TestremoveLast() {
		for(int i = 0; i < 20; i++) {
			result.removeLast();
			actual.removeLast();
			System.out.println("removeLast()");
			TestAll();
		}
	}

	public static void main(String[] args) {
		/* Testing addFirst */
		TestAddFirst();
		/* Testing addLast */
		TestAddLast();
		/* Testing removeFirst */
		TestremoveFirst();
		/* Testing removeLast */
		TestremoveLast();

	}
		
}