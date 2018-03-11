
public class ArrayDeque<Type> implements Deque<Type> {
	
	private Type[] items;
	private int size;
	private int nextFirst = 4;
	private int nextLast = nextFirst + 1;
	private static int RFACTOR = 2;

	public ArrayDeque() {
		size = 0;
		items = (Type[]) new Object[8];
	}


	private void resize(int capacity) {
		Type[] a = (Type[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, nextFirst);
		System.arraycopy(items, nextFirst + 1, a, capacity - size + nextFirst, size - nextFirst);
		items = a;
		nextFirst = capacity - size + nextFirst - 1;
	}

	@Override
	public void addFirst(Type x) {
		if(nextFirst == nextLast) resize(items.length * RFACTOR);
		items[nextFirst] = x;
		nextFirst--;
		if(nextFirst == -1) nextFirst = items.length - 1;
		size++;
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
		for(int i = 0; i < size; i++) {
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}

	@Override
	public Type removeFirst() {
		if(size == 0) return null;
		int removeIndexF = nextFirst + 1;
		if(removeIndexF > (items.length - 1)) removeIndexF = 0;
		Type i = items[removeIndexF];
		items[removeIndexF] = null;
		nextFirst++;
		size--;
		return i;
	}

	@Override
	public Type removeLast() {
		if(size == 0) return null;
		int removeIndexL = nextLast - 1;
		if(removeIndexL < 0) removeIndexL = items.length - 1;
		Type i = items[removeIndexL];
		items[removeIndexL] = null;
		
		nextLast--;
		size--;
		return i;
	}



	@Override
	public Type get(int index) {
		int position;
		if((nextFirst + index + 2) > items.length) {
			position = index - (items.length - nextFirst - 1);
			return items[position];
		}
		else {
			return items[nextFirst + index + 1];
		}
	}

	public static void main(String[] args) {
		ArrayDeque<Integer> A = new ArrayDeque<Integer>();
		for(int j = 0; j < 5; j++) {
			A.addFirst(j);
		}
		System.out.println("Size: " + A.size());
		A.printDeque();
		System.out.println(A.removeFirst());
		A.printDeque();
		System.out.println(A.removeLast());
		A.printDeque();
	}
}