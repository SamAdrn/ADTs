package list.linkedlist;

import list.AbstractList;

/**
 * This abstract class provides a skeletal implementation to the
 * {@link LinkedList} interface, outlining the methods and fields that would
 * have similar behaviors across various abstractions.
 *
 * <p> Furthermore, this class defines most of the operational functionalities
 * of a {@code LinkedList}. However, it may need to be overridden for certain
 * implementations, such as the {@code DoublyLinkedList}.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code LinkedList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see AbstractList
 * @see LinkedList
 */
public abstract class AbstractLinkedList<E> extends AbstractList<E>
        implements LinkedList<E> {

    /**
     * Removes the head of the {@code LinkedList}.
     *
     * @return the element stored at the head
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Removes the tail of the {@code LinkedList}.
     *
     * @return the element stored at the tail
     */
    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Inserts {@code element} to the head of the {@code LinkedList}.
     *
     * @param element the element to be inserted to the list
     * @return {@code true} to indicate a change has been made to the list
     */
    @Override
    public boolean addFirst(E element) {
        return add(0, element);
    }

    /**
     * Inserts {@code element} to the tail of the {@code LinkedList}.
     *
     * @param element the element to be inserted to the list
     * @return {@code true} to indicate a change has been made to the list
     */
    @Override
    public boolean addLast(E element) {
        return add(size, element);
    }

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    @Override
    public E tail() {
        return get(size - 1);
    }

}
