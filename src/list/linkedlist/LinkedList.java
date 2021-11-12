package list.linkedlist;

import list.List;

/**
 * This is the root interface of the {@code LinkedList} hierarchy. The {@code
 * LinkedList} is a data structure that stores a group of objects has a chain
 * of nodes, with the {@code head} (beginning of the list) representing the
 * whole structure.
 * <br><br>
 * A node in a {@code LinkedList} represent a single element of type {@link E},
 * alongside a reference that points to the next node in the list and, although
 * optional, a reference that points to the previous node in the list.
 * Altogether, they become a chain of nodes linked together in a linear fashion.
 * <br><br>
 * Nodes in a {@code LinkedList} accepts all elements, including duplicates
 * and {@code null}, as long as they follow the constraints specified at {@link
 * E}.
 * <br><br>
 * Due to its structure, retrieving elements become less efficient as the user
 * must traverse through all the nodes in the list until the node to be
 * retrieved is reached. However, the advantage comes when inserting and
 * removing elements anywhere in the list, as it only requires that the
 * references be changed rather than, in the case of an array, shifting elements
 * of the whole list.
 * <br><br>
 * All <code>LinkedList</code> objects should implement the {@link Iterable}
 * interface and provide an {@link java.util.Iterator Iterator} to allow looping
 * through the collection of objects, and to provide a for-each syntax.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code LinkedList} would store.
 * @version 1.1
 * @see List
 * @see Iterable
 */
public interface LinkedList<E> extends List<E> {

    /**
     * Inserts {@code element} to the head of the {@code LinkedList}.
     *
     * @param element the element to be inserted to the list
     * @return {@code true} to indicate a change has been made to the list
     */
    boolean addFirst(E element);

    /**
     * Inserts {@code element} to the tail of the {@code LinkedList}.
     * @param element the element to be inserted to the list
     * @return {@code true} to indicate a change has been made to the list
     */
    boolean addLast(E element);

    /**
     * Removes the head of the {@code LinkedList}.
     *
     * @return the element stored at the head
     */
    E removeFirst();

    /**
     * Removes the tail of the {@code LinkedList}.
     *
     * @return the element stored at the tail
     */
    E removeLast();

    /**
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    E head();

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    E tail();

}
