package list.linkedlist;

import java.util.Arrays;

class TestData {

    public static LinkedList<Integer> singlyList1() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return list;
    }

    public static LinkedList<Integer> singlyList2() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return list;
    }

    public static LinkedList<Integer> singlyList3() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return list;
    }

    public static LinkedList<Integer> singlyList4() {
        LinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return list;
    }

    public static LinkedList<String> singlyList5() {
        LinkedList<String> list = new SinglyLinkedList<>();
        list.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return list;
    }

    public static LinkedList<Integer> doublyList1() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return list;
    }

    public static LinkedList<Integer> doublyList2() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return list;
    }

    public static LinkedList<Integer> doublyList3() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return list;
    }

    public static LinkedList<Integer> doublyList4() {
        LinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return list;
    }

    public static LinkedList<String> doublyList5() {
        LinkedList<String> list = new DoublyLinkedList<>();
        list.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return list;
    }

}
