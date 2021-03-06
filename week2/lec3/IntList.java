/** Defines a recursive list of integers.
 *  @author Josh Hug
 */

import java.lang.Math.*;

public class IntList {
    public int head;
    public IntList tail;
    public static int sizeOfIntList = 0;

    public IntList(int h, IntList t) {
        /* your code here */
        this.head = h;
        this.tail = t;
        sizeOfIntList += 1;
    }

    public IntList(int i) {
    }

    /** Retuns the size of this IntList */
    public int size() {
        /* your code here */       
        return sizeOfIntList; 
    }

    /** Returns the size of this IntList. */
    public int iterativeSize() {
        /* your code here */
        int size = 0;
        IntList p = this;
        while(p != null) {
            size += 1;
            p = p.tail;
        }
        return size;
    }

    /** In class exercise 1: 
      * Returns ith item of this IntList. For 
      * simplicity, assume the item exists. */
    public int get(int i) {
        /** your code here */
        IntList p = this;
        /* get item larger than size of IntList */
        if(i > this.size()) {
            return 0;
        }
        else {
            while(i > 1) {
                p = p.tail;
                i -= 1;
            }
            return p.head;
        }
    }

    /** Returns the IntList as a string. Automatically called
      * whenever you try to print an IntList. */
    public String toString() {
        /* your code here */
        String str = "";
        IntList p = this;
        while(p != null) {
            str += p.head;
            p = p.tail;
        }
        return str;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList p = L;
        while(p != null) {
            p.head += x;
            p = p.tail;
        }
        return L;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList p = L;
        while(p != null) {
            p.head -= x;
            p = p.tail;
        }
        return L;
    }    

    /* Destructively squares each element of the given IntList L.
     * Don't use 'new'; modify the original IntList.
     * Should be written iteratively. */
    public static IntList SquareDestructive(IntList L) {
        /* iteratively 
        IntList p = L;
        while(p != null) {
            p.head = p.head * p.head;
            p = p.tail;
        }
        return L;
        */

        /* recurseively */
        if(L == null) return L;
        else {
            L.head = L.head * L.head;
            SquareDestructive(L.tail);
        }
        return L;
    }

    /** Non-destructively squares each element of the given IntList L
      * Should be written recurseively. */
    public static IntList SquareNonDestructive(IntList L) {
        /* 
        if(L == null) return L;
        else {
            IntList tail = SquareNonDestructive(L.tail);
            IntList M = new IntList(L.head * L.head, tail);
            return M;
        }
        */

        /* iteratively */
        IntList p = L;
        while(p != null) {
            IntList M = new IntList(p.head * p.head);
        }
    }

    public static void main(String[] args) {

        // Test your answers by uncommenting. Or use the Visualizer.
        IntList L = new IntList(5, null);
        L.tail = new IntList(7, null);    
        L.tail.tail = new IntList(9, null);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());        
        System.out.println(L.get(2));
        //System.out.println(incrList(L, 3));
        //System.out.println(dincrList(L, 3));  
        //System.out.println(L.toString());
        System.out.println(SquareDestructive(L));
        //System.out.println(SquareNonDestructive(L));

    }
} 