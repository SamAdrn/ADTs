package queue;

import list.linkedlist.DoublyLinkedList;

import java.util.NoSuchElementException;

/**
 * This class is an implementation of the {@link Queue} interface.
 *
 * <p> The {code LinkedQueue} class uses a {@link DoublyLinkedList} to represent
 * a queue. Every time an element is enqueued in the queue, the element will be
 * added to the {@link DoublyLinkedList#tail tail} of the list, in other words
 * the back of the queue. Meanwhile, to dequeue an element, the element will be
 * removed from the {@link DoublyLinkedList#head head} of the list, in other
 * words the front of the queue.
 *
 * <p> All methods run in the best-case time complexity equivalent to the
 * {@link DoublyLinkedList} class. This is because the queue is based on both
 * the head and tail of the list, in which the {@link DoublyLinkedList} supports
 * as the beginning of iterations.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Queue} would store.
 * @version 1.1
 * @see Queue
 * @see DoublyLinkedList
 */
public class LinkedQueue<E> implements Queue<E> {

    /**
     * The reference to the queue
     */
    private final DoublyLinkedList<E> queue;

    /**
     * Default Constructor. Initializes the queue being used in this object.
     */
    public LinkedQueue() {
        queue = new DoublyLinkedList<>();
    }

    /**
     * Inserts the specified element {@code e} into the {@code Queue}.
     *
     * @param e the element to tbe inserted
     * @return {@code true} if the element is enqueued
     * @since 1.1
     */
    @Override
    public boolean add(E e) {
        return queue.addLast(e);
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
        return queue.addLast(e);
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
        return queue.removeFirst();
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
        return queue.removeFirst();
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
        return queue.head();
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
        return queue.head();
    }

    /**
     * Indicates whether the {@code Queue} is currently storing any elements.
     *
     * @return {@code true} if the {@code Queue} is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns the number of elements currently in the {@code Queue}.
     *
     * @return the number of elements in the {@code Queue}
     * @since 1.1
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Clears the {@code Queue} such that it is empty and ready to be used
     * again.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        queue.clear();
    }

    /**
     * Indicates whether element {@code e} exists within the {@code Queue}.
     *
     * @param e the element to be searched for
     * @return {@code true} if the element exists in the {@code Queue}
     */
    @Override
    public boolean contains(E e) {
        return queue.contains(e);
    }

}
