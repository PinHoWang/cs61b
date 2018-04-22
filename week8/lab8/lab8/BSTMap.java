
package lab8;
import java.lang.Comparable;
import java.lang.RuntimeException;
import java.util.Set;
import java.util.Iterator;


public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
	
	private class Node {
		private K key;
		private V val;
		private Node left, right; // left and right node
		private int SubTreeSize; // size of the subtree
		private boolean available; // Using in the tree travrsal

		private Node(K key, V val, int size) {
			this.key = key;
			this.val = val;
			this.SubTreeSize = size;
			this.available = true;
		}
	}

	private Node root;
	private int mapSize;


	public BSTMap() {
		mapSize = 0;
	}

	@Override
	public void clear() {
		root = null;
		mapSize = 0;
	}

	@Override
	public boolean containsKey(K key) {
		if(find(root, key) == null) return false;
		return true;
	}

	private Node find(Node x, K key) {
		if(x == null) return null;
		if(key.compareTo(x.key) > 0) {
			return find(x.right, key);
		}
		else if(key.compareTo(x.key) < 0) {
			return find(x.left, key);
		}
		return x;
	}

	@Override
	public V get(K key) {
		if(find(root, key) == null) return null;
		return (find(root, key)).val;
	}

	@Override
	public int size() {
		return mapSize;
	}

	// Return the size of the (sub-) tree root x
	private int size(Node x) {
		if(x == null) return 0;
		return x.SubTreeSize;
	}

	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
		mapSize += 1;
	}

	/* This private put method will search down the currently tree and place the new item
	 * to the right place and creative a new Node for this new item
	 * using recursion. It will return back to the path it search by assign x.left(right) = put(...)*/
	private Node put(Node x, K key, V value) {
		if(x == null) { 
			return new Node(key, value, 1);
		}
		else if (key.compareTo(x.key) < 0) {
			x.left = put(x.left, key, value);
		}
		else if(key.compareTo(x.key) > 0) {
			x.right = put(x.right, key, value);
		}
		x.SubTreeSize = 1 + size(x.left) + size(x.right);
		return x;
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

	@Override
    public Iterator<K> iterator() {
    	// return new BSTIterator();
        throw new UnsupportedOperationException("Unsupport REMOVE Operation!");
    }

    // Implement keyIterator class for iterator() method
    private class BSTIterator {

    	private Node next;
    	public BSTIterator(Node root) {
    		next = root;
    		if(next == null)
            return;

        	while (next.left != null)
           		next = next.left;
    	}

    	public boolean hasNext() {
    		return next != null;
    	}

    	public Node next() {
    		if(!hasNext()) throw new NoSuchElementException();
        	Node r = next;

        	// If you can walk right, walk right, then fully left.
        	// otherwise, walk up until you come from left.
        	if(next.right != null) {
            	next = next.right;
            	while (next.left != null)
                	next = next.left;
            	return r;
        	}

        	while(true) {
            	if(next.parent == null) {
                	next = null;
                	return r;
            	}
            	if(next.parent.left == next) {
                	next = next.parent;
               		return r;
            	}
            	next = next.parent;
        	}
     	}
    }

	public void printInOrder() {
		// print the item in tree in order ...

	}
}