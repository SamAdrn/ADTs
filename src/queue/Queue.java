package queue;

/**
 * This interface represents the root interface of all {@code Queue} objects.
 * <br><br>
 * A {@code Queue} is a type of data structure that follows the LIFO (last-in
 * first-out) principle. A great analogy of a {@code Queue} would be a normal
 * line in a offee shop, in which customers entering the {@code Queue} first
 * would leave the earliest. This works the same way for the {@code Queue} data
 * structure. Elements last in would be the first out.
 * <br><br>
 * With that being explained, elements would always be added (i.e., enqueued)
 * to the tail of the {@code Queue}, and they would always be removed
 * (i.e., dequeued) from the head of the {@code Queue}. Retrieving elements also
 * work the same way as removals, with the exception of the element being
 * removed.
 * <br><br>
 * There are two versions of certain methods in a {@code Queue} which differs
 * in the return values when operations fail. For example, the {@link
 * #add(Object) add(e)} method will throw an exception if any circumstances
 * prevent the operation from succeeding. The following is a summary of methods
 * in this {@code Queue} class. {@link java.util.Queue}
 * <table class="striped">
 *  <thead>
 *  <tr>
 *    <td></td>
 *    <th scope="col" style="font-weight:normal;">Throws exception</th>
 *    <th scope="col" style="font-weight:normal;">Returns special value</th>
 *  </tr>
 *  </thead>
 *  <tbody>
 *  <tr>
 *    <th scope="row">Insert</th>
 *    <td>{@link #add(Object) add(e)}</td>
 *    <td>{@link #offer(Object) offer(e)}</td>
 *  </tr>
 *  <tr>
 *    <th scope="row">Remove</th>
 *    <td>{@link #remove() remove()}</td>
 *    <td>{@link #poll() poll()}</td>
 *  </tr>
 *  <tr>
 *    <th scope="row">Retrieve</th>
 *    <td>{@link #element() element()}</td>
 *    <td>{@link #peek() peek()}</td>
 *  </tr>
 *  </tbody>
 * </table>
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Queue} would store.
 *
 * @version 1.1
 */
public interface Queue<E> {

    /**
     * Inserts the specified element {@code e} into the {@code Queue}.
     *
     * @param e the element to tbe inserted
     * @return {@code true} if the element is enqueued
     * @since 1.1
     */
    boolean add(E e);

    /**
     * Inserts the specified element {@code e} into the {@code Queue}.
     *
     * @param e the element to tbe inserted
     * @return {@code true} if the element is enqueued
     * @since 1.1
     */
    boolean offer(E e);

    /**
     * Removes the head of the {@code Queue} and retrieves the value of the
     * element just removed. If the {@code Queue} is empty, then this method
     * will throw an exception.
     *
     * @return the value of the element that was just dequeued
     * @throws java.util.NoSuchElementException if the {@code Queue} is empty
     * @since 1.1
     */
    E remove();

    /**
     * Removes the head of the {@code Queue} and retrieves the value of the
     * element just removed. If the {@code Queue} is empty, then this method
     * will return {@code null}.
     *
     * @return the value of the element that was just dequeued
     * @since 1.1
     */
    E poll();

    /**
     * Retrieves, but does not remove, the element at the head of the
     * {@code Queue}. If the {@code Queue} is empty, then this method will throw
     * an exception.
     *
     * @return the value of the element at the head of the {@code Queue}
     * @throws java.util.NoSuchElementException if the {@code Queue} is empty
     * @since 1.1
     */
    E element();

    /**
     * Retrieves, but does not remove, the element at the head of the
     * {@code Queue}. If the {@code Queue} is empty, then this method will
     * return {@code null}.
     *
     * @return the value of the element at the head of the {@code Queue}
     * @since 1.1
     */
    E peek();

    /**
     * Indicates whether the {@code Queue} is currently storing any elements.
     *
     * @return {@code true} if the {@code Queue} is empty
     * @since 1.1
     */
    boolean isEmpty();

    /**
     * Returns the number of elements currently in the {@code Queue}.
     *
     * @return the number of elements in the {@code Queue}
     * @since 1.1
     */
    int size();

    /**
     * Clears the {@code Queue} such that it is empty and ready to be used 
     * again.
     *
     * @since 1.1
     */
    void clear();

    /**
     * Indicates whether element {@code e} exists within the {@code Queue}.
     * 
     * @param e the element to be searched for
     * @return {@code true} if the element exists in the {@code Queue}
     */
    boolean contains(E e);

}
