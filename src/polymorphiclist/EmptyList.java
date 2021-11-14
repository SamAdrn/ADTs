package polymorphiclist;

/**
 * This class represents a empty {@link PolymorphicList} node.
 * <br><br>
 * The definition of empty simply means that the node does not have an existing
 * element currently stored within it. Use this class to represent the end of 
 * the list.
 * <br><br>
 * To ensure that no {@link NonEmptyList} nodes are instantiating copies of
 * this class, it is implemented as a singleton, that can be accessed through
 * the {@link #getInstance()} method.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code PolymorphicList} would store.
 *
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see PolymorphicList
 * @see NonEmptyList
 * @see EmptyListException
 */
@SuppressWarnings({"unchecked"})
public class EmptyList<E extends Comparable<E>> implements PolymorphicList<E> {

    /**
     * The only instance of an {@code EmptyList}.
     */
    private static final EmptyList single = new EmptyList<>();

    /**
     * Retrieves the only instance of an {@code EmptyList} object.
     *
     * @return the only instance of {@code EmptyList}
     */
    public static EmptyList getInstance() {
        return single;
    }

    /**
     * Private Constructor. Prevents any other instance of {@code EmptyList} to
     * be created.
     */
    private EmptyList() { }


    /**
     * Appends {@code element} to the end of the {@code PolymorphicList}.
     *
     * @param element the element to be added to the end of the polymorphic list
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public NonEmptyList<E> add(E element) {
        return add(element, 0);
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
        return new NonEmptyList<E>(element, getInstance());
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
        return this;
    }

    /**
     * Removes the element at a position in the {@code PolymorphicList}
     * specified by {@code index}.
     * <br><br>
     * If the {@code index} is greater than the number of elements in the
     * polymorphic list, then the last element would be removed.
     *
     * @param index the index position of the element to be removed
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    @Override
    public PolymorphicList<E> remove(int index) throws EmptyListException {
        throw new EmptyListException();
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
        return null;
    }

    /**
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    @Override
    public E head() {
        return null;
    }

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    @Override
    public E tail() {
        return null;
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
        return 0;
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
        return 0;
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
        return false;
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
        return 0;
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
        return this;
    }

}
