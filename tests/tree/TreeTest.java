package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TreeTest {

    // Tests the general adding functionality of BinaryTree

    /**
     * Tests the general functionality of adding a {@code Collection}
     * of items into a {@link BinaryTree} object.
     */
    @Test
    public void test1() {
        Tree<Integer> tree = TestData.binaryTree1();
        Assertions.assertEquals(1, tree.root());
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                )));
    }

    /**
     * Tests the general functionality of adding a {@code Collection}
     * of items to one side of a {@link BinaryTree} object.
     */
    @Test
    public void test2() {
        Tree<Integer> tree = TestData.binaryTree2();
        Assertions.assertEquals(1, tree.root());
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    // Tests the general removing functionality of BinaryTree

    @Test
    public void test3() {
        Tree<Integer> tree = TestData.binaryTree1();
        tree.remove(2);
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 3, 6, 7, 12, 13, 14, 15)));
    }

    @Test
    public void randomTest() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addRoot(1);
        tree.addAsChild(1, 2);
        tree.addAsChild(1, 3);
        tree.addAsChild(2, 4);
        tree.addAsChild(2, 5);
        tree.removeChildren(2);
    }

}