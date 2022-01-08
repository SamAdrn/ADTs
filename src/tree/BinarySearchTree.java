package tree;

/**
 * This class is an implementation of the {@link Tree} interface.
 *
 * <p> The Binary Search Tree is an implementation of {@link BinaryTree}, only
 * different in the way it stores elements, such that they are ordered
 * according to the value of their keys.
 *
 * <p> If an entry is greater than the root, it will be stored in the right
 * subtree, until it finds a suitable empty position to be placed. Otherwise, it
 * will be stored in the left subtree, following the same set of conditions,
 * only on a different side. </p>
 *
 * <p> With that being said, the user will no longer have power to choose the
 * position in which a certain element is to be stored, therefore, discontinuing
 * support for certain methods that exist in the {@link Tree} interface. </p>
 *
 * <p> As it is crucial for a Binary Search Tree to make key comparisons, this
 * class requires that its elements extend the {@link Comparable} interface, in
 * order to specify a specific form of comparison.</p>
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Tree} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see Tree
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Default Constructor.Initializes the root of the {@code Tree}.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Constructor.Initializes the root of the {@code Tree} with the element
     * {@code e}.
     */
    public BinarySearchTree(E e) {
        super(e);
    }

    /**
     * Adds the element {@code e} as the root.
     *
     * <p> If a root already exists, then this element will replace its original
     * value.
     *
     * @param e the element to set as the root
     * @return the element previously at the root, or {@code null} if there was
     * originally no root
     * @since 1.1
     * @deprecated this implementation does not support this method
     */
    @Override
    public E addRoot(E e) {
        throw new UnsupportedOperationException("the Binary Search Tree " +
                "implementation does not support this method");
    }

    /**
     * Adds the element {@code newChild} as a child of {@code parent}.
     *
     * <p> If the parent does not have a left child, then {@code newChild} will
     * take its place, otherwise, it will become a right child.
     *
     * <p> If the parent already has two nodes, then the method will return
     * {@code false}.
     *
     * @param parent   the parent of the new element to be added
     * @param newChild the new child element to be added
     * @return {@code true} if {@code newChild} is added successfully
     * @since 1.1
     * @deprecated this implementation does not support this method
     */
    @Override
    public boolean addAsChild(E parent, E newChild) {
        throw new UnsupportedOperationException("the Binary Search Tree " +
                "implementation does not support this method");
    }

    /**
     * Adds the element {@code newChild} as a left child of {@code parent}.
     *
     * <p> If the parent already has a left child, then the method will return
     * {@code false}.
     *
     * @param parent   the parent of the new element to be added
     * @param newChild the new child element to be added
     * @return {@code true} if {@code newChild} is added successfully
     * @since 1.1
     * @deprecated this implementation does not support this method
     */
    @Override
    public boolean addLeftChild(E parent, E newChild) {
        throw new UnsupportedOperationException("the Binary Search Tree " +
                "implementation does not support this method");
    }

    /**
     * Adds the element {@code newChild} as a right child of {@code parent}.
     *
     * <p> If the parent already has a right child, then the method will return
     * {@code false}.
     *
     * @param parent   the parent of the new element to be added
     * @param newChild the new child element to be added
     * @return {@code true} if {@code newChild} is added successfully
     * @since 1.1
     * @deprecated this implementation does not support this method
     */
    @Override
    public boolean addRightChild(E parent, E newChild) {
        throw new UnsupportedOperationException("the Binary Search Tree " +
                "implementation does not support this method");
    }

    /**
     * Adds the new element {@code e} to the {@code Tree}, placing it in its
     * appropriate position.
     *
     * @param e the new element to be added
     * @return {@code true} if {@code e} is added successfully
     * @since 1.1
     */
    public boolean add(E e) {
        root = add(e, root);
        return true;
    }

    /**
     * A private helper method to assist the {@link #add(Comparable)} method in
     * searching for an appropriate position for the element {@code e}.
     *
     * @param e the new element to be added
     * @param cur the node it is currently pointing to
     * @return references to the nodes it is traversing through
     * @since 1.1
     */
    private Node<E> add(E e, Node<E> cur) {
        if (cur == null) {
            return new Node<>(e);
        }
        if (e.compareTo(cur.element) >= 0) {
            cur.right = add(e, cur.right);
        } else {
            cur.left = add(e, cur.left);
        }
        return cur;
    }

    /**
     * Retrieves the smallest existing value in the {@code Tree}.
     *
     * @return the smallest value in the {@code Tree}
     * @since 1.1
     */
    public E minValue() {
        if (root == null) {
            throw new IllegalStateException("tree has no root");
        }
        Node<E> cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.element;
    }

    /**
     * Retrieves the greatest existing value in the {@code Tree}.
     *
     * @return the greatest value in the {@code Tree}
     * @since 1.1
     */
    public E maxValue() {
        if (root == null) {
            throw new IllegalStateException("tree has no root");
        }
        Node<E> cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.element;
    }

    /**
     * Removes the element {@code e} from the {@code Tree}.
     *
     * <p> If the element {@code e} is a parent, then all of its children will
     * be removed as well.
     *
     * @param e the element to be removed
     * @return {@code true} if {@code e} is removed successfully
     * @since 1.1
     */
    @Override
    public boolean remove(E e) {
        if (root == null) {
            throw new IllegalStateException("tree has no root");
        }
        return remove(e, root) != null;
    }

    /**
     * A private helper method to assist the {@link #remove(Comparable)} method
     * in removing the element {@code e} from the {@code Tree} and ensuring it
     * maintains the Binary Search Tree property.
     *
     * @param e the element to be removed
     * @param cur the node it is currently pointing to
     * @return references to the nodes it is traversing through
     * @since 1.1
     */
    private Node<E> remove(E e, Node<E> cur) {
        if (cur == null) {
            return null;
        }
        if (e.compareTo(cur.element) < 0) {
            cur.left = remove(e, cur.left);
        } else if (e.compareTo(cur.element) > 0) {
            cur.right = remove(e, cur.right);
        } else {
            if (cur.left == null) {
                return cur.right;
            } else if (cur.right == null) {
                return cur.left;
            } else {
                cur.element = minValue();
                cur.right = remove(cur.element, cur.right);
            }
        }
        return cur;
    }

    /**
     * Sets the first occurrence of element {@code e} to {@code newElement}.
     *
     * <p> Note that the breadth-first search will be used for the {@code Tree}.
     * This ultimately means that traversals will start from the root, and
     * traverse through every level of the {@code Tree}.
     *
     * @param e          the element to be replaced
     * @param newElement the element used to replace {@code e}
     * @return {@code true} if {@code e} is successfully replaced with
     * {@code newElement}
     * @since 1.1
     * @deprecated this implementation does not support this method
     */
    @Override
    public boolean set(E e, E newElement) {
        throw new UnsupportedOperationException("the Binary Search Tree " +
                "implementation does not support this method");
    }

    /**
     * A protected helper method to traverse through the {@code Tree} and
     * returns the {@code Node} which stores the element {@code e}. This method
     * will start to traverse the tree from the {@code Node n}.
     *
     * @param e the element of the {@code Node} to be searched
     * @param n the {@code Node} to start traversal
     * @return the {@code Node} storing the element {@code e}
     * @throws IllegalStateException if tree has no root
     * @since 1.1
     */
    @Override
    protected Node<E> findNode(E e, Node<E> n) {
        if (root == null) {
            throw new IllegalStateException("tree has no root");
        }
        if (n == null) {
            return null;
        } else if (e.compareTo(n.element) == 0) {
            return n;
        } else if (e.compareTo(n.element) > 0) {
            return findNode(e, n.right);
        } else {
            return findNode(e, n.left);
        }
    }
}
