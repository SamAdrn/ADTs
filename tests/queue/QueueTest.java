package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class QueueTest {

    // Tests the general enqueueing and dequeueing functionality of ArrayQueue

    /**
     * Tests the general functionality of enqueueing and dequeueing elements in
     * an {@link ArrayQueue} object.
     */
    @Test
    public void test1() {
        Queue<Integer> queue = TestData.arrayQueue();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            Assertions.assertEquals(list.get(i), queue.remove());
        }
    }

    // Tests the retrieval methods of ArrayQueue

    /**
     * Tests retrieving elements in an {@link ArrayQueue} object.
     */
    @Test
    public void test2() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.arrayQueue();
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(3, queue.peek());
    }

    // Tests the utility methods of ArrayQueue

    /**
     * Tests indicating if elements exist in an {@link ArrayQueue} object.
     */
    @Test
    public void test3() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.arrayQueue();
        Assertions.assertFalse(queue.contains(100));
        Assertions.assertTrue(queue.contains(5));
    }

    /**
     * Tests clearing the {@link ArrayQueue} object and test if it can be used
     * again.
     */
    @Test
    public void test4() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.arrayQueue();
        Assertions.assertFalse(queue.isEmpty());
        queue.clear();
        Assertions.assertTrue(queue.isEmpty());
        queue.add(100);
        Assertions.assertEquals(100, queue.peek());
    }

    // Tests the general enqueueing and dequeueing functionality of LinkedQueue

    /**
     * Tests the general functionality of enqueueing and dequeueing elements in
     * an {@link LinkedQueue} object.
     */
    @Test
    public void test5() {
        Queue<Integer> queue = TestData.linkedQueue();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            Assertions.assertEquals(list.get(i), queue.remove());
        }
    }

    // Tests the retrieval methods of LinkedQueue

    /**
     * Tests retrieving elements in an {@link LinkedQueue} object.
     */
    @Test
    public void test6() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.linkedQueue();
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(3, queue.peek());
    }

    // Tests the utility methods of LinkedQueue

    /**
     * Tests indicating if elements exist in an {@link LinkedQueue} object.
     */
    @Test
    public void test7() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.linkedQueue();
        Assertions.assertFalse(queue.contains(100));
        Assertions.assertTrue(queue.contains(5));
    }

    /**
     * Tests clearing the {@link LinkedQueue} object and test if it can be used
     * again.
     */
    @Test
    public void test8() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        Queue<Integer> queue = TestData.linkedQueue();
        Assertions.assertFalse(queue.isEmpty());
        queue.clear();
        Assertions.assertTrue(queue.isEmpty());
        queue.add(100);
        Assertions.assertEquals(100, queue.peek());
    }

}