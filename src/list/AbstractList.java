package list;

/**
 * This abstract class provides a skeletal implementation of the {@link List}
 * interface. Some methods that share similar behaviors across all
 * {@code Lists}s are implemented here, along with a protected {@code int}
 * field called {@link #size} to keep track on the number elements the
 * {@code List} is storing.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> a generic type parameter to determine the type of elements in the
 *           list
 * @see List
 * @version 1.1
 */
public abstract class AbstractList<E> implements List<E>{

    /**
     * A field to keep track of the number of elements currently stored in the
     * <code>List</code>
     */
    protected int size;

    /**
     * Indicates whether <code>element</code> exists within the
     * <code>List</code>.
     *
     * @param element the element to be searched for
     * @return <code>true</code> if <code>element</code> exists in the
     * <code>List</code>
     * @since 1.1
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    /**
     * Returns the number of elements currently stored in the
     * <code>List</code>.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Indicates whether the <code>List</code> is empty (not storing any
     * elements).
     *
     * @return <code>true</code> if the <code>List</code> is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
