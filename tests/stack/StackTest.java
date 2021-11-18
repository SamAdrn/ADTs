package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Provides tests for the implementations of the {@link Stack}.
 *
 * @author Samuel Adrian Kosasih
 */
class StackTest {

    // Tests the general push and pop functionality of ArrayStack

    /**
     * Tests the general functionality of pushing and popping elements in an
     * {@link ArrayStack} object.
     */
    @Test
    public void test1() {
        Stack<Integer> stack = TestData.arrayStack();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        int stackSize = stack.size();
        for (int i = stackSize - 1; i >= 0; i--) {
            Assertions.assertEquals(list.get(i), stack.pop());
        }
    }

    // Tests the retrieval methods of ArrayStack

    /**
     * Tests peeking elements at the top of an {@link ArrayStack}.
     */
    @Test
    public void test2() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.arrayStack();
        Assertions.assertEquals(7, stack.peek());
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertEquals(6, stack.peek());
    }

    /**
     * Tests searching elements in an {@link ArrayStack} object.
     */
    @Test
    public void test3() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.arrayStack();
        Assertions.assertEquals(0, stack.search(7));
        Assertions.assertEquals(3, stack.search(10));
        Assertions.assertEquals(stack.size() - 1, stack.search(1));
    }

    // Tests the utility methods of ArrayStack

    /**
     * Tests clearing the {@link ArrayStack} object and test if it can be used
     * again.
     */
    @Test
    public void test4() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.arrayStack();
        Assertions.assertFalse(stack.isEmpty());
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(100);
        Assertions.assertEquals(100, stack.peek());
    }

    // Tests the general push and pop functionality of LinkedStack

    /**
     * Tests the general functionality of pushing and popping elements in an
     * {@link LinkedStack} object.
     */
    @Test
    public void test5() {
        Stack<Integer> stack = TestData.linkedStack();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        int stackSize = stack.size();
        for (int i = stackSize - 1; i >= 0; i--) {
            Assertions.assertEquals(list.get(i), stack.pop());
        }
    }

    // Tests the retrieval methods of LinkedStack

    /**
     * Tests peeking elements at the top of an {@link LinkedStack}.
     */
    @Test
    public void test6() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.linkedStack();
        Assertions.assertEquals(7, stack.peek());
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertEquals(6, stack.peek());
    }

    /**
     * Tests searching elements in an {@link LinkedStack} object.
     */
    @Test
    public void test7() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.linkedStack();
        Assertions.assertEquals(0, stack.search(7));
        Assertions.assertEquals(3, stack.search(10));
        Assertions.assertEquals(stack.size() - 1, stack.search(1));
    }

    // Tests the utility methods of LinkedStack

    /**
     * Tests clearing the {@link LinkedStack} object and test if it can be used
     * again.
     */
    @Test
    public void test8() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Stack<Integer> stack = TestData.linkedStack();
        Assertions.assertFalse(stack.isEmpty());
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(100);
        Assertions.assertEquals(100, stack.peek());
    }

}