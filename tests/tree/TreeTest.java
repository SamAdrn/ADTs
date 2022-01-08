package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class TreeTest {

    // Tests the general adding functionality of BinaryTree

    /**
     * Tests the general functionality of adding items into a {@link BinaryTree}
     * object.
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
     * Tests the general functionality of adding items to one side of a
     * {@link BinaryTree} object.
     */
    @Test
    public void test2() {
        Tree<Integer> tree = TestData.binaryTree2();
        Assertions.assertEquals(0, tree.root());
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    // Tests the general removing functionality of BinaryTree

    /**
     * Tests the general functionality of removing a parent from a
     * {@link BinaryTree} object.
     */
    @Test
    public void test3() {
        Tree<Integer> tree = TestData.binaryTree1();
        tree.remove(2);
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 3, 6, 7, 12, 13, 14, 15)));
    }

    /**
     * Tests the general functionality of removing the children of a node from
     * a {@link BinaryTree} object.
     */
    @Test
    public void test4() {
        Tree<Integer> tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(
                tree.removeChildren(2), Arrays.asList(4, 5)));
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 2, 3, 6, 7, 12, 13, 14, 15)));
    }

    // Tests the general replacing functionality of BinaryTree

    /**
     * Tests the general functionality of replacing an element of a node from
     * a {@link BinaryTree} object.
     */
    @Test
    public void test5() {
        Tree<Integer> tree = TestData.binaryTree1();
        tree.set(2, 20);
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 20, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                        13, 14, 15)));
    }

    /**
     * Tests replacing an element of a node that does not exist in the
     * {@link BinaryTree} object.
     */
    @Test
    public void test6() {
        Tree<Integer> tree = TestData.binaryTree1();
        Assertions.assertFalse(tree.set(20, 2));
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                        13, 14, 15)));
    }

    // Tests the general retrieval methods of BinaryTree

    /**
     * Tests obtaining the parent of a node in a {@link BinaryTree}
     */
    @Test
    public void test7() {
        Tree<Integer> tree = TestData.binaryTree1();
        Assertions.assertEquals(1, tree.parent(2));
        Assertions.assertEquals(2, tree.parent(4));
        Assertions.assertEquals(4, tree.parent(8));
        Assertions.assertNull(tree.parent(1));
    }

    /**
     * Tests obtaining the children of a node in a {@link BinaryTree}
     */
    @Test
    public void test8() {
        // tree is empty
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.children(1)));
        // fill up tree
        tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(Arrays.asList(2, 3),
                tree.children(1)));
        Assertions.assertTrue(TestData.compareCollections(Arrays.asList(4, 5),
                tree.children(2)));
        Assertions.assertTrue(TestData.compareCollections(Arrays.asList(6, 7),
                tree.children(3)));
        // no children
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.children(15)));
        // element doesn't exist
        Assertions.assertNull(tree.children(20));
        // degenerate tree
        tree = TestData.binaryTree2();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.singletonList(2), tree.children(1)));
    }

    /**
     * Tests retrieving a {@code Collection} of nodes at a certain level in the
     * {@link BinaryTree}
     */
    @Test
    public void test9() {
        // empty tree
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.getNodesAtLevel(0)));
        // fill up tree
        tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.singletonList(1), tree.getNodesAtLevel(0)));
        Assertions.assertTrue(TestData.compareCollections(Arrays.asList(2, 3),
                tree.getNodesAtLevel(1)));
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(4, 5, 6, 7), tree.getNodesAtLevel(2)));
    }

    /**
     * Tests retrieving a {@code Collection} of nodes of a subtree rooted at a
     * specific node in a {@link BinaryTree}
     */
    @Test
    public void test10() {
        // empty tree
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.subtree(0, 1)));
        tree = TestData.binaryTree1();
        // subtree at root, basically the whole tree
        Assertions.assertTrue(TestData.compareCollections(
               Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                tree.subtree(1, 4)));
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(2, 4, 5, 8, 9, 10, 11),
                tree.subtree(2, 4)));
        // a more jumbled tree
        tree = TestData.binaryTree3();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(5, 6, 7, 10), tree.subtree(5, 4)));
    }

    /**
     * Tests retrieving the number of children a specific node has in a
     * {@link BinaryTree}
     */
    @Test
    public void test11() {
        // empty tree
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertEquals(0, tree.numChildren(1));
        // fill up tree
        tree = TestData.binaryTree3();
        Assertions.assertEquals(2, tree.numChildren(1));
        Assertions.assertEquals(1, tree.numChildren(5));
        Assertions.assertEquals(0, tree.numChildren(10));
        Assertions.assertEquals(-1, tree.numChildren(11));
    }

    /**
     * Tests retrieving the number of levels a {@link BinaryTree} has
     */
    @Test
    public void test12() {
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertEquals(0, tree.level());
        tree = new BinaryTree<>(1);
        Assertions.assertEquals(1, tree.level());
        tree = TestData.binaryTree1();
        Assertions.assertEquals(4, tree.level());
        tree = TestData.binaryTree2();
        Assertions.assertEquals(11, tree.level());
        tree = TestData.binaryTree3();
        Assertions.assertEquals(5, tree.level());
    }

    /**
     * Tests retrieving the height of a certain node in the {@link BinaryTree}
     */
    @Test
    public void test13() {
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertEquals(-1, tree.height(0));
        tree = new BinaryTree<>(1);
        Assertions.assertEquals(0, tree.height(1));
        tree.addAsChild(1, 2);
        Assertions.assertEquals(1, tree.height(1));
        tree = TestData.binaryTree3();
        Assertions.assertEquals(4, tree.height(0));
        Assertions.assertEquals(3, tree.height(1));
    }

    /**
     * Tests retrieving the depth of a certain node in the {@link BinaryTree}
     */
    @Test
    public void test14() {
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertEquals(-1, tree.depth(0));
        tree = new BinaryTree<>(1);
        Assertions.assertEquals(0, tree.depth(1));
        tree.addAsChild(1, 2);
        Assertions.assertEquals(0, tree.depth(1));
        Assertions.assertEquals(1, tree.depth(2));
        tree = TestData.binaryTree3();
        Assertions.assertEquals(2, tree.depth(3));
        Assertions.assertEquals(4, tree.depth(10));
    }

    // Tests the traversal methods of BinaryTree

    /**
     * Tests the preorder traversal algorithm of the {@link BinaryTree}
     */
    @Test
    public void test15() {
        // root - left - right
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.preorder(0)));
        tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(
               Arrays.asList(1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15),
                tree.preorder(1)));
        tree = TestData.binaryTree2();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                tree.preorder(0)));
        tree = TestData.binaryTree3();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(0, 1, 3, 2, 4, 8, 9, 5, 6, 7, 10),
                tree.preorder(0)));
    }

    /**
     * Tests the inorder traversal algorithm of the {@link BinaryTree}
     */
    @Test
    public void test16() {
        // left - root - right
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.inorder(0)));
        tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(
               Arrays.asList(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15),
                tree.inorder(1)));
        tree = TestData.binaryTree2();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                tree.inorder(0)));
        tree = TestData.binaryTree3();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(3, 1, 8, 4, 9, 2, 0, 5, 6, 10, 7),
                tree.inorder(0)));
    }

    /**
     * Tests the postorder traversal algorithm of the {@link BinaryTree}
     */
    @Test
    public void test17() {
        // left - right - root
        Tree<Integer> tree = new BinaryTree<>();
        Assertions.assertTrue(TestData.compareCollections(
                Collections.emptyList(), tree.postorder(0)));
        tree = TestData.binaryTree1();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1),
                tree.postorder(1)));
        tree = TestData.binaryTree2();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                tree.inorder(0)));
        tree = TestData.binaryTree3();
        Assertions.assertTrue(TestData.compareCollections(
                Arrays.asList(3, 1, 8, 4, 9, 2, 0, 5, 6, 10, 7),
                tree.inorder(0)));
    }

    // Tests the general adding functionality of BinarySearchTree

    /**
     * Tests the general functionality of adding items into a
     * {@link BinarySearchTree} object.
     */
    @Test
    public void test18() {
        Tree<Integer> tree = TestData.binarySearchTree1();
        Assertions.assertEquals(5, tree.root());
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(5, 1, 9, 3, 7, 2, 4, 6, 8)));
    }

    // Tests the general removing functionality of BinarySearchTree

    /**
     * Tests the general functionality of removing an element from a
     * {@link BinarySearchTree} object.
     */
    @Test
    public void test19() {
        Tree<Integer> tree = TestData.binarySearchTree1();
        tree.remove(9);
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(5, 1, 7, 3, 6, 8, 2, 4)));
    }

    // Tests the general retrieval methods of BinarySearchTree

    /**
     * Tests the general functionality of removing an element from a
     * {@link BinarySearchTree} object.
     */
    @Test
    public void test20() {
        BinarySearchTree<Integer> tree = (BinarySearchTree<Integer>)
                TestData.binarySearchTree1();
        Assertions.assertEquals(9, tree.maxValue());
        Assertions.assertEquals(1, tree.minValue());
    }

    // Tests the traversal methods of BinarySearchTree

    /**
     * Tests all traversal algorithms on a {@link BinarySearchTree}
     */
    @Test
    public void test21() {
        Tree<Integer> tree = TestData.binarySearchTree1();
        Assertions.assertTrue(TestData.compareCollections(tree.BFS(tree.root()),
                Arrays.asList(5, 1, 9, 3, 7, 2, 4, 6, 8)));
        Assertions.assertTrue(TestData.compareCollections(
                tree.preorder(tree.root()),
                Arrays.asList(5, 1, 3, 2, 4, 9, 7, 6, 8)
        ));
        Assertions.assertTrue(TestData.compareCollections(
                tree.postorder(tree.root()),
                Arrays.asList(2, 4, 3, 1, 6, 8, 7, 9, 5)
        ));
        Assertions.assertTrue(TestData.compareCollections(
                tree.inorder(tree.root()),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        ));
    }

}