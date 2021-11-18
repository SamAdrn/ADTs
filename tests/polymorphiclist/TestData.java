package polymorphiclist;

import java.util.Arrays;
import java.util.List;

/**
 * Provides some methods to generate {@link PolymorphicList} objects as test
 * data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Creates a {@link PolymorphicList} object with all positive
     * {@code Integer}s from {@code 1} to {@code 10} in the order:
     * <blockquote>{@code 1, 3, 9, 4, 5, 2, 10, 8, 6, 7}</blockquote>
     *
     * @return a {@code PolymorphicList} object
     */
    public static PolymorphicList<Integer> polymorphicList1() {
        List<Integer> list = Arrays.asList(1, 3, 9, 4, 5, 2, 10, 8, 6, 7);
        PolymorphicList<Integer> polyList = EmptyList.getInstance();
        for (int i : list) {
            polyList = polyList.add(i);
        }
        return polyList;
    }

    /**
     * Creates a {@link PolymorphicList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 2} in the order:
     * <blockquote>{@code 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}</blockquote>
     *
     * @return a {@code PolymorphicList} object
     */
    public static PolymorphicList<Integer> polymorphicList2() {
        List<Integer> list = Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2);
        PolymorphicList<Integer> polyList = EmptyList.getInstance();
        for (int i : list) {
            polyList = polyList.add(i);
        }
        return polyList;
    }

    /**
     * Creates a {@link PolymorphicList} object with repetitive
     * {@code Integer}s from {@code 0} to {@code 10} in the order:
     * <blockquote>{@code 0, 10, 9, 8, 10, 9, 0, 8, 8, 9}</blockquote>
     *
     * @return a {@code PolymorphicList} object
     */
    public static PolymorphicList<Integer> polymorphicList3() {
        List<Integer> list = Arrays.asList(0, 10, 9, 8, 10, 9, 0, 8, 8, 9);
        PolymorphicList<Integer> polyList = EmptyList.getInstance();
        for (int i : list) {
            polyList = polyList.add(i);
        }
        return polyList;
    }

    /**
     * Creates a {@link PolymorphicList} object with random {@code String}s
     * in the order:
     * <blockquote>{@code "bat", "elk", "horse", "ermine", "bear", "wolverine",
     * "cheetah", "baboon", "parrot", "eland"}</blockquote>
     *
     * @return a {@code PolymorphicList} object
     */
    public static PolymorphicList<String> polymorphicList4() {
        List<String> list = Arrays.asList("bat", "elk", "horse", "ermine",
                "bear", "wolverine", "cheetah", "baboon", "parrot", "eland");
        PolymorphicList<String> polyList = EmptyList.getInstance();
        for (String s : list) {
            polyList = polyList.add(s);
        }
        return polyList;
    }

}
