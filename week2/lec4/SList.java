/* Represent a list of integers, where all the "list" work is delegated
 * to a naked IntList. */

public class SList {
	public class IntNode {
		public int item;     /* Equivalent of first */
		public IntNode next; /* Equivalent of rest */

		public IntNode(int i, IntNode h) {
			item = i;
			next = h;		
		}
	} 

	private IntNode sentinel = new IntNode(0, null);
	private IntNode front;
	private int size;

	/* Testing functions */
	public void show() {
		if(sentinel == null) System.out.println("sentinel is null.");
		else System.out.println("sentinel is not null.");
	}
	/** Creates an empty list. */
	public SList() {
		size = 0;
	}

	public SList(int x) {
		front = new IntNode(x, null);
		sentinel.item = 0;
		sentinel.next = front;
		size = 0;
	}

	/** Adds an item of the front. */
	public void insertFront(int x) {
		size++;
		front = new IntNode(x, front);
	}

	/** Gets the front item of the list. */
	public int getFront() {
		return front.item;
	}

	/** Puts an item at the back of the list. */
	public void insertBack(int x) {
		size++;
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		if(front == null) front = sentinel.next;
	}

	/** Returns the back node of our list. */
	private IntNode getBackNode() {
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		return p;
	}

	/** Returns last item */
	public int getBack() {
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		return p.item;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		SList s1 = new SList();
		s1.insertBack(6);
		s1.insertFront(4);
		s1.insertFront(3);
		System.out.println(s1.getBack());
		System.out.println(s1.getFront());
		System.out.println(s1.size());
	}
} 