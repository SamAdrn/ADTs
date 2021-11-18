package stack;

import java.util.Arrays;
import java.util.List;

/**
 * Provides some methods to generate {@link Stack} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Creates a {@link ArrayStack} object with all positive {@code Integer}s
     * from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code ArrayStack} object
     */
    public static Stack<Integer> arrayStack() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Stack<Integer> stack = new ArrayStack<>();
        for (int i : list) {
            stack.push(i);
        }
        return stack;
    }

    /**
     * Creates a {@link LinkedStack} object with all positive {@code Integer}s
     * from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code LinkedStack} object
     */
    public static Stack<Integer> linkedStack() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Stack<Integer> stack = new LinkedStack<>();
        for (int i : list) {
            stack.push(i);
        }
        return stack;
    }

}
