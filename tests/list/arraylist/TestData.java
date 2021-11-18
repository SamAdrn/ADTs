package list.arraylist;

import java.util.Arrays;

/**
 * Provides some methods to generate {@link ArrayList} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Creates a {@link DefaultArrayList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code DefaultArrayList} object
     */
    public static ArrayList<Integer> defaultList1() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return arr;
    }

    /**
     * Creates a {@link DefaultArrayList} object with a mix of positive and
     * negative {@code Integer}s in the order:
     * <blockquote>{@code 0, -3, 12, -50, 41, 2, -10, 90, 23, 5}</blockquote>
     *
     * @return a {@code DefaultArrayList} object
     */
    public static ArrayList<Integer> defaultList2() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return arr;
    }

    /**
     * Creates a {@link DefaultArrayList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 2} in the order:
     * <blockquote>{@code 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}</blockquote>
     *
     * @return a {@code DefaultArrayList} object
     */
    public static ArrayList<Integer> defaultList3() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return arr;
    }

    /**
     * Creates a {@link DefaultArrayList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 10} in the order:
     * <blockquote>{@code 0, 10, 9, 8, 10, 9, 0, 8, 8, 9}</blockquote>
     *
     * @return a {@code DefaultArrayList} object
     */
    public static ArrayList<Integer> defaultList4() {
        ArrayList<Integer> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return arr;
    }

    /**
     * Creates a {@link DefaultArrayList} object with random {@code String}s
     * in the order:
     * <blockquote>{@code "bat", "elk", "horse", "ermine", "bear", "wolverine",
     * "cheetah", "baboon", "parrot", "eland"}</blockquote>
     *
     * @return a {@code DefaultArrayList} object
     */
    public static ArrayList<String> defaultList5() {
        ArrayList<String> arr = new DefaultArrayList<>();
        arr.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return arr;
    }

    /**
     * Creates a {@link ComparableArrayList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code ComparableArrayList} object
     */
    public static ArrayList<Integer> comparableList1() {
        ArrayList<Integer> arr = new ComparableArrayList<>();
        arr.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return arr;
    }

    /**
     * Creates a {@link SortedArrayList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} added in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code SortedArrayList} object
     */
    public static ArrayList<Integer> sortedList1() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7));
        return arr;
    }

    /**
     * Creates a {@link SortedArrayList} object with a mix of positive and
     * negative {@code Integer}s added in the order:
     * <blockquote>{@code 0, -3, 12, -50, 41, 2, -10, 90, 23, 5}</blockquote>
     *
     * @return a {@code SortedArrayList} object
     */
    public static ArrayList<Integer> sortedList2() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, -3, 12, -50, 41, 2, -10, 90, 23, 5));
        return arr;
    }

    /**
     * Creates a {@link SortedArrayList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 2} added in the order:
     * <blockquote>{@code 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}</blockquote>
     *
     * @return a {@code SortedArrayList} object
     */
    public static ArrayList<Integer> sortedList3() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2));
        return arr;
    }

    /**
     * Creates a {@link SortedArrayList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 10} added in the order:
     * <blockquote>{@code 0, 10, 9, 8, 10, 9, 0, 8, 8, 9}</blockquote>
     *
     * @return a {@code SortedArrayList} object
     */
    public static ArrayList<Integer> sortedList4() {
        ArrayList<Integer> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9));
        return arr;
    }

    /**
     * Creates a {@link SortedArrayList} object with random {@code String}s
     * added in the order:
     * <blockquote>{@code "bat", "elk", "horse", "ermine", "bear", "wolverine",
     * "cheetah", "baboon", "parrot", "eland"}</blockquote>
     *
     * @return a {@code SortedArrayList} object
     */
    public static ArrayList<String> sortedList5() {
        ArrayList<String> arr = new SortedArrayList<>();
        arr.addAll(Arrays.asList("bat", "elk", "horse", "ermine", "bear",
                "wolverine", "cheetah", "baboon", "parrot", "eland"));
        return arr;
    }

}
