package list.linkedlist;

import java.util.Arrays;

/**
 * Provides some methods to generate {@link LinkedList} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Creates a {@link SinglyLinkedList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code SinglyLinkedList} object
     */
    public static LinkedList<Integer> singlyList1() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return list;
    }

    /**
     * Creates a {@link SinglyLinkedList} object with a mix of positive and
     * negative {@code Integer}s in the order:
     * <blockquote>{@code 0, -3, 12, -50, 41, 2, -10, 90, 23, 5}</blockquote>
     *
     * @return a {@code SinglyLinkedList} object
     */
    public static LinkedList<Integer> singlyList2() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return list;
    }

    /**
     * Creates a {@link SinglyLinkedList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 2} in the order:
     * <blockquote>{@code 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}</blockquote>
     *
     * @return a {@code SinglyLinkedList} object
     */
    public static LinkedList<Integer> singlyList3() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return list;
    }

    /**
     * Creates a {@link SinglyLinkedList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 10} in the order:
     * <blockquote>{@code 0, 10, 9, 8, 10, 9, 0, 8, 8, 9}</blockquote>
     *
     * @return a {@code SinglyLinkedList} object
     */
    public static LinkedList<Integer> singlyList4() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return list;
    }

    /**
     * Creates a {@link SinglyLinkedList} object with random {@code String}s
     * in the order:
     * <blockquote>{@code "bat", "elk", "horse", "ermine", "bear", "wolverine",
     * "cheetah", "baboon", "parrot", "eland"}</blockquote>
     *
     * @return a {@code SinglyLinkedList} object
     */
    public static LinkedList<String> singlyList5() {
        LinkedList<String> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return list;
    }

    /**
     * Creates a {@link DoublyLinkedList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code DoublyLinkedList} object
     */
    public static LinkedList<Integer> doublyList1() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return list;
    }

    /**
     * Creates a {@link DoublyLinkedList} object with a mix of positive and
     * negative {@code Integer}s in the order:
     * <blockquote>{@code 0, -3, 12, -50, 41, 2, -10, 90, 23, 5}</blockquote>
     *
     * @return a {@code DoublyLinkedList} object
     */
    public static LinkedList<Integer> doublyList2() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return list;
    }

    /**
     * Creates a {@link DoublyLinkedList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 2} in the order:
     * <blockquote>{@code 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}</blockquote>
     *
     * @return a {@code DoublyLinkedList} object
     */
    public static LinkedList<Integer> doublyList3() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return list;
    }

    /**
     * Creates a {@link DoublyLinkedList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 10} in the order:
     * <blockquote>{@code 0, 10, 9, 8, 10, 9, 0, 8, 8, 9}</blockquote>
     *
     * @return a {@code DoublyLinkedList} object
     */
    public static LinkedList<Integer> doublyList4() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return list;
    }

    /**
     * Creates a {@link DoublyLinkedList} object with random {@code String}s
     * in the order:
     * <blockquote>{@code "bat", "elk", "horse", "ermine", "bear", "wolverine",
     * "cheetah", "baboon", "parrot", "eland"}</blockquote>
     *
     * @return a {@code DoublyLinkedList} object
     */
    public static LinkedList<String> doublyList5() {
        LinkedList<String> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return list;
    }

}
