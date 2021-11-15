package list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ArrayListTest {

    // Tests the general adding functionality of DefaultArrayList

    /**
     * Tests the general functionality of adding a {@code Collection}
     * of items into a {@link DefaultArrayList} object.
     */
    @Test
    public void test1() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        Assertions.assertEquals(10, arr.size());
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    /**
     * Tests the copy constructor of {@link DefaultArrayList} and ensure that it
     * has made a deep copy.
     */
    @Test
    public void test2() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr1 = TestData.defaultList1();
        DefaultArrayList<Integer> arr2 =
                new DefaultArrayList<>((DefaultArrayList<Integer>) arr1);
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr2.get(i));
        }

        // Ensures modifying arr2 will not change arr1
        arr2.add(10);
        Assertions.assertEquals(10, arr1.size());
        Assertions.assertEquals(11, arr2.size());
    }

    /**
     * Tests adding elements to different indices across a
     * {@link DefaultArrayList} object.
     */
    @Test
    public void test3() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        // adding to the head
        arr.add(0, 10);
        // adding to the middle
        arr.add(6, 11);
        // adding to the tail
        arr.add(arr.size(), 12);
        List<Integer> list =
                Arrays.asList(10, 1, 3, 9, 4, 5, 11, 2, 10, 8, 6, 7, 12);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }


    /**
     * Tests adding a {@code Collection} of elements to a certain index
     * in a {@link DefaultArrayList} object.
     */
    @Test
    public void test4() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        arr.addAll(4, Arrays.asList(1, 2, 3, 4));
        List<Integer> list =
                Arrays.asList(1, 3, 9, 4, 1, 2, 3, 4, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    // Tests the general removing functionality of DefaultArrayList

    /**
     * Tests removing elements at different indices in a
     * {@link DefaultArrayList} object.
     */
    @Test
    public void test5() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        // remove an element in the middle
        Assertions.assertEquals(9, arr.remove(2));
        // remove the head
        Assertions.assertEquals(1, arr.remove(0));
        // remove the tail
        Assertions.assertEquals(7, arr.remove(arr.size() - 1));
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 10, 8, 6);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    /**
     * Tests removing a range of elements in a {@link DefaultArrayList} object.
     */
    @Test
    public void test6() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        Object[] removed = arr.removeRange(2, 5);
        List<Integer> removedList = Arrays.asList(9, 4, 5, 2);
        for (int i = 0; i < removedList.size(); i++) {
            Assertions.assertEquals(removedList.get(i), removed[i]);
        }
        List<Integer> list = Arrays.asList(1, 3, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    // Tests the set functionality of DefaultArrayList

    /**
     * Tests replacing a value at a certain index in a {@link DefaultArrayList}
     * object.
     */
    @Test
    public void test7() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        ArrayList<Integer> arr = TestData.defaultList1();
        Assertions.assertEquals(4, arr.set(3, 15));
        List<Integer> list = Arrays.asList(1, 3, 9, 15, 5, 2, 10, 8, 6, 7);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    // Tests the general get functionality of DefaultArrayList

    /**
     * Tests getting the index of the <code>n</code>th occurrence of
     * <code>element</code> in a {@link DefaultArrayList} object.
     */
    @Test
    public void test8() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.defaultList3();
        // 3rd occurrence of 0
        Assertions.assertEquals(2,
                arr.getNthOccurrenceIndex(0, 3));
        // 2nd occurrence of 2
        Assertions.assertEquals(9,
                arr.getNthOccurrenceIndex(2, 2));
        // 6th occurrence of 1 (doesn't exist since there is only 5 1s)
        Assertions.assertEquals(-1,
                arr.getNthOccurrenceIndex(1, 6));

        // switch arrays
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        arr = TestData.defaultList4();
        // 2nd occurrence of 0
        Assertions.assertEquals(6,
                arr.getNthOccurrenceIndex(0, 2));
        // 2nd occurrence of 8
        Assertions.assertEquals(7,
                arr.getNthOccurrenceIndex(8, 2));
        // 4th occurrence of 8 (doesn't exist since there is only 3 9s)
        Assertions.assertEquals(-1,
                arr.getNthOccurrenceIndex(9, 4));
    }

    /**
     * Tests retrieving the <code>n</code>th occurrence of <code>element</code>
     * in a {@link DefaultArrayList} object.
     */
    @Test
    public void test9() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.defaultList3();
        Assertions.assertEquals(0,
                arr.getNthOccurrence(0, 3));
        Assertions.assertNull(arr.getNthOccurrence(0, 4));
    }

    /**
     * Tests retrieving the number of occurrences of <code>element</code>
     * in a {@link DefaultArrayList} object.
     */
    @Test
    public void test10() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.defaultList3();
        Assertions.assertEquals(3, arr.getOccurrences(0));
        Assertions.assertEquals(5, arr.getOccurrences(1));
        Assertions.assertEquals(2, arr.getOccurrences(2));
        Assertions.assertEquals(0, arr.getOccurrences(3));

        // switch arrays
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        arr = TestData.defaultList4();
        Assertions.assertEquals(2, arr.getOccurrences(0));
        Assertions.assertEquals(3, arr.getOccurrences(8));
        Assertions.assertEquals(3, arr.getOccurrences(9));
        Assertions.assertEquals(0, arr.getOccurrences(11));
    }

    /**
     * Tests retrieving the index of the first occurrence of
     * <code>element</code> in a {@link DefaultArrayList} object.
     */
    @Test
    public void test11() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        ArrayList<Integer> arr = TestData.defaultList4();
        Assertions.assertEquals(1, arr.indexOf(10));
        Assertions.assertEquals(3, arr.indexOf(8));
        Assertions.assertEquals(-1, arr.indexOf(2));
    }

    /**
     * Tests retrieving the index of the last occurrence of
     * <code>element</code> in a {@link DefaultArrayList} object.
     */
    @Test
    public void test12() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        ArrayList<Integer> arr = TestData.defaultList4();
        Assertions.assertEquals(6, arr.lastIndexOf(0));
        Assertions.assertEquals(9, arr.lastIndexOf(9));
        Assertions.assertEquals(-1, arr.lastIndexOf(2));
    }

    /**
     * Tests indicating whether an <code>element</code> exists in a
     * {@link DefaultArrayList} object.
     */
    @Test
    public void test13() {
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        ArrayList<Integer> arr = TestData.defaultList4();
        Assertions.assertTrue(arr.contains(8));
        Assertions.assertFalse(arr.contains(2));
    }

    // Tests the general output methods of DefaultArrayList

    /**
     * Tests exporting a {@link DefaultArrayList} object to an array.
     *
     * NOT WORKING. Cannot cast Object to String at toArray() method.
     */
