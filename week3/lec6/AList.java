/** Array based list.
 *  @author Josh Hug
 */

public class AList {

    private int[] items;
    private int size;

    private static int R = 2;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = new int[100];
    }

    /* resize the array */
    private void resize(int capability) {
        int[] a = new int[capability];
        System.arraycopy(items, 0, a, 0, items.length);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void insertBack(int x) {
        if(size == items.length) {
            resize(size * R);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getBack() {
        return items[size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int deleteBack() {
        int i = items[size - 1];
        items[size - 1] = 0;
        size -= 1;
        return i;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }


    public static void main(String[] args) {
        AList l = new AList();
        for(int i = 0; i < 5; i++) {
            l.insertBack(i);
        }
        System.out.println(l.getBack());
        System.out.println(l.deleteBack());
        System.out.println(l.getBack());
      
    }
} 