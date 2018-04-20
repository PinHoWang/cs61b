
package lab8;
import java.lang.Comparable;
import java.lang.RuntimeException;
import java.util.Set;

public abstract class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
	
	private int size;

	public BSTMap() {
		size = 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean containsKey(K key) {
		return true;
	}

	// @Override
	// public V get(K key) {
	// 	return;
	// }

	@Override
	public int size() {
		return size;
	}

	@Override
	public void put(K key, V value) {

	}



	@Override
	public Set<K> keySet() {
		throw new UnsupportedOperationException("Unsupport REMOVE Operation!");
	}

	@Override
	public V remove(K key) {
		throw new UnsupportedOperationException("Unsupport REMOVE Operation!");
	}

	@Override
	public V remove(K key, V value) {
		throw new UnsupportedOperationException("Unsupport REMOVE Operation!");
	}



	public void printInOrder() {
		// print the item in tree in order ...
	}
}