//    @Test
//    public void test14() {
//        ArrayList<String> arr = TestData.defaultList5();
//        List<String> list = Arrays.asList("bat", "elk", "horse", "ermine", "bear",
//                "wolverine", "cheetah", "baboon", "parrot", "eland");
//        String[] output = arr.toArray();
//        for (int i = 0; i < list.size(); i++) {
//            Assertions.assertEquals(list.get(i), output[i]);
//        }
//    }

    /**
     * Tests displaying a {@link DefaultArrayList} object as a String.
     */
    @Test
    public void test15() {
        ArrayList<String> arr = TestData.defaultList5();
        Assertions.assertEquals("[bat elk horse ermine bear wolverine " +
                "cheetah baboon parrot eland]", arr.toString());
    }

    // Tests other utility methods of DefaultArrayList

    /**
     * Tests clearing a {@link DefaultArrayList} object
     */
    @Test
    public void test16() {
        ArrayList<Integer> arr = TestData.defaultList2();
        Assertions.assertEquals(10, arr.size());
        arr.clear();
        Assertions.assertEquals(0, arr.size());
    }

    /**
     * Tests the iterator of a {@link DefaultArrayList} object
     */
    @Test
    public void test17() {
        ArrayList<Integer> arr = TestData.defaultList2();
        // tests whether all values returned by next are correct
        Iterator<Integer> itr = arr.iterator();
        List<Integer> list =
                Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5);
        int i = 0;
        while (itr.hasNext()) {
            Assertions.assertEquals(list.get(i), itr.next());
            i++;
        }

        // tests whether the iterator is capable of removing an object
        itr = arr.iterator();
        list = Arrays.asList(0, -3, 12, -50, 2, -10, 90, 23, 5);
        for (i = 0; i < 5; i++) {
            itr.next();
        }
        itr.remove();
        for (i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    /**
     * Tests whether {@link DefaultArrayList} is capable of adding {@code null}
     * objects.
     */
    @Test
    public void test18() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.add(null);
        Assertions.assertTrue(arr.contains(null));
    }

    // Tests the general adding functionality of SortedArrayList

    /**
     * Tests the general functionality of adding a {@code Collection}
     * of items into a {@link SortedArrayList} object.
     */
    @Test
    public void test19() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7 (unsorted)
        ArrayList<Integer> arr = TestData.sortedList1();
        List<Integer> list = Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10);
        Assertions.assertEquals(10, arr.size());
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    /**
     * Tests the copy constructor of {@link SortedArrayList} and ensure that it
     * has made a deep copy.
     */
    @Test
    public void test20() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7 (unsorted)
        ArrayList<Integer> arr1 = TestData.sortedList1();
        SortedArrayList<Integer> arr2 =
                new SortedArrayList<>((SortedArrayList<Integer>) arr1);
        List<Integer> list = Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr2.get(i));
        }

        // Ensures modifying arr2 will not change arr1
        arr2.add(11);
        Assertions.assertEquals(10, arr1.size());
        Assertions.assertEquals(11, arr2.size());
    }

    /**
     * Tests the copy constructor of {@link SortedArrayList} when making a
     * deep copy of its unsorted super class {@link ComparableArrayList}.
     */
    @Test
    public void test21() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7 (unsorted)
        ArrayList<Integer> arr1 = TestData.comparableList1();
        SortedArrayList<Integer> arr2 =
                new SortedArrayList<>((ComparableArrayList<Integer>) arr1);
        List<Integer> list = Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr2.get(i));
        }

        // Ensures modifying arr2 will not change arr1
        arr2.add(11);
        Assertions.assertEquals(10, arr1.size());
        Assertions.assertEquals(11, arr2.size());
    }

    // Tests the general removing functionality of SortedArrayList

    /**
     * Tests removing elements at different indices in a
     * {@link SortedArrayList} object.
     */
    @Test
    public void test22() {
        // 1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList1();
        // remove an element in the middle
        Assertions.assertEquals(3, arr.remove(2));
        // remove the head
        Assertions.assertEquals(1, arr.remove(0));
        // remove the tail
        Assertions.assertEquals(10, arr.remove(arr.size() - 1));
        List<Integer> list = Arrays.asList(2, 4, 5, 6, 7, 8, 9);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    /**
     * Tests removing a range of elements in a {@link SortedArrayList} object.
     */
    @Test
    public void test23() {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList1();
        Object[] removed = arr.removeRange(2, 5);
        List<Integer> removedList = Arrays.asList(3, 4, 5, 6);
        for (int i = 0; i < removedList.size(); i++) {
            Assertions.assertEquals(removedList.get(i), removed[i]);
        }
        List<Integer> list = Arrays.asList(1, 2, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    // Tests the set functionality of SortedArrayList

    /**
     * Tests replacing a value at a certain index in a {@link SortedArrayList}
     * object.
     */
    @Test
    public void test24() {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList1();
        Assertions.assertEquals(4, arr.set(3, 15));
        // 15 will become the tail as it is the largest element
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10, 15);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

    // Tests the general get functionality of SortedArrayList

    /**
     * Tests getting the index of the <code>n</code>th occurrence of
     * <code>element</code> in a {@link SortedArrayList} object.
     */
    @Test
    public void test25() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.sortedList3();
        // 3rd occurrence of 0
        Assertions.assertEquals(2,
                arr.getNthOccurrenceIndex(0, 3));
        // 2nd occurrence of 2
        Assertions.assertEquals(9,
                arr.getNthOccurrenceIndex(2, 2));
        // 6th occurrence of 1 (doesn't exist since there is only 5 1s)
        Assertions.assertEquals(-1,
                arr.getNthOccurrenceIndex(1, 6));

        // switch arrays
        // 0, 0, 8, 8, 8, 9, 9, 9, 10, 10 (sorted)
        arr = TestData.sortedList4();
        // 2nd occurrence of 0
        Assertions.assertEquals(1,
                arr.getNthOccurrenceIndex(0, 2));
        // 2nd occurrence of 8
        Assertions.assertEquals(3,
                arr.getNthOccurrenceIndex(8, 2));
        // 4th occurrence of 8 (doesn't exist since there is only 3 9s)
        Assertions.assertEquals(-1,
                arr.getNthOccurrenceIndex(9, 4));
    }

    /**
     * Tests retrieving the <code>n</code>th occurrence of <code>element</code>
     * in a {@link SortedArrayList} object.
     */
    @Test
    public void test26() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.sortedList3();
        Assertions.assertEquals(0,
                arr.getNthOccurrence(0, 3));
        Assertions.assertNull(arr.getNthOccurrence(0, 4));
    }

    /**
     * Tests retrieving the number of occurrences of <code>element</code>
     * in a {@link SortedArrayList} object.
     */
    @Test
    public void test27() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        ArrayList<Integer> arr = TestData.sortedList3();
        Assertions.assertEquals(3, arr.getOccurrences(0));
        Assertions.assertEquals(5, arr.getOccurrences(1));
        Assertions.assertEquals(2, arr.getOccurrences(2));
        Assertions.assertEquals(0, arr.getOccurrences(3));

        // switch arrays
        // 0, 0, 8, 8, 8, 9, 9, 9, 10, 10 (sorted)
        arr = TestData.sortedList4();
        Assertions.assertEquals(2, arr.getOccurrences(0));
        Assertions.assertEquals(3, arr.getOccurrences(8));
        Assertions.assertEquals(3, arr.getOccurrences(9));
        Assertions.assertEquals(0, arr.getOccurrences(11));
    }

    /**
     * Tests retrieving the index of the first occurrence of
     * <code>element</code> in a {@link SortedArrayList} object.
     */
    @Test
    public void test28() {
        // 0, 0, 8, 8, 8, 9, 9, 9, 10, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList4();
        Assertions.assertEquals(8, arr.indexOf(10));
        Assertions.assertEquals(2, arr.indexOf(8));
        Assertions.assertEquals(-1, arr.indexOf(2));
    }

    /**
     * Tests retrieving the index of the last occurrence of
     * <code>element</code> in a {@link SortedArrayList} object.
     */
    @Test
    public void test29() {
        // 0, 0, 8, 8, 8, 9, 9, 9, 10, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList4();
        Assertions.assertEquals(1, arr.lastIndexOf(0));
        Assertions.assertEquals(7, arr.lastIndexOf(9));
        Assertions.assertEquals(-1, arr.lastIndexOf(2));
    }

    /**
     * Tests indicating whether an <code>element</code> exists in a
     * {@link SortedArrayList} object.
     */
    @Test
    public void test30() {
        // 0, 0, 8, 8, 8, 9, 9, 9, 10, 10 (sorted)
        ArrayList<Integer> arr = TestData.sortedList4();
        Assertions.assertTrue(arr.contains(8));
        Assertions.assertFalse(arr.contains(2));
    }

    // Tests the general output methods of SortedArrayList

    /**
     * Tests exporting a {@link SortedArrayList} object to an array.
     *
     * NOT WORKING. Cannot cast Object to String at toArray() method.
     */
