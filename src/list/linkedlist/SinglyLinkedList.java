package list.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * This class is an implementation of the {@link LinkedList} interface.
 * <br><br>
 * The {@code SinglyLinkedList} is the most common implementation of a
 * {@code LinkedList}. Traversing in a {@code SinglyLinkedList} only goes
 * one-way: from the {@link #head} to the end of the list, otherwise known as
 * the tail.
 * <br><br>
 * The insertion order in a {@code SinglyLinkedList} is maintained until a
 * change is made by the user through the {@link #set(int, Object)} method.
 * For example, if the {@code Collection} of elements : {@code [a1, a2, a3, ...,
 * an]} is inserted to the {@code SinglyLinkedList}, it will store it as
 * <blockquote>{@code [a1, a2, a3, ..., an]}<br>where {@code n} is the number of
 * elements inside the {@code Collection}.</blockquote>
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code LinkedList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see LinkedList
 * @see AbstractLinkedList
 */
@SuppressWarnings({"unchecked"})
public class SinglyLinkedList<E> extends AbstractLinkedList<E> {

    /**
     * The reference to the head of the {@code LinkedList}
     */
    private Node<E> head;

    /**
     * This private inner class defines a node to be used for storing elements
     * in a {@code LinkedList}.
     *
     * @param <E> generic type parameter determining the type of object the
     *            {@code LinkedList} would store.
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

    /**
     * Default Constructor. Initializes the head of the {@code LinkedList}.
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Copy Constructor. Takes in another {@code LinkedList} object
     * and creates a deep copy of it.
     *
     * @param sll the other {@code LinkedList} object to be copied
     */
    public SinglyLinkedList(LinkedList<E> sll) {
        this.addAll(Arrays.asList(sll.toArray()));
    }

    /**
     * Inserts {@code element} to a position in the {@code LinkedList}
     * specified by {@code index}.
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
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        size++;
        return true;
    }


    /**
     * Inserts a {@code Collection} of elements to a position in the
     * {@code LinkedList} specified by {@code index}.
     * <br><br>
     * This method is overridden from the {@link list.AbstractList} class to
     * implement a more efficient method of successively adding all
     * elements in the collection in one iteration, instead of traversing
     * through the list over and over again with every {@link #add(int, Object)}
     * method call.
     *
     * @param index the index position where the {@code Collection} of
     *              elements should be inserted
     * @param c     the {@code Collection} containing elements to be inserted
     * @throws NullPointerException if the {@code Collection} of objects
     *                              specified is {@code null}
     * @see Collection
     * @since 1.1
     */
    @Override
    public void addAll(int index, Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Collection is null");
        }
        Node<E> cur = head;
        for (int i = 0; i < index - 1 && cur != null; i++) {
            cur = cur.next;
        }
        for (E e : c) {
            if (cur == null) {
                head = new Node<>(e);
                cur = head;
            } else {
                Node<E> newNode = new Node<>(e);
                if (cur.next != null) {
                    newNode.next = cur.next;
                }
                cur.next = newNode;
                cur = cur.next;
            }
        }
        size += c.size();
    }

    /**
     * Removes the element at a position in the {@code LinkedList}
     * specified by {@code index}.
     *
     * @param index the index position of the element to be removed
     * @return the element that was removed from the list
     * @since 1.1
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        E e;
        if (index == 0) {
            e = head.element;
            head = head.next;
        } else {
            Node<E> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            e = cur.next.element;
            cur.next = cur.next.next;
        }
        size--;
        return e;
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
     * {@code LinkedList}
     * @since 1.1
     */
    @Override
    public E[] removeRange(int from, int to) {
        if (from < 0 || to < 0 || from >= size || to >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> cur = head;
        Node<E> prev = null;
        for (int i = 0; i < from; i++) {
            prev = cur;
            cur = cur.next;
        }
        E[] eArr = (E[]) new Object[to - from + 1];
        for (int i = 0; i < to - from + 1; i++) {
            eArr[i] = cur.element;
            cur = cur.next;
            size--;
        }
        if (prev == null) {
            head = cur;
        } else {
            prev.next = cur;
        }
        return eArr;
    }

    /**
     * Replaces the element at the position specified by {@code index}
     * with {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return the element that had just been replaced
     * @since 1.1
     */
    @Override
    public E set(int index, E newElement) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E e = cur.element;
        cur.element = newElement;
        return e;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    /**
     * Retrieves the {@code n}th occurrence of {@code element} within
     * the {@code LinkedList}. If there is less than {@code n}
     * occurrences of the specified element, then this method will return
     * {@code null}.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning
     * @return the {@code n}th occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public E getNthOccurrence(E element, int n) {
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, cur.element)) {
                n--;
                if (n == 0) {
                    return cur.element;
                }
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * Retrieves the index of the {@code n}th occurrence of
     * {@code element} within the {@code LinkedList}. If there is less
     * than {@code n} occurrences of the specified element, then this
     * method will return {@code -1}.
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
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, cur.element)) {
                n--;
                if (n == 0) {
                    return i;
                }
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * Retrieves the number of times {@code element} occurs in the
     * {@code LinkedList}. If the element does not exist, then this method
     * will return {@code 0}.
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the
     * {@code LinkedList}
     * @since 1.1
     */
    @Override
    public int getOccurrences(E element) {
        int counter = 0;
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, cur.element)) {
                counter++;
            }
            cur = cur.next;
        }
        return counter;
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
     * Retrieves the index of the first occurrence of {@code element} in
     * the {@code LinkedList}.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int indexOf(E element) {
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, cur.element)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * Retrieves the index of the last occurrence of {@code element} in the
     * {@code LinkedList}. This means that the index returned will be the
     * position of {@code element} furthest away from index {@code 0}.
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int lastIndexOf(E element) {
        int index = -1;
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, cur.element)) {
                index = i;
            }
            cur = cur.next;
        }
        return index;
    }

    /**
     * Returns an array containing the elements of the {@code LinkedList}
     * in the order they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    @Override
    public E[] toArray() {
        E[] eArr = (E[]) new Object[size];
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            eArr[i] = cur.element;
            cur = cur.next;
        }
        return eArr;
    }

    /**
     * Provides a {@code String} representation to the whole
     * {@code List} object, such that it prints out all the elements
     * current stored in it using the following format:
     * <blockquote>{@code [a1 a2 a3 a4 ... an]}</blockquote>
     *
     * @return a {@code String} consisting of all the elements currently
     * stored in the {@code List}
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
     * Returns an iterator over elements of type {@code E}. The iterator for
     * {@code LinkedList} objects is defined in the private inner class
     * {@link SinglyLinkedListIterator SinglyLinkedListIterator}.
     *
     * @return an {@code Iterator}
     * @see SinglyLinkedListIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    /**
     * This private inner class provides an {@code Iterator} of type
     * {@code E}, providing the functionality of looping through the
     * elements of an {@code LinkedList}. This implementation offers support
     * for the {@link #remove()} method as well, and will not fail unless the
     * {@link #next()} method has never been called, or the element is already
     * removed. The iterator will not loop back to the beginning of the
     * {@code LinkedList} once the end has been reached, rendering it
     * unusable at that point.
     *
     * @see Iterator
     */
    private class SinglyLinkedListIterator implements Iterator<E> {

        /**
         * A reference to the node the iterator is currently pointing to.
         */
        private Node<E> cur;

        /**
         * A reference to the previous node of the node the iterator is
         * currently pointing to.
         */
        private Node<E> prev;

        /**
         * A reference to the previous node of prev
         */
        private Node<E> prev2;

        /**
         * Constructor. Initializes the iterator to start at the beginning of
         * the {@code LinkedList}.
         */
        public SinglyLinkedListIterator() {
            prev = null;
            prev2 = null;
            cur = head;
        }

        /**
         * Indicates whether the iteration has more elements.
         *
         * @return {@code true} if the {@code LinkedList} still has
         * more elements
         */
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E e = cur.element;
            prev2 = prev;
            prev = cur;
            cur = cur.next;
            return e;
        }

        /**
         * Removes the last element returned by {@link #next()}. Note that the
         * method will fail if the {@link #next()} has never been called
         * during the lifespan of the iterator, or if the element to be removed
         * has already been removed.
         *
         * @throws IllegalStateException if the {@link #next()} has never been
         *                               called or the element has already been
         *                               removed
         */
        @Override
        public void remove() {
            if (prev == null) {
                throw new IllegalStateException("element already removed");
            }
            if (prev == head) {
                head = cur;
            } else {
                prev2.next = cur;
                prev = null;
            }
            size--;
        }
    }
}
