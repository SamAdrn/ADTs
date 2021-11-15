package stack;

import list.linkedlist.SinglyLinkedList;

import java.util.EmptyStackException;

/**
 * This class is an implementation of the {@link Stack} interface.
 * <br><br>
 * The {code DefaultStack} class uses a {@link SinglyLinkedList} to represent
 * a stack. Every time an element is pushed onto the stack, the element will be
 * added to the {@link SinglyLinkedList#head head} of the list, in other words
 * the top of the stack. Popping and retrieving the top of the stack works in a
 * similar fashion.
 * <br><br>
 * All methods run in the best-case time complexity equivalent to the
 * {@link SinglyLinkedList} class. This is because the stack is based on the
 * head of the list, where the iteration begins. Therefore, all methods run in
 * {@code O(1)} time, with the exception of the {@link #search(Object)} method,
 * which depends on the position of the element to be searched.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Stack} would store.
 * @version 1.1
 * @see Stack
 * @see SinglyLinkedList
 */
public class LinkedStack<E> implements Stack<E> {

    /**
     * The reference to the stack
     */
    SinglyLinkedList<E> stack;

    /**
     * Default Constructor. Initializes the stack being used in this object.
     */
    public LinkedStack() {
        stack = new SinglyLinkedList<>();
    }

    /**
     * Pushes the element {@code e} to the top of the stack.
     *
     * @param e the element to be pushed into the stack
     * @since 1.1
     */
    @Override
    public void push(E e) {
        stack.add(0, e);
    }

    /**
     * Retrieves and removes the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(0);
    }

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(0);
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     * @since 1.1
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Indicates whether the stack has no elements currently stored in it.
     *
     * @return {@code true} if the stack is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Retrieves the distance of element {@code e} from the top of the stack.
     * <br><br>
     * The method will return {@code -1} if {@code e} does not exist.
     * <br><br>
     * This method uses the {@link Object#equals(Object)} method to check for
     * equivalent elements.
     *
     * @param e the element to be searched
     * @return the distance of {@code e} from the top of the stack
     * @throws EmptyStackException if the stack has no elements currently stored
     * @since 1.1
     */
    @Override
    public int search(E e) throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.indexOf(e);
    }
}
