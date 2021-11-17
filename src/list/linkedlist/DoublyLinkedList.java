package list.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * This class is an implementation of the {@link LinkedList} interface.
 * <br><br>
 * The {@code DoublyLinkedList} uses nodes that store references to its next
 * node and its previous node. This allows traversing in a
 * {@code DoublyLinkedList} to go both ways: from the {@link #head} to the
 * {@link #tail} and vice versa.
 * <br><br>
 * The advantage to this implementation is the reverse traversals. This allows
 * us to delete a node in the list easily since we have access to its previous
 * node.
 * <br><br>
 * The insertion order in a {@code DoublyLinkedList} is maintained until a
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
public class DoublyLinkedList<E> extends AbstractLinkedList<E> {

    /**
     * The reference to the head of the {@code LinkedList}
     */
    private Node<E> head;

    /**
     * The reference to the tail of the {@code LinkedList}
     */
    private Node<E> tail;

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
         * A reference to the node in the list that is previous to this node.
         */
        private Node<E> prev;

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
     * Default Constructor. Initializes a starting array of capacity {@code 10}.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Copy Constructor. Takes in another {@code LinkedList} object
     * and creates a deep copy of it.
     *
     * @param sll the other {@code SinglyLinkedList} object to be copied
     */
    public DoublyLinkedList(LinkedList<E> sll) {
        this.addAll(Arrays.asList(sll.toArray()));
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
        Node<E> cur;
        if (size - index < size / 2) {
            cur = tail;
            for (int i = size - 1; i > index + 1; i--) {
                cur = cur.prev;
            }
        } else {
            cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
        }
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = cur;
            cur.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = cur;
            cur.next = newNode;
            tail = newNode;
        } else {
            newNode.prev = cur;
            newNode.next = cur.next;
            cur.next.prev = newNode;
            cur.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts a {@code Collection} of elements to a position in the
     * {@code List} specified by {@code index}.
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        Node<E> cur;
        if (size - index < size / 2) {
            cur = tail;
            for (int i = size - 1; i > index - 1; i--) {
                cur = cur.prev;
            }
        } else {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }
        for (E e: c) {
            Node<E> newNode = new Node<>(e);
            if (size == 0) {
                head = tail = newNode;
                cur = head;
            } else if (index == 0) {
                newNode.next = cur;
                cur.prev = newNode;
                head = newNode;
                cur = head;
            } else if (index == size) {
                newNode.prev = cur;
                cur.next = newNode;
                tail = newNode;
                cur = cur.next;
            } else {
                newNode.prev = cur;
                newNode.next = cur.next;
                cur.next.prev = newNode;
                cur.next = newNode;
                cur = cur.next;
            }
            index++;
            size++;
        }
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        Node<E> cur = findNode(index);
        E output = cur.element;
        if (cur == head) {
            head = cur.next;
        } else if (cur == tail) {
            tail = cur.prev;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        size--;
        return output;
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
        if (from < 0 || to < 0 || from >= size || to >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> f = findNode(from);
        int diff = to - from + 1;
        E[] output = (E[]) new Object[diff];
        Node<E> t = f;
        for (int i = 0; i < diff; i++) {
            output[i] = t.element;
            if (i != diff - 1) {
                t = t.next;
            }
        }
        if (f == head) {
            t.next.prev = null;
            head = t.next;
        } else if (t == tail) {
            f.prev.next = null;
            tail = f.prev;
        } else {
            f.prev.next = t.next;
            t.next.prev = f.prev;
        }
        size -= diff;
        return output;
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
        Node<E> cur = findNode(index);
        E e = cur.element;
        cur.element = newElement;
        return e;
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
        return tail.element;
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
        return findNode(index).element;
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
     * Retrieves the number of times {@code element} occurs in the {@code List}.
     * If the element does not exist, then this method will return {@code 0}.
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the {@code List}
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
     * Retrieves the index of the first occurrence of {@code element} in the
     * {@code List}.
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
     * {@code List}. This means that the index returned will be the
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
     * Returns an array containing the elements of the {@code List} in the order
     * they are stored.
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
     * Clears the {@code List} such that it is empty and ready to be used again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
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
    private class DoublyLinkedListIterator implements Iterator<E> {

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
         * Constructor. Initializes the iterator to start at the beginning of
         * the {@code LinkedList}.
         */
        public DoublyLinkedListIterator() {
            prev = null;
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
                prev.prev.next = cur;
                cur.prev = prev.prev;
                prev = null;
            }
            size--;
        }
    }

    /**
     * A private helper method used to locate a starting node for the update
     * methods in this class.
     *
     * @param index the index of the node to be looked for
     * @return the node at {@code index}
     */
    private Node<E> findNode(int index) {
        Node<E> cur;
        if (size - index < size / 2) {
            cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
        } else {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }
        return cur;
    }

}
