
/* Deque interface */
public interface Deque<Type> {

	/* Array & LinkedList Deque methods */
	public void addFirst(Type x);
	public void addLast(Type x);
	public boolean isEmpty();
	public int size();
	public void printDeque();
	public Type removeFirst();
	public Type removeLast();
	public Type get(int index);

	/* LinkedListDequeSolution methods */
	public Type getRecursive(int i);
}