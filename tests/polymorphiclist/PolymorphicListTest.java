package polymorphiclist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Provides tests for the implementations of the {@link PolymorphicList}.
 *
 * @author Samuel Adrian Kosasih
 */
class PolymorphicListTest {

    // Tests the general adding functionality of PolymorphicList

    /**
     * Tests the general functionality of adding elements into a
     * {@link PolymorphicList} object.
     */
    @Test
    public void test1() {
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        int polyListSize = polyList.size();
        for (int i = 0; i < polyListSize; i++) {
            Assertions.assertEquals(list.get(i), polyList.get(i));
        }
    }

    /**
     * Tests adding elements to different indices across a
     * {@link PolymorphicList} object.
     */
    @Test
    public void test2() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        polyList = polyList.add(10, 0);
        polyList = polyList.add(11, 6);
        polyList = polyList.add(12, 12);
        List<Integer> list =
                Arrays.asList(10, 1, 3, 9, 4, 5, 11, 2, 10, 8, 6, 7, 12);
        int polyListSize = polyList.size();
        for (int i = 0; i < polyListSize; i++) {
            Assertions.assertEquals(list.get(i), polyList.get(i));
        }
    }

    // Tests the general removing functionality of PolymorphicList

    /**
     * Tests removing elements at different indices in a
     * {@link PolymorphicList} object.
     */
    @Test
    public void test3() throws EmptyListException {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        polyList = polyList.remove(2);
        polyList = polyList.remove(0);
        int polyListSize = polyList.size();
        polyList = polyList.remove(polyListSize);
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 10, 8, 6);
        polyListSize = polyList.size();
        for (int i = 0; i < polyListSize; i++) {
            Assertions.assertEquals(list.get(i), polyList.get(i));
        }
    }

    /**
     * Tests removing elements in a {@link PolymorphicList} object.
     */
    @Test
    public void test4() throws EmptyListException {
        //"bat", "elk", "horse", "ermine", "bear", "wolverine", "cheetah",
        //"baboon", "parrot", "eland"
        PolymorphicList<String> polyList = TestData.polymorphicList4();
        polyList = polyList.remove("bat");
        polyList = polyList.remove("ermine");
        polyList = polyList.remove("eland");
        List<String> list = Arrays.asList("elk", "horse", "bear", "wolverine",
                "cheetah", "baboon", "parrot");
        int polyListSize = polyList.size();
        for (int i = 0; i < polyListSize; i++) {
            Assertions.assertEquals(list.get(i), polyList.get(i));
        }
    }

    // Tests the set functionality of PolymorphicList

    /**
     * Tests replacing a value at a certain index in a {@link PolymorphicList}
     * object.
     */
    @Test
    public void test5() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        polyList = polyList.set(3, 15);
        List<Integer> list = Arrays.asList(1, 3, 9, 15, 5, 2, 10, 8, 6, 7);
        int polyListSize = polyList.size();
        for (int i = 0; i < polyListSize; i++) {
            Assertions.assertEquals(list.get(i), polyList.get(i));
        }
    }

    // Tests the general get functionality of PolymorphicList

    /**
     * Tests getting the head and tail of a {@link PolymorphicList} object.
     */
    @Test
    public void test6() throws EmptyListException {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        Assertions.assertEquals(1, polyList.head());
        Assertions.assertEquals(7, polyList.tail());
    }

    /**
     * Tests getting the occurrences of an element in a {@link PolymorphicList}
     * object.
     */
    @Test
    public void test7() {
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        PolymorphicList<Integer> polyList = TestData.polymorphicList2();
        Assertions.assertEquals(3, polyList.getOccurrences(0));
        Assertions.assertEquals(5, polyList.getOccurrences(1));
        Assertions.assertEquals(2, polyList.getOccurrences(2));
        // 0, 10, 9, 8, 10, 9, 0, 8, 8, 9
        polyList = TestData.polymorphicList3();
        Assertions.assertEquals(2, polyList.getOccurrences(0));
        Assertions.assertEquals(3, polyList.getOccurrences(9));
        Assertions.assertEquals(3, polyList.getOccurrences(8));
    }

    /**
     * Tests getting the index of the first occurrence of an element in a
     * {@link PolymorphicList} object.
     */
    @Test
    public void test8() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        Assertions.assertEquals(0, polyList.indexOf(1));
        Assertions.assertEquals(4, polyList.indexOf(5));
        Assertions.assertEquals(9, polyList.indexOf(7));
        // 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
        polyList = TestData.polymorphicList2();
        Assertions.assertEquals(0, polyList.indexOf(0));
        Assertions.assertEquals(3, polyList.indexOf(1));
        Assertions.assertEquals(8, polyList.indexOf(2));
    }

    // Tests other utility methods of PolymorphicList

    /**
     * Tests indicating whether an element exists in a {@link PolymorphicList}
     * object.
     */
    @Test
    public void test9() {
        // 1, 3, 9, 4, 5, 2, 10, 8, 6, 7
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        Assertions.assertTrue(polyList.contains(9));
        Assertions.assertTrue(polyList.contains(7));
        Assertions.assertFalse(polyList.contains(0));
    }

    /**
     * Tests indicating whether a {@link PolymorphicList} object is empty.
     */
    @Test
    public void test10() {
        PolymorphicList<Integer> polyList = EmptyList.getInstance();
        Assertions.assertTrue(polyList.isEmpty());
        polyList = polyList.add(10);
        Assertions.assertFalse(polyList.isEmpty());
    }

    /**
     * Tests clearing a {@link PolymorphicList} object
     */
    @Test
    public void test11() {
        PolymorphicList<Integer> polyList = TestData.polymorphicList1();
        Assertions.assertEquals(10, polyList.size());
        polyList = polyList.clear();
        Assertions.assertEquals(0, polyList.size());
    }

    /**
     * Tests displaying a {@link PolymorphicList} object as a {@code String}.
     */
    @Test
    public void test12() {
        PolymorphicList<Integer> intPolyList = TestData.polymorphicList1();
        Assertions.assertEquals("1 3 9 4 5 2 10 8 6 7",
                intPolyList.toString());
        PolymorphicList<String> stringPolyList = TestData.polymorphicList4();
        Assertions.assertEquals("bat elk horse ermine bear wolverine " +
                        "cheetah baboon parrot eland",
                stringPolyList.toString());
    }

}