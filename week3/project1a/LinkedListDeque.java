
public class LinkedListDeque<type> implements Deque<type> {
	/* Node class */
	public class Node {
		public type item;
		public Node prev;
		public Node next;
		public Node(type i, Node p, Node n) {
			item = i;
			prev = p;
			next = n;
		}
	}

	private int size;
	private Node sentinel;

	/* Implements Methods */
	public LinkedListDeque() {
		size = 0;
		sentinel = new Node(null, null, null);
	}
	public LinkedListDeque(type x) {
		size = 1;
		sentinel = new Node(null, null, null);
		sentinel.next = new Node(x, null,null);
		sentinel.next.prev = sentinel.next;
		sentinel.next.next = sentinel.next;
	}

	@Override
	public void addFirst(type x) {
		if(sentinel.next == null) {
			sentinel.next = new Node(x, null, null);
			sentinel.next.prev = sentinel.next;
			sentinel.next.next = sentinel.next;
			size++;
		}
		else {
			Node p = sentinel.next;
			Node newNode = new Node(x, p.prev, p);
			p.prev = newNode;
			if(size == 1) p.next = newNode;
			sentinel.next = newNode;
			size++;
		}
	}

	// @Override
	// public void addLast(type x) {
	// 	if(sentinel.next == null) {
	// 		sentinel.next = new Node(x, null, null);
	// 		sentinel.next.prev = sentinel.next;
	// 		sentinel.next.next = sentinel.next;
	// 		size++;
	// 	}
	// 	else {

	// 	}
	// }

	@Override
	public int size() {
		return size;
	}

	@Override
	public type get(int index) {
		if((index > size - 1) || index < 0) {
			System.out.println("Index is larger than the Qeque size or smaller than 0.");
			System.exit(-1);
		}

		Node p = sentinel.next;
		for(int i = 0; i < index; i++) {
			p = p.next;
		}
		return p.item;
	}


	/* main function */
	public static void main(String[] args) {
		LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
		LinkedListDeque<String> Q = new LinkedListDeque<String>("yoo");
		L.addFirst(1);
		Q.addFirst("YOO");
		L.print();
		Q.print();


	}
}