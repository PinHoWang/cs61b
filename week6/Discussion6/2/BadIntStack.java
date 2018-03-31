
public class BadIntStack {
	public SNode top;

	public boolean isEmpty() {
		return top == null;
	}
	public void push(Integer num) {
		top = new SNode(num, top);
	}
	public Integer pop() {
		Integer ans = top.val;
		top = top.prev;
		return ans;
	}
	public Integer peek() {
		return top.val;
	}
}