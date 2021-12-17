package list.linkedlist;

import java.util.Iterator;

public class CircularlyLinkedList<E> extends AbstractLinkedList<E> {

    /**
     * The reference to the tail of the {@code LinkedList}
     */
    private Node<E> tail;

    /**
     * This private inner class defines a node to be used for storing elements
     * in a {@code CircularlyLinkedList}.
     *
     * @param <E> generic type parameter determining the type of object the
     *            {@code CircularlyLinkedList} would store.
     */
    private static class Node<E> {

        /**
         * The element being stored by the node
         */
        private E element;

        /**
         * A reference to the node in the list that is next to this node.
         */
        private Node<E> next;

        /**
         * Constructor. Initializes the element to be stored in the node.
         *
         * @param e the element to be stored by the node
         */
        private Node(E e) {
            element = e;
            next = null;
        }

    }

    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }

    /**
     * Inserts {@code element} to a position in the {@code List} specified by
     * {@code index}.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            tail = newNode;
            tail.next = tail;
        } else {
            Node<E> cur = tail.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            if (index == 0) {
                tail = tail.next;
            }
        }
        return true;
    }

    /**
     * Removes the element at a position in the {@code List} specified by
     * {@code index}.
     *
     * @param index the index position of the element to be removed
     * @return the element that was removed from the list
     * @since 1.1
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Removes a set of elements between index positions specified by
     * {@code from}, inclusive, and {@code to}, inclusive. If
     * {@code (from == to)}, then this method simply removes the element
     * specified at that index.
     *
     * @param from the index of the first element to be removed
     * @param to   the index of the last element to be removed
     * @return an array of elements that were removed from the
     * {@code List}
     * @since 1.1
     */
    @Override
    public E[] removeRange(int from, int to) {
        return null;
    }

    /**
     * Replaces the element at the position specified by {@code index} with
     * {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return the element that had just been replaced
     * @since 1.1
     */
    @Override
    public E set(int index, E newElement) {
        return null;
    }

    /**
     * Retrieves the element at the position specified by {@code index}.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @since 1.1
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Retrieves the {@code n}th occurrence of {@code element} within the
     * {@code List}. If there is less than {@code n} occurrences of the
     * specified element, then this method will return {@code null}.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning
     * @return the {@code n}th occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public E getNthOccurrence(E element, int n) {
        return null;
    }

    /**
     * Retrieves the index of the {@code n}th occurrence of {@code element}
     * within the {@code List}. If there is less than {@code n} occurrences of
     * the specified element, then this method will return {@code -1}.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning the
     *                index
     * @return the index of the {@code n}th occurrence of
     * {@code element}
     * @since 1.1
     */
    @Override
    public int getNthOccurrenceIndex(E element, int n) {
        return 0;
    }

    /**
     * Retrieves the number of times {@code element} occurs in the {@code List}.
     * If the element does not exist, then this method will return {@code 0}.
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the {@code List}
     * @since 1.1
     */
    @Override
    public int getOccurrences(E element) {
        return 0;
    }

    /**
     * Retrieves the index of the first occurrence of {@code element} in the
     * {@code List}.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * Retrieves the index of the last occurrence of {@code element} in the
     * {@code List}. This means that the index returned will be the
     * position of {@code element} furthest away from index {@code 0}.
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    /**
     * Returns an array containing the elements of the {@code List} in the order
     * they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    @Override
    public E[] toArray() {
        return null;
    }

    /**
     * Clears the {@code List} such that it is empty and ready to be used again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {

    }

    /**
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    @Override
    public E head() {
        return null;
    }

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    @Override
    public E tail() {
        return super.tail();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
