
package lab9;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class MyHashMap<K, V> implements Map61B<K, V> {


	// HashNode class: Store in the external chaining
	private class HashNode<K, V> {
		private K key;
		private V value;
		private HashNode next;
		private boolean init;

		public V getValue() {
			return this.value;
		}

		public K getKey() {
			return this.key;
		}

		public boolean initial() {
			return init;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public HashNode() {
			init = false;
		}

		public HashNode(K k, V v) {
			key = k;
			value = v;
			next = null;
			init = true;
		}
	}

	// Storage all key with unique value
	private HashSet<K> keySet;
	// Hash table
	private ArrayList<HashNode> hashTable;
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
		hashTable = new ArrayList<HashNode>(contain);
		for(int i = 0; i < contain; i++) {
			HashNode<K, V> h = new HashNode<K, V>();
			hashTable.add(i, h);
		}
		lf = 2;
	}

	public MyHashMap(int initialSize) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = new ArrayList<HashNode>(contain);
		for(int i = 0; i < contain; i++) {
			HashNode<K, V> h = new HashNode<K, V>();
			hashTable.add(i, h);
		}
		lf = 2;
	}

	public MyHashMap(int initialSize, double loadFactor) {
		keySet = new HashSet<K>();
		size = 0;
		contain = initialSize;
		hashTable = new ArrayList<HashNode>(contain);
		for(int i = 0; i < contain; i++) {
			HashNode<K, V> h = new HashNode<K, V>();
			hashTable.add(i, h);
		}
		lf = loadFactor;
	}

	// Once the size larger than container, resize with loadFactor
	private void Resize() {
		int newContain = (int) ((double) contain * lf);
		ArrayList<HashNode> newHashTable = new ArrayList<HashNode>();
		
		hashTable.ensureCapacity(contain);
	}

	// Return the key's hashcode
	private int hashcode(K key) {
		// System.out.println(key.hashCode());
		// System.out.println(key.hashCode() % contain);
		int i = key.hashCode() % contain;
		if(i == -1) i += contain;
		return i;
	}
	
	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		keySet = new HashSet<K>();
		size = 0;
		hashTable = new ArrayList<HashNode>(contain);
		for(int i = 0; i < contain; i++) {
			HashNode<K, V> h = new HashNode<K, V>();
			hashTable.add(i, h);
		}
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
		if(!containsKey(key)) return null;
		else {
			// System.out.println("contain key");
			HashNode<K, V> ptr = hashTable.get(hashcode(key));
			while(ptr.next != null) {
				if(ptr.getKey() == key) {
					// System.out.println("get Key");
					return ptr.getValue();
				}
				ptr = ptr.next;
			}
			return ptr.getValue();
		}
	}

	/* Returns the number of key-value mappings in this map. */
	@Override
	public int size() {
		return size;
	}


	/* Associates the specified value with the specified key in this map. */
	@Override
	public void put(K key, V value) {
		// if(size == contain) {
		// 	Resize();
		// }

		int code = hashcode(key); // Find the corresponding hash index bucket
		// System.out.println(code);
		HashNode<K, V> head = hashTable.get(code);
		if(!head.initial()) {
			keySet.add(key);
			head.setKey(key);
			head.setValue(value);
			size++;
		}
		else {
			keySet.add(key);
			HashNode<K, V> ptr = hashTable.get(code);
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



