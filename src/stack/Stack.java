package stack;

import java.util.EmptyStackException;

/**
 * This interface represents the root interface of all {@code Stack} objects.
 *
 * <p> A stack is a type of data structure that follows the FIFO (first-in
 * first-out) principle. A great analogy of a stack would be a stack of plates,
 * in which elements can only be inserted to the top-most position of the
 * stack, and only the element at the top-most position can be removed.
 *
 * <p> Stacks also allows {@code null} elements. The stack's
 * {@link #search(Object)} method relies on the {@link
 * java.util.Objects#equals(Object) Objects.equals(a, b)} method.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Stack} would store.
 *
 * @version 1.1
 */
public interface Stack<E> {

    /**
     * Pushes the element {@code e} to the top of the stack.
     *
     * @param e the element to be pushed into the stack
     * @since 1.1
     */
    void push(E e);

    /**
     * Retrieves and removes the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    E pop() throws EmptyStackException;

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    E peek();

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     * @since 1.1
     */
    int size();

    /**
     * Indicates whether the stack has no elements currently stored in it.
     *
     * @return {@code true} if the stack is empty
     * @since 1.1
     */
    boolean isEmpty();

    /**
     * Retrieves the distance of element {@code e} from the top of the stack.
     * 
     * <p> The method will return {@code -1} if the stack is empty, or {@code e}
     * does not exist.
     *
     * @param e the element to be searched
     * @return the distance of {@code e} from the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    int search(E e) throws EmptyStackException;

    /**
     * Clears the {@code Stack} such that it is empty and ready to be used
     * again.
     *
     * @since 1.1
     */
    void clear();

}
