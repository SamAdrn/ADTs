package polymorphiclist;

/**
 * This class represents the root interface of all {@code PolymorphicList}
 * objects.
 *
 * <p> A polymorphic polymorphic list is a type of linked polymorphic list that
 * relies on two different nodes, one with an element and one without.
 * Furthermore, a polymorphic polymorphic list is instantiated with a
 * {@code PolymorphicList} node instead of a whole
 * {@link list.linkedlist.LinkedList LinkedList} structure. These types of lists
 * rely on recursion to perform its operations, since traversals take place
 * across different instances of their nodes.
 *
 * <p> Polymorphic lists also support indexing. However, since it does not
 * maintain a {@code size} variable amongst its nodes, indices greater than the
 * number of elements the polymorphic list contains is valid. For example,
 * iterating the polymorphic list to index {@code 10} with only {@code 5}
 * elements will simply stop the iteration at the final node, just right before
 * an {@link EmptyList} node. The only exception is that negative indices will
 * throw an {@link IndexOutOfBoundsException}.
 *
 * <p> All update methods in {@code PolymorphicList} returns a reference to the
 * head node to ensure the representation of the whole list is maintained. To
 * perform updates, the method's return value must be reassigned to itself in
 * order to make modifications to the list. For example:
 * <blockquote>{@code polyList = polyList.add(10)}</blockquote>
 *
 * <p> To instantiate an empty polymorphic list, it's best to call the
 * {@link EmptyList#getInstance()} method instead of adding an {@code null}
 * element. For example: <blockquote>{@code PolymorphicList<E> polyList =
 * EmptyList.getInstance()}</blockquote>
 *
 * <p> The class is not considered as a {@link list.List List} since it requires
 * a different set of methods and return values. Furthermore, a
 * {@code PolymorphicList} object should be differentiated from a
 * {@code PolymorphicList}.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code PolymorphicList} would store.
 *
 * @version 1.1
 * @see NonEmptyList
 * @see EmptyList
 */
public interface PolymorphicList<E extends Comparable<E>> {

    /**
     * Appends {@code element} to the end of the {@code PolymorphicList}.
     *
     * @param element the element to be added to the end of the polymorphic list
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    NonEmptyList<E> add(E element);

    /**
     * Inserts {@code element} to a position in the {@code PolymorphicList}
     * specified by {@code index}.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    NonEmptyList<E> add(E element, int index);

    /**
     * Removes the first occurrence of element from the {@code PolymorphicList}.
     *
     * @param element the element to be removed
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    PolymorphicList<E> remove(E element);

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
    PolymorphicList<E> remove(int index) throws EmptyListException;

    /**
     * Replaces the element at the position specified by {@code index}
     * with {@code newElement}.
     *
     * @param index      the index position of the element to be replaced
     * @param newElement the new element to replace the old element
     * @return a reference to the head node of the polymorphic list
     * @since 1.1
     */
    PolymorphicList<E> set(int index, E newElement);

    /**
     * Retrieves the element at the position specified by {@code index}.
     *
     * @param index the index position of the element to be retrieved
     * @return the element stored at the specified position
     * @since 1.1
     */
    E get(int index);

    /**
     * Retrieves the element stored at the head of the {@code LinkedList}.
     *
     * @return the element being stored at the head
     */
    E head();

    /**
     * Retrieves the element stored at the tail of the {@code LinkedList}.
     *
     * @return the element being stored at the tail
     */
    E tail() throws EmptyListException;

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
    int getOccurrences(E element);

    /**
     * Retrieves the index of the first occurrence of {@code element} in
     * the {@code PolymorphicList}.
     *
     * @param element the element to be searched for
     * @return the index of the first occurrence of {@code element}
     * @since 1.1
     */
    int indexOf(E element);

    /**
     * Indicates whether {@code element} exists within the
     * {@code PolymorphicList}.
     *
     * @param element the element to be searched for
     * @return {@code true} if {@code element} exists in the
     * {@code PolymorphicList}
     * @since 1.1
     */
    boolean contains(E element);

    /**
     * Indicates whether the {@code PolymorphicList} is empty (not storing any
     * elements).
     *
     * @return {@code true} if the {@code PolymorphicList} is empty
     * @since 1.1
     */
    boolean isEmpty();

    /**
     * Returns the number of elements currently stored in the
     * {@code PolymorphicList}.
     *
     * @return the number of elements currently stored
     * @since 1.1
     */
    int size();

    /**
     * Clears the {@code PolymorphicList} such that it is empty and ready to be
     * used again.
     *
     * @return an {@link EmptyList} node
     * @since 1.1
     */
    EmptyList<E> clear();

}
