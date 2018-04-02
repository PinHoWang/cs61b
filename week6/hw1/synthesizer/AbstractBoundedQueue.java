
package synthesizer;

/* PinHo Wang created in 2 Apr. 2018 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
	protected int fillCount;
	protected int capacity;

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public int fillCount() {
		return fillCount;
	}
	
}