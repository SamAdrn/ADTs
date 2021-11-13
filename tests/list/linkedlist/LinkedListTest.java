package list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class LinkedListTest {

    // Tests the general adding functionality of SinglyLinkedList

    /**
     * Tests the general functionality of adding a {@code Collection}
     * of items into a {@link SinglyLinkedList} object.
     */
    @Test
    public void test1() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Assertions.assertEquals(10, linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    /**
     * Tests the copy constructor of {@link SinglyLinkedList} and ensure that it
     * has made a deep copy.
     */
    @Test
    public void test2() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList1 = TestData.defaultList1();
        LinkedList<Integer> linkedList2 =
                new SinglyLinkedList<>((SinglyLinkedList<Integer>) linkedList1);
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList2.get(i));
        }

        // Ensures modifying arr2 will not change arr1
        linkedList2.add(10);
        Assertions.assertEquals(10, linkedList1.size());
        Assertions.assertEquals(11, linkedList2.size());
    }

    /**
     * Tests adding elements to different indices across a
     * {@link SinglyLinkedList} object.
     */
    @Test
    public void test3() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        // adding to the head
        linkedList.add(0, 10);
        // adding to the middle
        linkedList.add(6, 11);
        // adding to the tail
        linkedList.add(linkedList.size(), 12);
        List<Integer> list =
                Arrays.asList(10, 1, 3, 9, 4, 5, 11, 2, 10, 8, 6, 7, 12);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    /**
     * Tests adding a {@code Collection} of elements to a certain index
     * in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test4() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        linkedList.addAll(4, Arrays.asList(1, 2, 3, 4));
        List<Integer> list =
                Arrays.asList(1, 3, 9, 4, 1, 2, 3, 4, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    // Tests the general removing functionality of SinglyLinkedList

    /**
     * Tests removing elements at different indices in a
     * {@link SinglyLinkedList} object.
     */
    @Test
    public void test5() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        // remove an element in the middle
        Assertions.assertEquals(9, linkedList.remove(2));
        // remove the head
        Assertions.assertEquals(1, linkedList.remove(0));
        // remove the tail
        Assertions.assertEquals(7,
                linkedList.remove(linkedList.size() - 1));
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 10, 8, 6);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    /**
     * Tests removing a range of elements in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test6() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        Object[] removed = linkedList.removeRange(2, 5);
        List<Integer> removedList = Arrays.asList(9, 4, 5, 2);
        for (int i = 0; i < removedList.size(); i++) {
            Assertions.assertEquals(removedList.get(i), removed[i]);
        }
        List<Integer> list = Arrays.asList(1, 3, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    // Tests the set functionality of SinglyLinkedList

    /**
     * Tests replacing a value at a certain index in a {@link SinglyLinkedList}
     * object.
     */
    @Test
    public void test7() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        LinkedList<Integer> linkedList = TestData.defaultList1();
        Assertions.assertEquals(4, linkedList.set(3, 15));
        List<Integer> list = Arrays.asList(1, 3, 9, 15, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    // Tests the general get functionality of SinglyLinkedList

    /**
     * Tests getting the index of the <code>n</code>th occurrence of
     * <code>element</code> in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test8() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        LinkedList<Integer> linkedList = TestData.defaultList3();
        // 3rd occurrence of 0
        Assertions.assertEquals(2,
                linkedList.getNthOccurrenceIndex(0, 3));
        // 2nd occurrence of 2
        Assertions.assertEquals(9,
                linkedList.getNthOccurrenceIndex(2, 2));
        // 6th occurrence of 1 (doesn't exist since there is only 5 1s)
        Assertions.assertEquals(-1,
                linkedList.getNthOccurrenceIndex(1, 6));

        // switch arrays
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        linkedList = TestData.defaultList4();
        // 2nd occurrence of 0
        Assertions.assertEquals(6,
                linkedList.getNthOccurrenceIndex(0, 2));
        // 2nd occurrence of 8
        Assertions.assertEquals(7,
                linkedList.getNthOccurrenceIndex(8, 2));
        // 4th occurrence of 8 (doesn't exist since there is only 3 9s)
        Assertions.assertEquals(-1,
                linkedList.getNthOccurrenceIndex(9, 4));
    }

    /**
     * Tests retrieving the <code>n</code>th occurrence of <code>element</code>
     * in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test9() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        LinkedList<Integer> linkedList = TestData.defaultList3();
        Assertions.assertEquals(0,
                linkedList.getNthOccurrence(0, 3));
        Assertions.assertNull(linkedList.getNthOccurrence(0, 4));
    }

    /**
     * Tests retrieving the number of occurrences of <code>element</code>
     * in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test10() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        LinkedList<Integer> linkedList = TestData.defaultList3();
        Assertions.assertEquals(3, linkedList.getOccurrences(0));
        Assertions.assertEquals(5, linkedList.getOccurrences(1));
        Assertions.assertEquals(2, linkedList.getOccurrences(2));
        Assertions.assertEquals(0, linkedList.getOccurrences(3));

        // switch arrays
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        linkedList = TestData.defaultList4();
        Assertions.assertEquals(2, linkedList.getOccurrences(0));
        Assertions.assertEquals(3, linkedList.getOccurrences(8));
        Assertions.assertEquals(3, linkedList.getOccurrences(9));
        Assertions.assertEquals(0, linkedList.getOccurrences(11));
    }

    /**
     * Tests retrieving the index of the first occurrence of
     * <code>element</code> in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test11() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        LinkedList<Integer> linkedList = TestData.defaultList4();
        Assertions.assertEquals(1, linkedList.indexOf(10));
        Assertions.assertEquals(3, linkedList.indexOf(8));
        Assertions.assertEquals(3, linkedList.indexOf(8));
        Assertions.assertEquals(-1, linkedList.indexOf(2));
    }

    /**
     * Tests retrieving the index of the last occurrence of
     * <code>element</code> in a {@link SinglyLinkedList} object.
     */
    @Test
    public void test12() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        LinkedList<Integer> linkedList = TestData.defaultList4();
        Assertions.assertEquals(6, linkedList.lastIndexOf(0));
        Assertions.assertEquals(9, linkedList.lastIndexOf(9));
        Assertions.assertEquals(-1, linkedList.lastIndexOf(2));
    }

    /**
     * Tests indicating whether an <code>element</code> exists in a
     * {@link SinglyLinkedList} object.
     */
    @Test
    public void test13() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        LinkedList<Integer> linkedList = TestData.defaultList4();
        Assertions.assertTrue(linkedList.contains(8));
        Assertions.assertFalse(linkedList.contains(2));
    }

    // Tests the general output methods of DefaultArrayLis

    /**
     * Tests exporting a {@link SinglyLinkedList} object to an array.
     *
     * NOT WORKING. Cannot cast Object to String at toArray() method.
     */
