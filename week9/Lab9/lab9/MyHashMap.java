
package lab9;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class MyHashMap<K, V> implements Map61B<K, V> {

	// Storage all key with unique value
	private HashSet<K> keySet;
	// Hash table
	private ArrayList<LinkedList> hashTable;
	// Size of HashMap
	private int size;
	// LoadFactor
	private double lf;

	public MyHashMap() {
		keySet = new HashSet<K>();
		size = 8;
		hashTable = new ArrayList<LinkedList>(size);
		lf = 2;
	}

	public MyHashMap(int initialSize) {
		keySet = new HashSet<K>();
		size = initialSize;
		hashTable = new ArrayList<LinkedList>(size);
		lf = 2;
	}

	public MyHashMap(int initialSize, double loadFactor) {
		keySet = new HashSet<K>();
		size = initialSize;
		hashTable = new ArrayList<LinkedList>(size);
		lf = loadFactor;
	}
	
	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {

	}

	/* Returns true if this map contains a mapping for the specified key. */
	@Override
	public boolean containsKey(K key) {
		return false;
	}


	/* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
	// @Override
	// public V get(K key) {

	// }

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return 0;
	}


	/* Associates the specified value with the specified key in this map. */
	@Override
	public void put(K key, V value) {

	}

	/* Returns a Set view of the keys contained in this map. */
	// @Override
	// public Set<K> keySet() {

	// }


	/* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an 
     * UnsupportedOperationException. */
	@Override
	public V remove(K key) {
		throw new UnsupportedOperationException();
	}

	/* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
	@Override
	public V remove(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<K> iterator() {
		throw new UnsupportedOperationException();
	}
}



