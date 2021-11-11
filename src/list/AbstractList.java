package list;

public abstract class AbstractList<E> implements List<E>{

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
