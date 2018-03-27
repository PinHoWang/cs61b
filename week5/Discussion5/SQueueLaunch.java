
public class SQueueLaunch {

	public static void main(String[] args) {

		SQueue<Integer> sq = new SQueue<Integer>();
		sq.enqueue(1);
		sq.enqueue(2);
		sq.enqueue(3);
		sq.enqueue(4);
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
	}
}