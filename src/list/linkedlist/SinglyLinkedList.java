package list.linkedlist;

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
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code LinkedList} would store.
 * @see LinkedList
 * @see AbstractLinkedList
 * @version 1.1
 */
public class SinglyLinkedList<E> extends AbstractLinkedList<E> {

    /**
     * Inserts <code>element</code> to a position in the <code>LinkedList</code>
     * specified by <code>index</code>.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     */
    @Override
    public boolean add(int index, E element) {
        return false;
    }

    /**
     * Removes the element at a position in the <code>LinkedList</code>
     * specified by <code>index</code>.
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
     * <code>from</code>, inclusive, and <code>to</code>, inclusive. If
     * {@code (from == to)}, then this method simply removes the element
     * specified at that index.
     *
     * @param from the index of the first element to be removed
     * @param to   the index of the last element to be removed
     * @return an array of elements that were removed from the
     * <code>LinkedList</code>
     * @since 1.1
     */
    @Override
    public E[] removeRange(int from, int to) {
        return null;
    }

    /**
     * Replaces the element at the position specified by <code>index</code>
     * with <code>newElement</code>.
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
     * Retrieves the element at the position specified by <code>index</code>.
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
     * Retrieves the <code>n</code>th occurrence of <code>element</code> within
     * the <code>LinkedList</code>. If there is less than <code>n</code>
     * occurrences of the specified element, then this method will return
     * <code>null</code>.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning
     * @return the <code>n</code>th occurrence of <code>element</code>
     * @since 1.1
     */
    @Override
    public E getNthOccurrence(E element, int n) {
        return null;
    }

    /**
     * Retrieves the index of the <code>n</code>th occurrence of
     * <code>element</code> within the <code>LinkedList</code>. If there is less
     * than <code>n</code> occurrences of the specified element, then this
     * method will return <code>-1</code>.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning the
     *                index
     * @return the index of the <code>n</code>th occurrence of
     * <code>element</code>
     * @since 1.1
     */
    @Override
    public int getNthOccurrenceIndex(E element, int n) {
        return 0;
    }

    /**
     * Retrieves the number of times <code>element</code> occurs in the
     * <code>LinkedList</code>. If the element does not exist, then this method
     * will return <code>0</code>.
     *
     * @param element the element to be searched for
     * @return the number of times <code>element</code> occurs in the
     * <code>List</code>
     * @since 1.1
     */
    @Override
    public int getOccurrences(E element) {
        return 0;
    }

    /**
     * Retrieves the index of the first occurrence of <code>element</code> in
     * the <code>LinkedList</code>.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of <code>element</code>
     * @since 1.1
     */
    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * Retrieves the index of the last occurrence of <code>element</code> in the
     * <code>LinkedList</code>. This means that the index returned will be the
     * position of <code>element</code> furthest away from index <code>0</code>.
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of <code>element</code>
     * @since 1.1
     */
    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    /**
     * Returns an array containing the elements of the <code>LinkedList</code>
     * in the order they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    @Override
    public E[] toArray() {
        return null;
    }
}
