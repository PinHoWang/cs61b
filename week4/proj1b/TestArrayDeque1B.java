
import static org.junit.Assert.*;

/* Give a JUnit test that StudentArrayDeque fails */
public class TestArrayDeque1B {

	public static void main(String[] args) {
		/* Create Testing AList result */
		StudentArrayDeque<Integer> result = new StudentArrayDeque<Integer>();
		/* ADD methods */
		for(int i = 0; i < 16; i++) result.addFirst(i);
		//for(int k = 0; k > -16; k--) result.addLast(k);


		/* Create Actually AList actual */
		ArrayDequeSolution<Integer> actual = new ArrayDequeSolution<Integer>();
		/* ADD methods */
		for(int j = 0; j < 16; j++) actual.addFirst(j);
		//for(int l = 0; l > -16; l--) actual.addLast(l);


		

		/* Testing */
		/* Test size */
		assertEquals(result.size(), actual.size());

		/* Test items position */
		for(int m = 0; m < actual.size(); m++) {
			assertEquals(result.get(m), actual.get(m));
		}


		/* Remove methods */
		for(int n = 0; n < 5; n++) result.removeFirst();
		for(int o = 0; o < 5; o++) actual.removeFirst();
		
		/* Testing */
		/* Test size */
		assertEquals(result.size(), actual.size());

		/* Test items position */
		for(int m = 0; m < actual.size(); m++) {
			assertEquals(result.get(m), actual.get(m));
		}



		
	}
}