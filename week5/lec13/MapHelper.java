import static org.junit.Assert.*;
import java.util.List;
import java.lang.Comparable;

public class MapHelper {


	/* Add a method get, which returns an item if it exists
	 * and null otherwise. */
  public static <K, V> V get(ArrayMap<K, V> am, K key) {
      if(am.containsKey(key)) {
        return am.get(key);
      }
      return null;
  }
	/* Add a method maxKey, which returns the maximum key. */
  public static <K extends Comparable<K>, V> K maxKey(ArrayMap<K, V> am) {
      List<K> keyList = am.keys();
      K max = keyList.get(0);
      for(int i = 1; i < keyList.size(); i++) {
        int cmp = (keyList.get(i)).compareTo(max);
        if(cmp < 0) max = keyList.get(i);
      }
      return max;
  }

	public static void main(String[] args) {
  		ArrayMap<Integer, String> am = new ArrayMap<Integer, String>();
  		am.put(5, "hello");
  		am.put(10, "ketchup");

  		assertEquals("hello", MapHelper.get(am, 5));
  		assertEquals(null, MapHelper.get(am, 99));


  		assertEquals((Integer) 5, MapHelper.maxKey(am));
	}
} 