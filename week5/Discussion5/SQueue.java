
import java.util.*;

public class SQueue<Type> {
	// add any instance variables you like
	private Stack<Type> s1;
	private Stack<Type> s2;
	private int size;

	public SQueue() {
		// add any code to the constructor you like
		s1 = new Stack<Type>();
		s2 = new Stack<Type>();
		size = 0;
	}

	public void enqueue(Type item) {
		// your code here
		s1.push(item);
		size++;
	}

	public Type dequeue() {
		// your code here
		if(size == 0) {
			System.out.println("Nothing to dequeue!");
			System.exit(-1);
		}
		size--;
		if(s2.empty()) {
			while(!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}