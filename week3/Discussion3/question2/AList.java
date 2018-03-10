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

    /* Discussion 3 - 2.1 - Insert: Non-destructively insert a value
     * to the array */
    public void insert(int item, int position) {
        if(size == items.length) {
            resize(size * R);
        }
        System.arraycopy(items, position, items, position+1, this.size()-position);
        items[position] = item;
        size++;
    }

    /* Discussion 3 - 2.2 - Reverse: destructively reverse the array */
    public void reverse() {
        int[] newA = new int[size];
        for(int i = 0; i < size; i++) {
            newA[i] = items[size - 1 - i];
        }
        for(int j = 0; j < size; j++) {
            System.out.println(newA[j]);
        }
    }

    /* Discussion 3 - 2.3 - Xify: Replace the ith item with x[i]
     * copies of itself */
    public void xify() {
        /* calculate need space */
        int space = 0;
        for(int k = 0; k < size; k++)
            space += items[k];
        int[] newA = new int[space];
        int position = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < items[i]; j++) {
                newA[position + j] = items[i];
            }
            position += items[i];
        }

        //for(int l = 0; l < space; l++) System.out.println(newA[l]);
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
        // System.out.println(l.getBack());
        // System.out.println(l.deleteBack());
        // System.out.println(l.getBack());
        //l.insert(3, 1);
        //l.reverse();
        l.xify();
        // for(int i = 0; i < l.size(); i++) {
        //     System.out.println(l.get(i));
        // }
      
    }
} 