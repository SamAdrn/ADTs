package list.arraylist;

/**
 * This class is an implementation of the {@link ArrayList} interface.
 *
 * <p> This {@code ArrayList} is intended to be used for objects that implement
 * the {@link Comparable} interface, providing means for two object to compare
 * themselves with one another through the {@link Comparable#compareTo(Object)
 * compareTo(Object)} method.
 *
 * <p> he insertion order in a {@code ComparableArrayList} is maintained until a
 * change is made by the user through the {@link #set(int, Comparable)} method.
 * For example, if the {@code Collection} of elements : {@code [a1, a2, a3, ...,
 * an]} is inserted to the {@code ComparableArrayList}, it will store it as
 * <blockquote>{@code [a1, a2, a3, ..., an]}<br>where {@code n} is the number of
 * elements inside the {@code Collection}.</blockquote>
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code ArrayList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see ArrayList
 * @see AbstractArrayList
 * @see Comparable
 */
@SuppressWarnings({"unchecked"})
public class ComparableArrayList<E extends Comparable<E>> extends
        AbstractArrayList<E> {

    /**
     * Default Constructor. Initializes a starting array of capacity {@code 10}.
     */
    public ComparableArrayList() {
        this(10);
    }

    /**
     * Constructor. Initializes a starting array with a capacity specified
     * in {@code minCapacity}.
     *
     * @param minCapacity the minimum capacity of the array to be initialized
     */
    public ComparableArrayList(int minCapacity) {
        arr = (E[]) new Comparable[minCapacity];
        size = 0;
    }

    /**
     * Copy Constructor. Takes in another {@code ComparableArrayList} object
     * and creates a deep copy of it.
     *
     * @param cal the other {@code ComparableArrayList} object to be copied
     */
    public ComparableArrayList(ComparableArrayList<E> cal) {
        this.size = cal.size();
        arr = (E[]) new Comparable[this.size];
        for (int i = 0; i < this.size; i++) {
            arr[i] = cal.get(i);
        }
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
     * {@code ArrayList}
     * @throws IndexOutOfBoundsException if invalid indices were specified
     * @since 1.1
     */
    @Override
    public E[] removeRange(int from, int to) {
        if (from < 0 || to < 0 || from >= size || to >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        E[] output = (E[]) new Comparable[to - from + 1];
        for (int i = from; i <= to; i++) {
            output[i - from] = arr[i];
            arr[i] = null;
        }
        int diff = to - from + 1;
        for (int i = from; i < size; i++) {
            arr[i] = arr[i + diff];
        }
        size -= diff;
        return output;
    }

    /**
     * Retrieves the {@code n}th occurrence of {@code element} within the
     * {@code ArrayList}. If there is less than {@code n} occurrences of the
     * specified element, then this method will return {@code null}.
     *
     * <p> Equal elements are tested using the following logic
     * {@code (o == null ? e == null : o.compareTo(e))}
     *
     * @param element the element to be searched for
     * @param n       the number of element occurrences before returning
     * @return the {@code n}th occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public E getNthOccurrence(E element, int n) {
        if (n > 0) {
            for (int i = 0; i < size; i++) {
                if (element == null ? arr[i] == null :
                        arr[i].compareTo(element) == 0) {
                    n--;
                    if (n == 0) {
                        return arr[i];
                    }
                }
            }
        }
        return null;
    }

    /**
     * Retrieves the index of the {@code n}th occurrence of {@code element}
     * within the {@code ArrayList}. If there is less than {@code n} occurrences
     * of the specified element, then this method will return {@code -1}.
     *
     * <p> Equal elements are tested using the following logic
     * {@code (o == null ? e == null : o.compareTo(e))}
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
        if (n > 0) {
            for (int i = 0; i < size; i++) {
                if (element == null ? arr[i] == null :
                        arr[i].compareTo(element) == 0) {
                    n--;
                    if (n == 0) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Retrieves the number of times {@code element} occurs in the
     * {@code ArrayList}. If the element does not exist, then this method
     * will return {@code 0}.
     *
     * <p> Equal elements are tested using the following logic
     * {@code (o == null ? e == null : o.compareTo(e))}
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the
     * {@code ArrayList}
     * @since 1.1
     */
    @Override
    public int getOccurrences(E element) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (element == null ? arr[i] == null :
                    arr[i].compareTo(element) == 0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Retrieves the index of the first occurrence of {@code element} in
     * the {@code ArrayList}.
     *
     * <p> Equal elements are tested using the following logic
     * {@code (o == null ? e == null : o.compareTo(e))}
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? arr[i] == null :
                    arr[i].compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retrieves the index of the last occurrence of {@code element} in the
     * {@code ArrayList}. This means that the index returned will be the
     * position of {@code element} furthest away from index {@code 0}.
     *
     * <p> Equal elements are tested using the following logic
     * {@code (o == null ? e == null : o.compareTo(e))}
     *
     * @param element the element to be searched for
     * @return the index of the last occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int lastIndexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (element == null ? arr[i] == null :
                    arr[i].compareTo(element) == 0) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns an array containing the elements of the {@code ArrayList} in the
     * order they are stored.
     *
     * @return an array containing all the elements
     * @since 1.1
     */
    @Override
    public E[] toArray() {
        if (size == 0) {
            return null;
        }
        E[] output = (E[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            output[i] = arr[i];
        }
        return output;
    }

    /**
     * Clears the {@code ArrayList} such that it is empty and ready to be used
     * again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        arr = (E[]) new Comparable[10];
        size = 0;
    }

    /**
     * Increases the capacity of the array being used by the {@code ArrayList}
     * to be able to store {@code n} number of elements specified by
     * {@code newSize}.
     *
     * <p> Note that this method does not offer the functionality to reduce the
     * capacity of the array.
     *
     * @param newSize the new and bigger capacity for the array
     * @return {@code true} to indicate that a change has been made to the
     * capacity of the array
     * @since 1.1
     */
    @Override
    public boolean ensureCapacity(int newSize) {
        if (newSize > -1) {
            if (size == 0) {
                arr = (E[]) new Comparable[newSize];
            } else {
                E[] temp = (E[]) new Comparable[newSize];
                for (int i = 0; i < size; i++) {
                    temp[i] = arr[i];
                }
                arr = temp;
            }
            return true;
        }
        return false;
    }

    /**
     * Trims the capacity of the current array being used by the
     * {@code ArrayList} to remove excessive and unnecessary space.
     *
     * @since 1.1
     */
    @Override
    public void trimToSize() {
        E[] temp = (E[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
