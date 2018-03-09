/* Represent a list of stuff, where all the "list" work is delegated
 * to a naked recursive data structure. */

public class SList<Blorp> {
	public class Node {
		public Blorp item;     /* Equivalent of first */
		public Node next; /* Equivalent of rest */

		public Node(Blorp i, Node h) {
			item = i;
			next = h;		
		}
	} 

	private Node sentinel;
	private int size;

	/** Creates an empty list. */
	public SList() {
		size = 0;
		sentinel = new Node(null, null);
	}

	public SList(Blorp x) {
		size = 1;
		sentinel = new Node(null, null);
		sentinel.next = new Node(x, null);
	}

	/** Adds an item of the front. */
	public void insertFront(Blorp x) {
		Node oldFrontNode = sentinel.next;
		Node newNode = new Node(x, oldFrontNode);
		sentinel.next = newNode;
		size += 1;
	}

	/** Gets the front item of the list. */
	public Blorp getFront() {
		return sentinel.next.item;
	}

	/** Puts an item at the back of the list. */
	public void insertBack(Blorp x) {
		size += 1;

		Node p = sentinel;

		/* Move p until it reaches the end. */
		while (p.next != null) {
			p = p.next;
		}

		p.next = new Node(x, null);
	}

	/** Returns the back node of our list. */
	private Node getBackNode() {
		Node p = sentinel;

		/* Move p until it reaches the end. */
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}

	/** Returns last item */
	public Blorp getBack() {
		Node back = getBackNode();
		return back.item;
	}

	/* Discussion 3 - 1.1. Insert method: insert the value 
		to a particular place. */
	public void insert(Blorp item, int position) {
		if(position < 1 || position > size) {
			System.out.println("Error: Postion must larger than 1.");
			System.exit(-1);
		}
		else {
			Node front = sentinel.next;
			while(position != 0) {
				position--;
				/* when there is the position (position == 0), add the
				 * new Node between its front and back. */
				if(position == 0) {
					Node newNode = new Node(item, front.next);
					front.next = newNode;
					size++;
				}
				front = front.next;
			}

		}
	}

	/* Discussion 3 - 1.2. Reverse method: reverse all elements 
	 * without using "new", on the other hand, using original Nodes. */
	public void reverse() {
		Node prev = null;
		Node current = sentinel.next;
		Node back;

		while(current != null) {
			back = current.next;
			current.next = prev;
			prev = current;
			current = back;
			if(current != null)
				back = current.next;
		}
		sentinel.next = prev;
	}

	public int size() {
		return size;
	}
} 