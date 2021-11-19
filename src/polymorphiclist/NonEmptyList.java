package polymorphiclist;

/**
 * This class represents a non-empty {@link PolymorphicList} node.
 *
 * <p> The definition of non-empty simply means that the node has an existing
 * element currently stored within it.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code PolymorphicList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see PolymorphicList
 * @see EmptyList
 */
public class NonEmptyList<E extends Comparable<E>>
        implements PolymorphicList<E> {

    /**
     * Stores the node's element.
     */
    private E element;

    /**
     * Stores a reference to the next {@link PolymorphicList} node
     */
    private PolymorphicList<E> next;

    /**
     * Constructor. Initializes a {@code NonEmptyList} node with the
     * specified element and a next node.
     *
     * @param e the element to be stored within the node
     * @param n the reference to the next node
     */
    public NonEmptyList(E e, PolymorphicList<E> n) {
        element = e;
        next = n;
    }

    /**
     * Appends {@code element} to the end of the {@code PolymorphicList}.
     *
     * @param element the element to be added to the end of the polymorphic list
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public NonEmptyList<E> add(E element) {
        // calls using max value of Integer to ensure the element is appended to
        // the end of the list
        return add(element, Integer.MAX_VALUE);
    }

    /**
     * Inserts {@code element} to a position in the {@code PolymorphicList}
     * specified by {@code index}.
     *
     * @param element the element to be inserted
     * @param index   the index position where the element should be inserted
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public NonEmptyList<E> add(E element, int index) {
        if (index == 0) {
            return new NonEmptyList<>(element, this);
        } else {
            next = next.add(element, index - 1);
        }
        return this;
    }

    /**
     * Removes the first occurrence of element from the {@code PolymorphicList}.
     *
     * @param element the element to be removed
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public PolymorphicList<E> remove(E element) {
        if (this.element.compareTo(element) == 0) {
            return next;
        } else {
            next = next.remove(element);
        }
        return this;
    }

    /**
     * Removes the element at a position in the {@code PolymorphicList}
     * specified by {@code index}.
     *
     * <p> If the {@code index} is greater than the number of elements in the
     * polymorphic list, then the last element would be removed.
     *
     * @param index the index position of the element to be removed
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public PolymorphicList<E> remove(int index) {
        if (index == 0) {
            return next;
        } else {
            try {
                next = next.remove(index - 1);
            } catch (EmptyListException ele) {
                return EmptyList.getInstance();
            }
        }
        return this;
    }

    /**
     * Replaces the element at the position specified by {@code index}
     * with {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public PolymorphicList<E> set(int index, E newElement) {
        if (index == 0) {
            element = newElement;
        } else {
            next = next.set(index - 1, newElement);
        }
        return this;
    }

    /**
     * Retrieves the element at the position specified by {@code index}.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @since 1.1
     */
    @Override
    public E get(int index) {
        if (index == 0) {
            return element;
        } else {
            return next.get(index - 1);
        }
    }

    /**
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    @Override
    public E head() {
        return get(0);
    }

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    @Override
    public E tail() {
        try {
            return next.tail();
        } catch (EmptyListException ele) {
            return element;
        }
    }

    /**
     * Retrieves the number of times {@code element} occurs in the
     * {@code PolymorphicList}. If the element does not exist, then this method
     * will return {@code 0}.
     *
     * @param element the element to be searched for
     * @return the number of times {@code element} occurs in the
     * {@code PolymorphicList}
     * @since 1.1
     */
    @Override
    public int getOccurrences(E element) {
        if (this.element.compareTo(element) == 0) {
            return next.getOccurrences(element) + 1;
        }
        return next.getOccurrences(element);
    }

    /**
     * Retrieves the index of the first occurrence of {@code element} in
     * the {@code PolymorphicList}.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    @Override
    public int indexOf(E element) {
        int index = 0;
        if (this.element.compareTo(element) == 0) {
            return index;
        }
        return next.indexOf(element) + 1;
    }

    /**
     * Indicates whether {@code element} exists within the
     * {@code PolymorphicList}.
     *
     * @param element the element to be searched for
     * @return {@code true} if {@code element} exists in the
     * {@code PolymorphicList}
     * @since 1.1
     */
    @Override
    public boolean contains(E element) {
        if (this.element.compareTo(element) == 0) {
            return true;
        } else {
            return next.contains(element);
        }
    }

    /**
     * Indicates whether the {@code PolymorphicList} is empty (not storing any
     * elements).
     *
     * @return {@code true} if the {@code PolymorphicList} is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of elements currently stored in the
     * {@code PolymorphicList}.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    @Override
    public int size() {
        int size = 1;
        size += next.size();
        return size;
    }

    /**
     * Clears the {@code PolymorphicList} such that it is empty and ready to be
     * used again.
     *
     * @return an {@link EmptyList} node
     * @since 1.1
     */
    @Override
    public EmptyList<E> clear() {
        return EmptyList.getInstance();
    }

    /**
     * Provides a {@code String} representation to the whole
     * {@code PolymorphicList} object, such that it prints out all the elements
     * current stored in it using the following format:
     * <blockquote>{@code a1 a2 a3 a4 ... an}</blockquote>
     *
     * @return a {@code String} consisting of all the elements currently
     * stored in the {@code PolymorphicList}
     */
    @Override
    public String toString() {
        return (element + " " + next.toString()).trim();
    }
}
