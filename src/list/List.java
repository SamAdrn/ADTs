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
     * Appends {@code element} to the end of the {@code List}.
     *
     * @param element the element to be added to the end of the list
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     */
    boolean add(E element);

    /**
     * Inserts {@code element} to a position in the {@code List} specified by
     * {@code index}.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     */
    boolean add(int index, E element);

    /**
     * Appends a {@code Collection} of elements to the end of the {@code List}.
     *
     * @param c a {@code Collection} containing the elements to be added
     * @see Collection
     * @since 1.1
     */
    void addAll(Collection<? extends E> c);

    /**
     * Inserts a {@code Collection} of elements to a position in the
     * {@code List} specified by {@code index}.
     *
     * @param index the index position where the {@code Collection} of
     *              elements should be inserted
     * @param c     the {@code Collection} containing elements to be inserted
     * @see Collection
     * @since 1.1
     */
    void addAll(int index, Collection<? extends E> c);

    /**
     * Removes the element at a position in the {@code List} specified by
     * {@code index}.
     *
     * @param index the index position of the element to be removed
     * @return the element that was removed from the list
     * @since 1.1
     */
    E remove(int index);

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
    E[] removeRange(int from, int to);

    /**
     * Replaces the element at the position specified by {@code index} with
     * {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return the element that had just been replaced
     * @since 1.1
     */
    E set(int index, E newElement);

    /**
     * Retrieves the element at the position specified by {@code index}.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @since 1.1
     */
    E get(int index);

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
    E getNthOccurrence(E element, int n);

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
    int getNthOccurrenceIndex(E element, int n);

    /**
     * Retrieves the number of times {@code element} occurs in the {@code List}.
     * If the element does not exist, then this method will return {@code 0}.
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the {@code List}
     * @since 1.1
     */
    int getOccurrences(E element);

    /**
     * Indicates whether {@code element} exists within the {@code List}.
     *
     * @param element the element to be searched for
     * @return {@code true} if {@code element} exists in the
     * {@code List}
     * @since 1.1
     */
    boolean contains(E element);

    /**
     * Retrieves the index of the first occurrence of {@code element} in the
     * {@code List}.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    int indexOf(E element);

    /**
     * Retrieves the index of the last occurrence of {@code element} in the
     * {@code List}. This means that the index returned will be the
     * position of {@code element} furthest away from index {@code 0}.
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of {@code element}
     * @since 1.1
     */
    int lastIndexOf(E element);

    /**
     * Returns an array containing the elements of the {@code List} in the order
     * they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    E[] toArray();

    /**
     * Clears the {@code List} such that it is empty and ready to be used again.
     *
     * @since 1.1
     */
    void clear();

    /**
     * Returns the number of elements currently stored in the {@code List}.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    int size();

    /**
     * Indicates whether the {@code List} is empty (not storing any elements).
     *
     * @return {@code true} if the {@code List} is empty
     * @since 1.1
     */
    boolean isEmpty();

}
