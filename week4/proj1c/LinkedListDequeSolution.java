/** Implementation for LinkedListDeque from project 1a. Relies on inheritance
  * in ways that were forbidden to you in the project 1a spec. Specifically,
  * I designed project 1a so that you were basically rebuilding the built-in
  * Java LinkedList class, so extending LinkedList is the solution (more or less). 
  *
  * You are not expected to understand the code below, but you will need to
  * make it implement your Deque interface. */
import java.util.LinkedList;

public class LinkedListDequeSolution<Type> extends LinkedList<Type> implements Deque<Type> {
    
    @Override
    public void printDeque() {
        for (Type x : this) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    /** Not actually recursive, but we don't care for project 1c. */
    @Override
    public Type getRecursive(int i) {
        return get(i);
    }

    /** Try/catch is so that code doesn't crash when we try to get from bad indices.
      * Instead, we return
       null as per the spec. We'll learn about try/catch after
      * the midterm. */
    @Override
    public Type get(int i) {
        try {
            return super.get(i);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    @Override
    public Type removeFirst() {
        try {
            return super.removeFirst();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    @Override
    public Type removeLast() {
        try {
            return super.removeLast();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }       
    }
}
