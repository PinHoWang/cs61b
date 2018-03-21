
/* The interface of LinkedListDeque and ArrayDeque */
public interface Deque<Type> {
	/* Methods */
	public void addFirst(Type x);	/* Adds an item to the front of the Deque */
	public void addLast(Type x);	/* Adds an item to the back of the Deque */
	public boolean isEmpty();	/* Returns true if deque is empty, false otherwise */
	public int size();			/* Returns the number of items in the Deque */
	public void printDeque();	/* Prints the items in teh Deque from first to
								 /* last, separated by a space */
	public Type removeFirst();	/* Removes and returns the item at the front
								 /* of the Deque. If no such item exits,
								 * return null. */
	public Type removeLast();	/* Removes and returns the item at the back
								 /* of the Deque. If no such item exits,
								 * return null. */
	public Type get(int index);	/* Gets the item at the given index, where 0 is
								 /* the front, 1 is teh next item, and so forth.
								 * If no such item exists, returns null.
								 * Must not alter the deque! */
}