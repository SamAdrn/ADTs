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
     * {@code List}
     */
    protected int size;

    /**
     * Appends {@code element} to the end of the {@code List}.
     *
     * @param element the element to be added to the end of the list
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     */
    @Override
    public boolean add(E element) {
        return add(size, element);
    }

    /**
     * Appends a {@code Collection} of elements to the end of the {@code List}.
     *
     * @param c a {@code Collection} containing the elements to be added
     * @throws NullPointerException if the {@code Collection} of objects
     *                              specified is {@code null}
     * @see Collection
     * @since 1.1
     */
    @Override
    public void addAll(Collection<? extends E> c) {
        addAll(size, c);
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
        if (c == null) {
            throw new NullPointerException("Collection is null");
        }
        for (E e : c) {
            this.add(index++, e);
        }
    }

    /**
     * Indicates whether {@code element} exists within the {@code List}.
     *
     * @param element the element to be searched for
     * @return {@code true} if {@code element} exists in the
     * {@code List}
     * @since 1.1
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    /**
     * Returns the number of elements currently stored in the {@code List}.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Indicates whether the {@code List} is empty (not storing any elements).
     *
     * @return {@code true} if the {@code List} is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
