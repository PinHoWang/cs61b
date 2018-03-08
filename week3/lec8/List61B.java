/* TODO: Set up this interface so that it covers all common
 * methods to AList and SList. Also add a default method
 * print that prints a list. */
public interface List61B<Blorp> {
	public void insertFront(Blorp x);
	public Blorp getFront();
	public void insertBack(Blorp x);
	//private Node getBackNode();
	public Blorp getBack();
	public Blorp deleteBack();
	public int size();
	public Blorp get(int position);
	public void insert(Blorp item, int position);

	default void print() {
		for(int i = 0; i < size(); i++) {
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}

} 