package stack;

import java.util.Arrays;
import java.util.List;

class TestData {

    public static Stack<Integer> arrayStack() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Stack<Integer> stack = new ArrayStack<>();
        for (int i : list) {
            stack.push(i);
        }
        return stack;
    }

    public static Stack<Integer> linkedStack() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Stack<Integer> stack = new LinkedStack<>();
        for (int i : list) {
            stack.push(i);
        }
        return stack;
    }

}
