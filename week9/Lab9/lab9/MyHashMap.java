
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
	private ArrayList<V> hashTable;
	// Size of HashMap
	private int size;
	// Contains of HashMap
	private int contain;
	// LoadFactor
	private double lf;

	public MyHashMap() {
		keySet = new HashSet<K>();
		size = 0;
		contain = 8;
		hashTable = new ArrayList<V>(contain);
		lf = 2;
	}

	public MyHashMap(int initialSize) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = new ArrayList<V>(contain);
		lf = 2;
	}

	public MyHashMap(int initialSize, double loadFactor) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = new ArrayList<V>(contain);
		lf = loadFactor;
	}

	// Once the size larger than container, resize with loadFactor
	public void Resize() {
		contain = contain * lf;
		hashTable.ensureCapacity(contain);
	}
	
	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		keySet = new HashSet<K>();
		size = 0;
		hashTable = new ArrayList<V>(contain);
		lf = 2; 
	}

	/* Returns true if this map contains a mapping for the specified key. */
	@Override
	public boolean containsKey(K key) {
		return HashSet.contains(key);
	}


	/* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
	@Override
	public V get(K key) {
		return hashTable.get(key);
	}

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return size;
	}


	/* Associates the specified value with the specified key in this map. */
	@Override
	public void put(K key, V value) {
		if(size >= contain) Resize();
		if(HashSet.contains(key)) throw new UnsupportedOperationException("The " + key + " is already exit.");

		keySet.add(key);

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



