package tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Provides some methods to generate {@link Tree} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    public static <T> boolean compareCollections(Collection<T> collection,
                                                 Collection<T> expected) {
        return collection.containsAll(expected) &&
                expected.containsAll(collection);
    }

    public static Tree<Integer> binaryTree1() {
        Tree<Integer> tree = new BinaryTree<>(1);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15);
        for (int i = 1; i < list.size(); i++) {
            int p = Math.floorDiv((i - 1) , 2);
            tree.addAsChild(list.get(p), list.get(i));
        }
        return tree;
    }

    public static Tree<Integer> binaryTree2() {
        Tree<Integer> tree = new BinaryTree<>(1);
        for (int i = 1; i < 11; i++) {
            tree.addAsChild(i - 1, i);
        }
        return tree;
    }

}
