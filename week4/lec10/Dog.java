
import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

	/* Make compare between two Objects
	 * if this larger than o, return 1
	 * if this equals to o, return 0
	 * if this smaller than 0, return -1 */
    public int compareTo(Dog doggy) {
    	//Dog doggy = (Dog) o;
    	return this.size - doggy.size;
    }

    /* Using the comparator to compare different kinds of variable */
    private static class NameComparator implements Comparator<Dog> {
    	public int compare(Dog a, Dog b) {
    		return a.name.compareTo(b.name);
    	}
    }

    /* Usually code writting -> keep buildin method private */
    public static Comparator<Dog> getNameComparator() {
    	return new NameComparator();
    }
}