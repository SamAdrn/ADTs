package stack;

import java.util.EmptyStackException;
import java.util.Objects;

/**
 * This class is an implementation of the {@link Stack} interface.
 * <br><br>
 * The {code DefaultStack} class uses an array to represent a stack. Every time
 * an element is pushed onto the stack, the element will be added to the slot
 * after the last element of the array. Popping and retrieving the top of the
 * stack works in a similar fashion.
 * <br><br>
 * All methods run {@code O(1)} time, similar to the time complexity of updating
 * an array. Therefore, all methods run in {@code O(1)} time, with the exception
 * of the {@link #search(Object)} method, which depends on the position of the
 * element to be searched. However, an array-based representation limits the
 * capacity of elements that can be added to the stack. In the current
 * implementation, the capacity of the array is set to {@code 1000}.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Stack} would store.
 * @version 1.1
 * @see Stack
 */
@SuppressWarnings({"unchecked"})
public class ArrayStack<E> implements Stack<E> {

    /**
     * The default maximum capacity the array can handle.
     */
    private final int MAXIMUM_CAPACITY = 1000;

    /**
     * An array used to represent the stack.
     */
    private E[] stack;

    /**
     * A field to keep the number of elements in the stack.
     */
    private int size;

    /**
     * Default Constructor. Initializes the array to be used as the stack.
     */
    public ArrayStack() {
        stack = (E[]) new Object[MAXIMUM_CAPACITY];
    }

    /**
     * Pushes the element {@code e} to the top of the stack.
     *
     * @param e the element to be pushed into the stack
     * @throws IllegalStateException if the array being used as the stack is at
     *                               full capacity
     * @since 1.1
     */
    @Override
    public void push(E e) {
        if (stack.length == size) {
            throw new IllegalStateException("array is fully filled");
        }
        stack[size] = e;
        size++;
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
        E e = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return e;
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
        return stack[size - 1];
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     * @since 1.1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Indicates whether the stack has no elements currently stored in it.
     *
     * @return {@code true} if the stack is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retrieves the distance of element {@code e} from the top of the stack.
     * <br><br>
     * The method will return {@code -1} if the stack is empty, or {@code e}
     * does not exist.
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(stack[i], e)) {
                return size - i - 1;
            }
        }
        return -1;
    }

    /**
     * Clears the {@code Stack} such that it is empty and ready to be
     * used again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        stack = (E[]) new Object[MAXIMUM_CAPACITY];
        size = 0;
    }
}
