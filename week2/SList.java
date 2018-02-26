public class SList {

	/* IntNode Class */
	public class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/* SList Class */
	private IntNode sentinel = new IntNode(0, null);
	private IntNode front;
	private int size;

	/* Testing functions */
	public void show() {
		if(sentinel == null) System.out.println("sentinel is null.");
		else System.out.println("sentinel is not null.");
	}



	public SList() {
		size = 0;
	}
	public SList(int x) {
		front = new IntNode(x, null);
		sentinel.item = 0;
		sentinel.next = front;
		size = 0;
	}
	public int getSize() {
		return size;
	}
	public void insertFront(int x) {
		size++;
		front = new IntNode(x, front);
	}
	public void insertBack(int x) {
		size++;
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		if(front == null) front = sentinel.next;
	}
	public int getFront() {
		return front.item;
	}
	public int getBack() {
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		return p.item;
	}

	public void printList() {
		IntNode p = front;
		while(p != null) {
			System.out.println(p.item);
			//System.out.println("Hi");
			p = p.next;
		}
	}


	/* main */
	public static void main(String[] args) {
		SList s1 = new SList();
		s1.insertBack(6);
		s1.insertFront(4);
		s1.insertFront(3);
		//System.out.println(s1.getSize());
		//System.out.println(s1.getFront());
		//System.out.println(s1.getBack());
		s1.printList();

	}

}