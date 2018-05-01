
package lab9;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class MyHashMap<K, V> implements Map61B<K, V> {


	// HashNode class: Store in the external chaining
	private class HashNode {
		private K key;
		private V value;
		private HashNode next;

		private HashNode(K k, V v) {
			key = k;
			value = v;
			next = null;
		}
	}

	// Storage all key with unique value
	private HashSet<K> keySet;
	// Hash table
	private HashNode[] hashTable;
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
		hashTable = (HashNode[]) new Object[contain];
		lf = 2;
	}

	public MyHashMap(int initialSize) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = (HashNode[]) new Object[contain];
		lf = 2;
	}

	public MyHashMap(int initialSize, double loadFactor) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = (HashNode[]) new Object[contain];
		lf = loadFactor;
	}

	// Once the size larger than container, resize with loadFactor
	private void Resize() {
		contain = (int) ((double) contain * lf);
		HashNode[] newTable = (HashNode[]) new Object[contain];
		System.arraycopy(hashTable, 0, newTable, 0, hashTable.length);
		hashTable = newTable;
	}

	// Return the key's hashcode
	private int hashcode(K key) {
		// System.out.println(key.hashCode());
		// System.out.println(key.hashCode() % contain);
		return key.hashCode() % contain;
	}
	
	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		keySet = new HashSet<K>();
		size = 0;
		hashTable = (HashNode[]) new Object[contain];
	}

	/* Returns true if this map contains a mapping for the specified key. */
	@Override
	public boolean containsKey(K key) {
		return keySet.contains(key);
	}


	/* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
	@Override
	public V get(K key) {
		if(containsKey(key)) {
			HashNode ptr = hashTable[hashcode(key)];
			while(ptr.next != null) {
				if(ptr.value == key) return ptr.value;
				ptr = ptr.next;
			}
		}
		return null;
	}

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return size;
	}


	/* Associates the specified value with the specified key in this map. */
	@Override
	public void put(K key, V value) {
		if(size == contain) {
			Resize();
		}

		int code = hashcode(key); // Find the corresponding hash index bucket
		HashNode head = hashTable[code];
		if(head == null) {
			keySet.add(key);
			head = new HashNode(key, value);
			size++;
		}
		else {
			keySet.add(key);
			HashNode ptr = head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new HashNode(key, value);
			size++;
		}
	}

	/* Returns a Set view of the keys contained in this map. */
	@Override
	public Set<K> keySet() {
		return keySet;
	}


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



