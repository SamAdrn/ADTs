package list.arraylist;

import list.AbstractList;

import java.util.Iterator;

/**
 * This abstract class provides a skeletal implementation to the
 * {@link ArrayList} interface, outlining the methods and fields that would
 * have similar behaviors across various abstractions.
 * <br><br>
 * The array to be used by the {@code ArrayList} will be a protected field
 * {@link #arr} in this class. However, implementations that require array
 * copying will not be implemented here, due to complications with casting for
 * different generic types {@link E}. It is recommended that every abstraction
 * implement these methods their own respective way.
 * <br><br>
 * There are also no constructors provided in this class for the same reason
 * described above.
 * <br><br>
 * All {@code add} methods relies on the {@link #ensureCapacity(int)} method to
 * automatically resize the array in accordance to the need of space, adding
 * an extra space of {@code 10}  elements everytime to the array is fully
 * filled. However, it does not remove that extra space automatically.
 * <br><br>
 * Some behaviors are already defined in the {@link AbstractList} class.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code ArrayList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see AbstractList
 * @see ArrayList
 */
public abstract class AbstractArrayList<E> extends AbstractList<E>
        implements ArrayList<E> {

    /**
     * An array storing objects of type {@link E}.
     */
    protected E[] arr;

    /**
     * Inserts {@code element} to a position in the {@code ArrayList}
     * specified by {@code index}.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return {@code true} to indicate a change has been made to the list
     * @throws IndexOutOfBoundsException if an invalid {@code index} has
     *                                   been specified
     * @since 1.1
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size >= arr.length - 1) {
            ensureCapacity(size + 10);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        return true;
    }


    /**
     * Removes the element at a position in the {@code ArrayList}
     * specified by {@code index}.
     *
     * @param index the index position of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if an invalid {@code index} has
     *                                   been specified
     * @since 1.1
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        E output = arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size] = null;
        size--;
        return output;
    }

    /**
     * Replaces the element at the position specified by {@code index}
     * with {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return the element that had just been replaced
     * @throws IndexOutOfBoundsException if an invalid {@code index} has
     *                                   been specified
     * @since 1.1
     */
    @Override
    public E set(int index, E newElement) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        E output = arr[index];
        arr[index] = newElement;
        return output;
    }

    /**
     * Retrieves the element at the position specified by {@code index}.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @throws IndexOutOfBoundsException if an invalid {@code index} has
     *                                   been specified
     * @since 1.1
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return arr[index];
    }

    /**
     * Provides a {@code String} representation to the whole
     * {@code ArrayList} object, such that it prints out all the elements
     * current stored in it using the following format:
     * <blockquote>{@code [a1 a2 a3 a4 ... an]}</blockquote>
     *
     * @return a {@code String} consisting of all the elements currently
     * stored in the {@code ArrayList}
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            str.append(arr[i]).append(" ");
        }
        return str.append(arr[size - 1]).append("]").toString();
    }

    /**
     * Returns an iterator over elements of type {@code E}. The iterator for
     * {@code ArrayList} objects is defined in the private inner class
     * {@link ArrayListIterator ArrayListIterator}.
     *
     * @return an {@code Iterator}
     * @see ArrayListIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * This private inner class provides an {@code Iterator} of type
     * {@code E}, providing the functionality of looping through the
     * elements of an {@code ArrayList}. This implementation offers support
     * for the {@link #remove()} method as well, and will not fail unless the
     * {@link #next()} method has never been called, or the element is already
     * removed. The iterator will not loop back to the beginning of the
     * {@code ArrayList} once the end has been reached, rendering it
     * unusable at that point.
     *
     * @see Iterator
     */
    private class ArrayListIterator implements Iterator<E> {

        /**
         * A reference to the index the iterator is currently pointing to.
         */
        private int currentIndex;
        /**
         * An indicator whether the element last returned has been removed
         */
        private boolean removed;

        /**
         * Constructor. Initializes the iterator to start at the beginning of
         * the {@code ArrayList}.
         */
        public ArrayListIterator() {
            currentIndex = 0;
            removed = true;
        }

        /**
         * Indicates whether the iteration has more elements.
         *
         * @return {@code true} if the {@code ArrayList} still has
         * more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E e = arr[currentIndex];
            currentIndex++;
            removed = false;
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
        public void remove() throws IllegalStateException {
            if (removed) {
                if (currentIndex == 0) {
                    throw new IllegalStateException("next() has not been " +
                            "called");
                } else {
                    throw new IllegalStateException("element has already " +
                            "been removed");
                }
            } else {
                for (int i = currentIndex - 1; i < size; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[size] = null;
                size--;
                removed = true;
            }
        }
    }
}
