package queue;

import java.util.Arrays;
import java.util.List;

/**
 * Provides some methods to generate {@link Queue} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Creates a {@link ArrayQueue} object with all positive {@code Integer}s
     * from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code ArrayQueue} object
     */
    public static Queue<Integer> arrayQueue() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i : list) {
            queue.add(i);
        }
        return queue;
    }

    /**
     * Creates a {@link LinkedQueue} object with all positive {@code Integer}s
     * from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code LinkedQueue} object
     */
    public static Queue<Integer> linkedQueue() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i : list) {
            queue.add(i);
        }
        return queue;
    }

}
