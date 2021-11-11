package list;

import java.util.Collection;

/**
 * This is the root interface of the {@code List} hierarchy.
 * <br><br>
 * {@code List}s are data structures that store an ordered collection of
 * objects in which the user has precise control over where an object
 * should be inserted. Elements can be accessed by their integer index, which
 * represents their position in the list starting from {@code 0}. Furthermore,
 * {@code List}s allow various mutations to how elements are being stored, and
 * it is up to the user how these methods are to be implemented.
 * <br><br>
 * {@code List}s also extend the {@link Iterable} interface to allow iteration
 * of elements through an {@link java.util.Iterator Iterator}. The iterator
 * will also be defined by the user.
 *
 * @param <E> a generic type parameter to determine the type of elements in the
 *            list
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see Iterable
 * @see java.util.Iterator Iterator
 */
public interface List<E> extends Iterable<E> {

    /**
     * Appends <code>element</code> to the end of the <code>List</code>.
     *
     * @param element the element to be added to the end of the list
     * @return true to indicate a change has been made to the list
     * @since 1.1
     */
    boolean add(E element);

    /**
     * Inserts <code>element</code> to a position in the <code>List</code>
     * specified by <code>index</code>.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return true to indicate a change has been made to the list
     * @since 1.1
     */
    boolean add(int index, E element);

    /**
     * Appends a <code>Collection</code> of elements to the end of the
     * <code>List</code>.
     *
     * @param c a <code>Collection</code> containing the elements to be added
     * @see Collection
     * @since 1.1
     */
    void addAll(Collection<? extends E> c);

    /**
     * Inserts a <code>Collection</code> of elements to a position in the
     * <code>List</code> specified by <code>index</code>.
     *
     * @param index the index position where the <code>Collection</code> of
     *              elements should be inserted
     * @param c     the <code>Collection</code> containing elements to be inserted
     * @see Collection
     * @since 1.1
     */
    void addAll(int index, Collection<? extends E> c);

    /**
     * Removes the element at a position in the <code>List</code>
     * specified by <code>index</code>.
     *
     * @param index the index position of the element to be removed
     * @return the element that was removed from the list
     * @since 1.1
     */
    E remove(int index);

    /**
     * Removes a set of elements between index positions specified by
     * <code>from</code>, inclusive, and <code>to</code>, inclusive. If
     * {@code (from == to)}, then this method simply removes the element
     * specified at that index.
     *
     * @param from the index of the first element to be removed
     * @param to   the index of the last element to be removed
     * @return an array of elements that were removed from the
     * <code>List</code>
     * @since 1.1
     */
    E[] removeRange(int from, int to);

    /**
     * Replaces the element at the position specified by <code>index</code>
     * with <code>newElement</code>.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return the element that had just been replaced
     * @since 1.1
     */
    E set(int index, E newElement);

    /**
     * Retrieves the element at the position specified by <code>index</code>.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @since 1.1
     */
    E get(int index);

    /**
     * Retrieves the <code>n</code>th occurrence of <code>element</code> within
     * the <code>List</code>. If there is less than <code>n</code>
     * occurrences of the specified element, then this method will return
     * <code>null</code>.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning
     * @return the <code>n</code>th occurrence of <code>element</code>
     * @since 1.1
     */
    E getNthOccurrence(E element, int n);

    /**
     * Retrieves the index of the <code>n</code>th occurrence of
     * <code>element</code> within the <code>List</code>. If there is less
     * than <code>n</code> occurrences of the specified element, then this
     * method will return <code>-1</code>.
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning the index
     * @return the index of the <code>n</code>th occurrence of
     * <code>element</code>
     * @since 1.1
     */
    int getNthOccurrenceIndex(E element, int n);

    /**
     * Retrieves the number of times <code>element</code> occurs in the
     * <code>List</code>. If the element does not exist, then this method
     * will return <code>0</code>.
     *
     * @param element the element to be searched for
     * @return the number of times <code>element</code> occurs in the
     * <code>List</code>
     * @since 1.1
     */
    int getOccurrences(E element);

    /**
     * Indicates whether <code>element</code> exists within the
     * <code>List</code>.
     *
     * @param element the element to be searched for
     * @return <code>true</code> if <code>element</code> exists in the
     * <code>List</code>
     * @since 1.1
     */
    boolean contains(E element);

    /**
     * Retrieves the index of the first occurrence of <code>element</code> in
     * the <code>List</code>.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of <code>element</code>
     * @since 1.1
     */
    int indexOf(E element);

    /**
     * Retrieves the index of the last occurrence of <code>element</code> in the
     * <code>List</code>. This means that the index returned will be the
     * position of <code>element</code> furthest away from index <code>0</code>.
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of <code>element</code>
     * @since 1.1
     */
    int lastIndexOf(E element);

    /**
     * Returns an array containing the elements of the <code>List</code>
     * in the order they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    E[] toArray();

    /**
     * Clears the <code>List</code> such that it is empty and ready to be
     * used again.
     *
     * @since 1.1
     */
    void clear();

    /**
     * Returns the number of elements currently stored in the
     * <code>List</code>.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    int size();

    /**
     * Indicates whether the <code>List</code> is empty (not storing any
     * elements).
     *
     * @return <code>true</code> if the <code>List</code> is empty
     * @since 1.1
     */
    boolean isEmpty();

}
