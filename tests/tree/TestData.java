package tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Provides some methods to generate {@link Tree} objects as test data.
 *
 * @author Samuel Adrian Kosasih
 */
class TestData {

    /**
     * Compares the contents of two {@code Collection}s and ensures they have
     * the same order.
     *
     * @param collection the {@code Collection} to be examined
     * @param expected the {@code Collection} to be expected
     * @param <T> the generic type of the {@code Collection}
     * @return {@code true} if the two {@code Collection}s are identical
     */
    public static <T> boolean compareCollections(Collection<T> collection,
                                                 Collection<T> expected) {
        if (collection.size() == expected.size()) {
            Iterator<T> itr1 = collection.iterator();
            Iterator<T> itr2 = expected.iterator();
            while (itr1.hasNext() && itr2.hasNext()) {
                if (itr1.next() != itr2.next()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Creates a {@link BinaryTree} object with {@code Integer}s from {@code 1}
     * to {@code 15}. BFS traversal:
     * <blockquote>{@code 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
     * </blockquote>
     *
     * @return a {@code BinaryTree} object
     */
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

    /**
     * Creates a left-sided degenerate {@link BinaryTree} object with
     * {@code Integer}s from {@code 0} to {@code 10}. BFS traversal:
     * <blockquote>{@code 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}</blockquote>
     *
     * @return a {@code BinaryTree} object
     */
    public static Tree<Integer> binaryTree2() {
        Tree<Integer> tree = new BinaryTree<>(0);
        for (int i = 1; i < 11; i++) {
            tree.addAsChild(i - 1, i);
        }
        return tree;
    }

    /**
     * Creates a less organized {@link BinaryTree} object with {@code Integer}s
     * from {@code 0} to {@code 10}. Tree Diagram:
     * <pre>
     *             0
     *       1           5
     *   3       2           6
     *         4                7
     *       8   9            10
     * </pre>
     * If the diagram above is unclear, below is a list of every node's
     * children:
     * <pre>
     *     <ul>
     *         <li>{@code 0 -> 1} and {@code 5}</li>
     *         <li>{@code 1 -> 3} and {@code 2}</li>
     *         <li>{@code 2 -> 4} (left-child)</li>
     *         <li>{@code 3 -> } no children</li>
     *         <li>{@code 4 -> 8} and {@code 9}</li>
     *         <li>{@code 5 -> 6} (right-child)</li>
     *         <li>{@code 6 -> 7} (right-child)</li>
     *         <li>{@code 7 -> 10} (left-child)</li>
     *         <li>{@code 8 -> } no children</li>
     *         <li>{@code 9 -> } no children</li>
     *         <li>{@code 10 -> } no children</li>
     *     </ul>
     * </pre>
     *
     * @return a {@code BinaryTree} object
     */
    public static Tree<Integer> binaryTree3() {
        BinaryTree<Integer> tree = new BinaryTree<>(0);
        tree.addAsChild(0, 1);
        tree.addAsChild(0, 5);
        tree.addAsChild(1, 3);
        tree.addAsChild(1, 2);
        tree.addRightChild(5, 6);
        tree.addAsChild(2, 4);
        tree.addRightChild(6, 7);
        tree.addAsChild(4, 8);
        tree.addAsChild(4, 9);
        tree.addAsChild(7, 10);
        return tree;
    }

    /**
     * Creates a {@link BinarySearchTree} using the range of numbers from
     * {@code 1} to {@code 9}.
     *
     * <p> The numbers are entered in the order:</p>
     * <blockquote>5, 9, 1, 7, 3, 6, 8, 4, 2</blockquote>
     *
     * @return a {@code BinarySearchTree} object
     */
    public static Tree<Integer> binarySearchTree1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
        tree.add(9);
        tree.add(1);
        tree.add(7);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(4);
        tree.add(2);
        return tree;
    }

}
