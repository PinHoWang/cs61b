
public class LinkedListDeque<Type> implements Deque<Type> {
	/* Node class */
	public class Node {
		public Type item;
		public Node prev;
		public Node next;
		public Node(Type i, Node p, Node n) {
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
	public LinkedListDeque(Type x) {
		size = 1;
		sentinel = new Node(null, null, null);
		sentinel.next = new Node(x, null,null);
		sentinel.next.prev = sentinel.next;
		sentinel.next.next = sentinel.next;
	}

	@Override
	public void addFirst(Type x) {
		if(isEmpty()) {
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

	@Override
	public void addLast(Type x) {
		if(isEmpty()) {
			sentinel.next = new Node(x, null, null);
			sentinel.next.prev = sentinel.next;
			sentinel.next.next = sentinel.next;
			size++;
		}
		else {
			Node p = sentinel.next.prev;
			Node newNode = new Node(x, p, p.next);
			p.next = newNode;
			sentinel.next.prev = newNode;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printDeque() {
		for(int i = 0; i < size(); i++) {
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}

	@Override
	public Type removeFirst() {
		if(isEmpty()) {
			System.out.println("Nothing to remove.");
			System.exit(-1);
		}
		
		if(size == 1) {
			Type i = sentinel.next.item;
			sentinel.next = null;
			size--;
			return i;
		}
		else {
			Type i = sentinel.next.item;
			Node front = sentinel.next.next;
			Node back = sentinel.next.prev;
			front.prev = back;
			back.next = front;
			sentinel.next = front;
			size--;
			return i;
		}
	}

	@Override
	public Type removeLast() {
		if(isEmpty()) {
			System.out.println("Nothing to remove.");
			System.exit(-1);
		}
		
		if(size == 1) {
			Type i = sentinel.next.item;
			sentinel.next = null;
			size--;
			return i;
		}
		else {
			Type i = sentinel.next.prev.item;
			Node front = sentinel.next;
			Node back = front.prev.prev;
			front.prev = back;
			back.next = front;
			size--;
			return i;
		}
	}

	@Override
	public Type get(int index) {
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
	/*
	public static void main(String[] args) {
		LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
		LinkedListDeque<String> Q = new LinkedListDeque<String>("yoo");
		L.addFirst(1);
		//Q.addFirst("YOO");
		L.addLast(5);
		//Q.addLast("MAO");
		//System.out.println(Q.removeFirst());
		System.out.println(L.removeLast());
		L.printDeque();
		Q.printDeque();
	}
	*/
}