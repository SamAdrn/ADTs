package list;

import java.util.Collection;

/**
 * This abstract class provides a skeletal implementation of the {@link List}
 * interface. Some methods that share similar behaviors across all
 * {@code Lists}s are implemented here, along with a protected {@code int}
 * field called {@link #size} to keep track on the number elements the
 * {@code List} is storing.
 *
 * @param <E> a generic type parameter to determine the type of elements in the
 *            list
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see List
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * A field to keep track of the number of elements currently stored in the
     * <code>List</code>
     */
    protected int size;

    /**
     * Appends <code>element</code> to the end of the <code>ArrayList</code>.
     *
     * @param element the element to be added to the end of the list
     * @return <code>true</code> to indicate a change has been made to the list
     * @since 1.1
     */
    @Override
    public boolean add(E element) {
        return add(size, element);
    }

    /**
     * Appends a <code>Collection</code> of elements to the end of the
     * <code>List</code>.
     *
     * @param c a <code>Collection</code> containing the elements to be added
     * @throws NullPointerException if the <code>Collection</code> of objects
     *                              specified is <code>null</code>
     * @see Collection
     * @since 1.1
     */
    @Override
    public void addAll(Collection<? extends E> c) {
        addAll(size, c);
    }

    /**
     * Inserts a <code>Collection</code> of elements to a position in the
     * <code>List</code> specified by <code>index</code>.
     *
     * @param index the index position where the <code>Collection</code> of
     *              elements should be inserted
     * @param c     the <code>Collection</code> containing elements to be inserted
     * @throws NullPointerException if the <code>Collection</code> of objects
     *                              specified is <code>null</code>
     * @see Collection
     * @since 1.1
     */
    @Override
    public void addAll(int index, Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Collection is null");
        }
        for (E e : c) {
            this.add(index++, e);
        }
    }

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
