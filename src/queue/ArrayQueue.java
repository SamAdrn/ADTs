package queue;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class is an implementation of the {@link Queue} interface.
 * <br><br>
 * The {code ArrayQueue} class uses an array to represent a queue. It relies on
 * an arbitrary pointer that shows the index position of where the element
 * should be inserted. This is so the array can be used circularly and the
 * capacity of the array can be maximized. Here is how the pointer is used when
 * enqueueing an element with an array called {@code queue}:
 * <blockquote>{@code queue[(pointer + size) % queue.length] = e}</blockquote>
 * The first part of the index ensures that the tail of the queue is reached
 * by performing {@code pointer + size}. This may result in indices  that go
 * over the constraints of the array. However, it is prevented by {@code %
 * queue.length}. Since elements are always dequeued from the head, there will
 * always be space at the front of the array, unless the array reaches full
 * capacity. Since the pointer always points to the head of the queue, then
 * the position of the element to be dequeued or retrieved is always known.
 * <br><br>
 * All methods run {@code O(1)} time, similar to the time complexity of updating
 * an array. Therefore, all methods run in {@code O(1)} time, with the exception
 * of the {@link #contains(Object)} method, which depends on the position of the
 * element to be searched.
 * <br><br>
 * An array-based representation limits the capacity of elements that can be
 * added to the stack. In the current implementation, the capacity of the array
 * is set to {@code 1000}.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Queue} would store.
 * @version 1.1
 * @see Queue
 */
@SuppressWarnings({"unchecked"})
public class ArrayQueue<E> implements Queue<E> {

    /**
     * The default maximum capacity the array can handle.
     */
    private final int MAXIMUM_CAPACITY = 1000;

    /**
     * An array used to represent the queue.
     */
    private E[] queue;

    /**
     * A field to keep the number of elements in the queue.
     */
    private int size;

    /**
     * An arbitrary pointer to keep a reference of where the next element
     * should be inserted.
     */
    private int pointer;

    /**
     * Default Constructor. Initializes the array to be used as the queue.
     */
    public ArrayQueue() {
        queue = (E[]) new Object[MAXIMUM_CAPACITY];
        size = 0;
        pointer = 0;
    }

    /**
     * Constructor. Initializes the array to be used as the queue with the
     * specified capacity.
     * <br><br>
     * If {@code capacity} is less than {@code 1}, then the array initialized
     * will be set to its default capacity, {@code 1000}.
     *
     * @param capacity the capacity of the array when initialized
     */
    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            queue = (E[]) new Object[MAXIMUM_CAPACITY];
        } else {
            queue = (E[]) new Object[capacity];
        }
        size = 0;
        pointer = 0;
    }

    /**
     * Inserts the specified element {@code e} into the {@code Queue}.
     *
     * @param e the element to tbe inserted
     * @return {@code true} if the element is enqueued
     * @throws IllegalStateException if the capacity of the array is fulfilled
     * @since 1.1
     */
    @Override
    public boolean add(E e) {
        if (size == queue.length) {
            throw new IllegalStateException("queue is full");
        }
        queue[(pointer + size) % queue.length] = e;
        size++;
        return true;
    }

    /**
     * Inserts the specified element {@code e} into the {@code Queue}.
     *
     * @param e the element to tbe inserted
     * @return {@code true} if the element is enqueued
     * @since 1.1
     */
    @Override
    public boolean offer(E e) {
        if (size == queue.length) {
            return false;
        }
        queue[(pointer + size) % queue.length] = e;
        size++;
        return true;
    }

    /**
     * Removes the head of the {@code Queue} and retrieves the value of the
     * element just removed. If the {@code Queue} is empty, then this method
     * will throw an exception.
     *
     * @return the value of the element that was just dequeued
     * @throws NoSuchElementException if the {@code Queue} is empty
     * @since 1.1
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E e = queue[pointer];
        queue[pointer] = null;
        pointer = (pointer + 1) % queue.length;
        size--;
        return e;
    }

    /**
     * Removes the head of the {@code Queue} and retrieves the value of the
     * element just removed. If the {@code Queue} is empty, then this method
     * will return {@code null}.
     *
     * @return the value of the element that was just dequeued
     * @since 1.1
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = queue[pointer];
        queue[pointer] = null;
        pointer = (pointer + 1) % queue.length;
        size--;
        return e;
    }

    /**
     * Retrieves, but does not remove, the element at the head of the
     * {@code Queue}. If the {@code Queue} is empty, then this method will throw
     * an exception.
     *
     * @return the value of the element at the head of the {@code Queue}
     * @throws NoSuchElementException if the {@code Queue} is empty
     * @since 1.1
     */
    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return queue[pointer];
    }

    /**
     * Retrieves, but does not remove, the element at the head of the
     * {@code Queue}. If the {@code Queue} is empty, then this method will
     * return {@code null}.
     *
     * @return the value of the element at the head of the {@code Queue}
     * @since 1.1
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[pointer];
    }

    /**
     * Indicates whether the {@code Queue} is currently storing any elements.
     *
     * @return {@code true} if the {@code Queue} is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements currently in the {@code Queue}.
     *
     * @return the number of elements in the {@code Queue}
     * @since 1.1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the {@code Queue} such that it is empty and ready to be used
     * again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        int capacity = queue.length;
        queue = (E[]) new Object[capacity];
        size = 0;
        pointer = 0;
    }

    /**
     * Indicates whether element {@code e} exists within the {@code Queue}.
     *
     * @param e the element to be searched for
     * @return {@code true} if the element exists in the {@code Queue}
     */
    @Override
    public boolean contains(E e) {
        for (int i = pointer; i < size - pointer; i++) {
            if (Objects.equals(e, queue[i])) {
                return true;
            }
        }
        return false;
    }
}
