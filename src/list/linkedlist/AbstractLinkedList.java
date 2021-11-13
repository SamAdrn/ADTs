package list.linkedlist;

import list.AbstractList;

/**
 * This abstract class provides a skeletal implementation to the
 * {@link LinkedList} interface, outlining the methods and fields that would
 * have similar behaviors across various abstractions.
 * <br><br>
 * This class also defines a protected {@link Node} class that is used for
 * all {@code LinkedList} implementations. This class can also be extended
 * further for certain more specific {@code LinkedList} implementations. A
 * reference to the {@link #head} of the {@code LinkedList} is also kept here.
 * <br><br>
 * Furthermore, this class defines most of the operational functionalities of
 * a {@code LinkedList}. However, it may need to be overridden for certain
 * implementations, such as the {@code DoublyLinkedList}.
 * <br><br>
 * Some behaviors are already defined in the {@link AbstractList} class.
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
     * The reference to the head of the {@code LinkedList}
     */
    protected Node<E> head;

    /**
     * This private inner class defines a node to be used for storing elements
     * in a {@code LinkedList}.
     *
     * @param <E> generic type parameter determining the type of object the
     *            {@code LinkedList} would store.
     */
    protected static class Node<E> {

        /**
         * The element being stored by the node
         */
        protected E element;

        /**
         * A reference to the node in the list that is next to this node.
         */
        protected Node<E> next;

        /**
         * Constructor. Initializes the element to be stored in the node.
         *
         * @param e the element to be stored by the node
         */
        protected Node(E e) {
            element = e;
            next = null;
        }

    }

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
     * Clears the {@code LinkedList} such that it is empty and ready to be
     * used again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
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
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    @Override
    public E head() {
        return head.element;
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

    /**
     * Provides a <code>String</code> representation to the whole
     * <code>LinkedList</code> object, such that it prints out all the elements
     * current stored in it using the following format:
     * <blockquote><code>[a1 a2 a3 a4 ... an]</code></blockquote>
     *
     * @return a <code>String</code> consisting of all the elements currently
     * stored in the <code>LinkedList</code>
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        Node<E> cur = head;
        for (int i = 0; i < size - 1; i++) {
            str.append(cur.element).append(" ");
            cur = cur.next;
        }
        return str.append(cur.element).append("]").toString();
    }
}
