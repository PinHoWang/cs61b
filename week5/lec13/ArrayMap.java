/** Fill in the map implementation below. */
import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> {
	private K[] keys;
	private V[] values;
	private int size;

	public ArrayMap() {
		keys = (K[]) new Object[100];
		values = (V[]) new Object[100];
		size = 0;
	}

	private int findKey(K key) {
		for(int i = 0; i < size; i++) {
			if(keys[i] == key) return i;
		}
		/* return -1 if there is no key in K[] */
		return -1;
	}

	public void put(K key, V value) {
		if(this.containsKey(key)) values[findKey(key)] = value;
		else {
			keys[size] = key;
			values[size] = value;
			size++;
		}
	}

	public V get(K key) {				
		if(this.containsKey(key)) {
			return values[this.findKey(key)];
		}
		return null;
	}

	public boolean containsKey(K key) {	
		if(this.findKey(key) == -1) return false;
		return true;
	}

	public List<K> keys() {
		List<K> keyList = new ArrayList<K>();
		for(int i = 0; i < size; i++) {
			keyList.add(keys[i]);
		}
		return keyList;
	}

	public int size() {
		return size;
	}
} 