//    @Test
//    public void test31() {
//        ArrayList<String> arr = TestData.sortedList5();
//        // sort list before using
//        List<String> list = Arrays.asList("bat", "elk", "horse", "ermine", "bear",
//                "wolverine", "cheetah", "baboon", "parrot", "eland");
//        String[] output = arr.toArray();
//        for (int i = 0; i < list.size(); i++) {
//            Assertions.assertEquals(list.get(i), output[i]);
//        }
//    }

    /**
     * Tests displaying a {@link SortedArrayList} object as a String.
     */
    @Test
    public void test32() {
        ArrayList<String> arr = TestData.sortedList5();
        Assertions.assertEquals("[baboon bat bear cheetah eland elk " +
                "ermine horse parrot wolverine]", arr.toString());
    }

    // Tests other utility methods of SortedArrayList

    /**
     * Tests clearing a {@link SortedArrayList} object
     */
    @Test
    public void test33() {
        ArrayList<Integer> arr = TestData.sortedList2();
        Assertions.assertEquals(10, arr.size());
        arr.clear();
        Assertions.assertEquals(0, arr.size());
    }

    /**
     * Tests the iterator of a {@link SortedArrayList} object
     */
    @Test
    public void test34() {
        // -50, -10, -3, 0, 2, 5, 12, 23, 41, 90 (sorted)
        ArrayList<Integer> arr = TestData.sortedList2();
        // tests whether all values returned by next are correct
        Iterator<Integer> itr = arr.iterator();
        List<Integer> list =
                Arrays.asList(-50, -10, -3, 0, 2, 5, 12, 23, 41, 90);
        int i = 0;
        while (itr.hasNext()) {
            Assertions.assertEquals(list.get(i), itr.next());
            i++;
        }

        // tests whether the iterator is capable of removing an object
        itr = arr.iterator();
        list = Arrays.asList(-50, -10, -3, 0, 5, 12, 23, 41, 90);
        for (i = 0; i < 5; i++) {
            itr.next();
        }
        itr.remove();
        for (i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), arr.get(i));
        }
    }

}