//    @Test
//    public void test14() {
//        LinkedList<String> linkedList = TestData.defaultList5();
//        List<String> list = Arrays.asList("bat", "elk", "horse", "ermine", "bear",
//                "wolverine", "cheetah", "baboon", "parrot", "eland");
//        String[] output = linkedList.toArray();
//        for (int i = 0; i < list.size(); i++) {
//            Assertions.assertEquals(list.get(i), output[i]);
//        }
//    }

    /**
     * Tests displaying a {@link SinglyLinkedList} object as a String.
     */
    @Test
    public void test15() {
        LinkedList<String> linkedList = TestData.defaultList5();
        Assertions.assertEquals("[bat elk horse ermine bear wolverine " +
                "cheetah baboon parrot eland]", linkedList.toString());
    }

    // Tests other utility methods of SinglyLinkedList

    /**
     * Tests clearing a {@link SinglyLinkedList} object
     */
    @Test
    public void test16() {
        LinkedList<Integer> linkedList = TestData.defaultList2();
        Assertions.assertEquals(10, linkedList.size());
        linkedList.clear();
        Assertions.assertEquals(0, linkedList.size());
    }

    /**
     * Tests the iterator of a {@link SinglyLinkedList} object
     */
    @Test
    public void test17() {
        LinkedList<Integer> linkedList = TestData.defaultList2();
        // tests whether all values returned by next are correct
        Iterator<Integer> itr = linkedList.iterator();
        List<Integer> list =
                Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5);
        int i = 0;
        while (itr.hasNext()) {
            Assertions.assertEquals(list.get(i), itr.next());
            i++;
        }

        // tests whether the iterator is capable of removing an object
        itr = linkedList.iterator();
        list = Arrays.asList(0, -3, 12, -50, 2, -10, 90, 23, 5);
        for (i = 0; i < 5; i++) {
            itr.next();
        }
        itr.remove();
        for (i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), linkedList.get(i));
        }
    }

    /**
     * Tests whether {@link SinglyLinkedList} is capable of adding {@code null}
     * objects.
     */
    @Test
    public void test18() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(null);
        Assertions.assertTrue(linkedList.contains(null));
    }

}