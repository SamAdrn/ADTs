package queue;

import java.util.Arrays;
import java.util.List;

class TestData {

    public static Queue<Integer> arrayQueue() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i : list) {
            queue.add(i);
        }
        return queue;
    }

    public static Queue<Integer> linkedQueue() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i : list) {
            queue.add(i);
        }
        return queue;
    }

}
