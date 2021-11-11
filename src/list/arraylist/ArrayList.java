package list.arraylist;

import list.List;

/**
 * This is the root interface of the <code>ArrayList</code> hierarchy. The
 * ArrayList is a data structure that stores a group of objects together in an
 * array. However, unlike an array, an <code>ArrayList</code> is resizeable.
 * <br><br>
 * The <code>ArrayList</code> permits all elements, including <code>null</code>
 * and duplicates, to be stored within the object. However, due to the fact that
 * it allows storing <code>null</code> objects, it becomes a mystery for certain
 * methods whether a <code>null</code> return value indicates that it is the
 * element returned from the list, or the element <code>null</code> does not
 * exist in the list. To ensure, users are suggested to use the  {@link
 * #contains(Object)} method.
 * <br><br>
 * All <code>ArrayList</code> objects should implement the {@link Iterable}
 * interface and provide an {@link java.util.Iterator Iterator} to allow looping
 * through the collection of objects, and to provide a for-each syntax.
 * <br><br>
 * Keep in mind that an <code>ArrayList</code> does not expose the capacity
 * of the array it is using, but rather the number of elements stored in it
 * instead. However, the functionality of altering the array capacity exists.
 * This is intended to be used at the programmer's convenience.
 *
 * @param <E> generic type parameter determining the type of object the
 *            <code>ArrayList</code> would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see Iterable
 * @see List
 */
public interface ArrayList<E> extends List<E> {

    /**
     * Increases the capacity of the array being used by the
     * <code>ArrayList</code> to be able to store <code>n</code> number of
     * elements specified by <code>newSize</code>.
     * <br><br>
     * Note that this method does not offer the functionality to reduce the
     * capacity of the array.
     *
     * @param newSize the new and bigger capacity for the array
     * @return <code>true</code> to indicate that a change has been made to the
     * capacity of the array
     * @since 1.1
     */
    boolean ensureCapacity(int newSize);

    /**
     * Trims the capacity of the current array being used by the
     * <code>ArrayList</code> to remove excessive and unnecessary space.
     *
     * @since 1.1
     */
    void trimToSize();

}
