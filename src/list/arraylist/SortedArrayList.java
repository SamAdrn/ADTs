package list.arraylist;

/**
 * This class is an implementation of the {@link ComparableArrayList} class.
 * <br><br>
 * In a {@code SortedArrayList}, elements are ordered based on their comparison
 * values, obtained from the {@link Comparable#compareTo(Object)
 * compareTo(Object)} method in the {@link Comparable} interface. For example,
 * if the {@code Collection} of elements : {@code [3, 2, 1, 4, ...]} is inserted
 * to the {@code SortedArrayList}, it will store it as
 * <blockquote>{@code [1, 2, 3, 4, ...]}<br>with ascending order as specified by
 * the {@link Integer#compareTo(Integer) compareTo(Integer)} method
 * in the {@link Integer} class.</blockquote>
 * <br><br>
 * Since this {@code ArrayList} must maintain a certain specific order of
 * elements throughout its lifespan, it will no longer accept {@code null}
 * elements. There is no valid rule on where {@code null} objects should be
 * kept. Furthermore, this class will not support the
 * {@link #add(int, Comparable)} method, since the user no longer has control
 * of the order of elements within the {@code ArrayList}.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code ArrayList} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see ComparableArrayList
 * @see Comparable
 */
public class SortedArrayList<E extends Comparable<E>>
        extends ComparableArrayList<E> {

    /**
     * Default Constructor. Initializes a starting array of capacity {@code 10}.
     */
    public SortedArrayList() {
        super();
    }

    /**
     * Constructor. Initializes a starting array with a capacity specified
     * in {@code minCapacity}.
     *
     * @param minCapacity the minimum capacity of the array to be initialized
     */
    public SortedArrayList(int minCapacity) {
        super(minCapacity);
    }

    /**
     * Copy Constructor. Takes in another {@code ComparableArrayList} object
     * and creates a deep copy of it. If {@code cal} is not a
     * {@code SortedArrayList}, then this constructor will return a sorted
     * version of the {@code ComparableArrayList} object.
     *
     * @param cal the other {@code ComparableArrayList} object to be copied
     */
    public SortedArrayList(ComparableArrayList<E> cal) {
        super(cal);
    }

    /**
     * Inserts {@code element} to the appropriate position of the
     * {@code SortedArrayList}.
     * <br><br>
     * Due to constraints of the {@code SortedArrayList}, this method
     * will return {@code false} if it takes in a {@code null}
     * element.
     *
     * @param element the element to be inserted into the list
     * @return {@code true} if {@code element} is successfully added to the
     * list
     * @since 1.1
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            // null elements are not accepted in a SortedArrayList
            return false;
        }
        if (size >= arr.length - 1) {
            ensureCapacity(size + 10);
        }
        boolean found = false;
        int index = size;
        int i = 0;
        while (!found && i != size) {
            if (element.compareTo(arr[i]) < 0) {
                index = i;
                found = true;
            } else {
                i++;
            }
        }
        for (int j = size - 1; j >= index; j--) {
            arr[j + 1] = arr[j];
        }
        arr[index] = element;
        size++;
        return true;
    }

    /**
     * Inserts {@code element} to a position in the {@code ArrayList}
     * specified by {@code index}.
     *
     * @param index   the index position where the element should be inserted
     * @param element the element to be inserted
     * @return {@code true} to indicate a change has been made to the list
     * @since 1.1
     * @deprecated adding by index is not supported in a
     * {@code SortedArrayList}
     */
    @Override
    public boolean add(int index, E element)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("adding by index is not " +
                "supported in a sorted ArrayList");
    }

    /**
     * Indicates whether {@code element} exists within the {@code ArrayList}.
     *
     * @param element the element to be searched for
     * @return {@code true} if {@code element} exists in the
     * {@code ArrayList}
     * @since 1.1
     */
    @Override
    public boolean contains(E element) {
        return fastIndexOf(element) != -1;
    }

    /**
     * Retrieves the index of {@code element} in the {@code ArrayList}.
     * <br><br>
     * If duplicate elements exist, then this method will return the index
     * of any of the occurrences of element. The point of this method is to
     * be a more efficient alternative to {@link #indexOf(Comparable)} for the
     * {@link #contains(Comparable)} method by using the binary search
     * implementation.
     *
     * @param element the element to be searched for
     * @return the index of any occurrence of {@code element}
     * @since 1.1
     */
    public int fastIndexOf(E element) {
        return binarySearch(element, 0, size);
    }

    /**
     * This private recursive helper method is an implementation of the
     * binary search algorithm to help search for elements more efficiently in
     * a sorted array. Runtime Complexity: {@code O(log n)}.
     *
     * @param element the element to be searched for
     * @param low     the beginning index of a section of the array
     * @param high    the end index of a section of the array
     * @return the index of {@code element}
     */
    private int binarySearch(E element, int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int mid = low + high / 2;
            if (element.compareTo(arr[mid]) < 0) {
                return binarySearch(element, low, mid - 1);
            } else if (element.compareTo(arr[mid]) > 0) {
                return binarySearch(element, mid + 1, high);
            } else {
                return mid;
            }
        }
    }

}
