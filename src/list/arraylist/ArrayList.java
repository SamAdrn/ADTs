package list.arraylist;

import list.List;

/**
 * This is the root interface of the {@code ArrayList} hierarchy. The
 * {@code ArrayList} is a data structure that stores a group of objects
 * together in an array. However, unlike an array, an {@code ArrayList} is
 * resizeable.
 *
 * <p> Although resizeable, an {@code ArrayList} requires that elements be
 * manually shifted accordingly when performing insertion or removal in the
 * middle of the array. Despite this trade-off, arrays are very efficient when
 * it comes to retrieving elements anywhere in the list.
 *
 * <p> The {@code ArrayList} permits all elements, including {@code null}
 * and duplicates, to be stored within the object. However, due to the fact that
 * it allows storing {@code null} objects, it becomes a mystery for certain
 * methods whether a {@code null} return value indicates that it is the
 * element returned from the list, or the element {@code null} does not
 * exist in the list. To ensure, users are suggested to use the  {@link
 * #contains(Object)} method.
 *
 * <p> All {@code ArrayList} objects should implement the {@link Iterable}
 * interface and provide an {@link java.util.Iterator Iterator} to allow looping
 * through the collection of objects, and to provide a for-each syntax.
 *
 * <p> Keep in mind that an {@code ArrayList} does not expose the capacity
 * of the array it is using, but rather the number of elements stored in it
 * instead. However, the functionality of altering the array capacity exists.
 * This is intended to be used at the programmer's convenience.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code ArrayList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see List
 * @see Iterable
 */
public interface ArrayList<E> extends List<E> {

    /**
     * Increases the capacity of the array being used by the
     * {@code ArrayList} to be able to store {@code n} number of
     * elements specified by {@code newSize}.
     *
     * <p> Note that this method does not offer the functionality to reduce the
     * capacity of the array.
     *
     * @param newSize the new and bigger capacity for the array
     * @return {@code true} to indicate that a change has been made to the
     * capacity of the array
     * @since 1.1
     */
    boolean ensureCapacity(int newSize);

    /**
     * Trims the capacity of the current array being used by the
     * {@code ArrayList} to remove excessive and unnecessary space.
     *
     * @since 1.1
     */
    void trimToSize();

}
