package tree;

import queue.LinkedQueue;

import java.util.*;

/**
 * This class is an implementation of the {@link Tree} interface.
 *
 * <p> As it inherits the properties of a conventional {@code Tree}, a
 * {@code BinaryTree} is different in a way such that each element can only
 * parent a maximum number of two children (hence the name, binary). Each
 * element can now only have either a left child or a right child.
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Tree} would store.
 * @author Samuel Adrian Kosasih
 * @version 1.1
 * @see Tree
 */
public class BinaryTree<E> implements Tree<E> {

    /**
     * The root of the {@code Tree}.
     */
    protected Node<E> root;

    /**
     * The number of elements currently stored in the {@code Tree}.
     */
    protected int size;

    /**
     * This private inner class defines a node to be used for storing elements
     * in a {@code BinaryTree}.
     *
     * @param <E> generic type parameter determining the type of object the
     *            {@code BinaryTree} would store.
     */
    protected static class Node<E> {

        /**
         * The element being stored by the {@code Node}.
         */
        E element;

        /**
         * The left child subtree root of the {@code Node}.
         */
        Node<E> left;

        /**
         * The right child subtree root of the {@code Node}.
         */
        Node<E> right;

        /**
         * The parent of this {@code Node}.
         */
        Node<E> parent;

        /**
         * Constructor. Initializes the node's element to {@code e}.
         *
         * @param e the element to be stored by the {@code Node}.
         */
        public Node(E e) {
            element = e;
            left = null;
            right = null;
            parent = null;
        }

    }

    /**
     * Default Constructor.Initializes the root of the {@code Tree}.
     */
    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Constructor.Initializes the root of the {@code Tree} with the element
     * {@code e}.
     */
    public BinaryTree(E e) {
        root = new Node<>(e);
        size = 0;
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
     */
    @Override
    public E addRoot(E e) {
        if (root == null) {
            root = new Node<>(e);
            size++;
            return null;
        }
        E element = root.element;
        root.element = e;
        return element;
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
     */
    @Override
    public boolean addAsChild(E parent, E newChild) {
        Node<E> n = findNode(parent, root);
        if (n != null) {
            Node<E> newNode = new Node<>(newChild);
            newNode.parent = n;
            if (n.left == null) {
                n.left = newNode;
                size++;
                return true;
            } else if (n.right == null) {
                n.right = newNode;
                size++;
                return true;
            }
        }
        return false;
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
     */
    public boolean addLeftChild(E parent, E newChild) {
        Node<E> n = findNode(parent, root);
        if (n != null) {
            Node<E> newNode = new Node<>(newChild);
            newNode.parent = n;
            if (n.left == null) {
                n.left = newNode;
                size++;
                return true;
            }
        }
        return false;
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
     */
    public boolean addRightChild(E parent, E newChild) {
        Node<E> n = findNode(parent, root);
        if (n != null) {
            Node<E> newNode = new Node<>(newChild);
            newNode.parent = n;
            if (n.right == null) {
                n.right = newNode;
                size++;
                return true;
            }
        }
        return false;
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
        Node<E> n = findNode(e, root);
        if (n != null) {
            Node<E> p = n.parent;
            if (p.left.element.equals(e)) {
                p.left = null;
            } else {
                p.right = null;
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Removes all the children of {@code e}.
     *
     * <p> The returned {@code Collection} will be of type
     * {@link LinkedHashSet}, in which the first element will be the left child
     * of {@code e}, and the second element will be the right child of
     * {@code e}.
     *
     * <p> Note that the returned {@code Collection} will only consist of the
     * two direct children of {@code e}, and will not consist of the lower
     * descendants.
     *
     * <p> If the element {@code e} is not a parent, then an empty
     * {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * <p> If the {@code Tree} is empty, then an empty {@code Collection} is
     * returned.
     *
     * @param e the parent of the children to be removed
     * @return a {@code Collection} of elements that were once children of
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> removeChildren(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                LinkedHashSet<E> output = new LinkedHashSet<>(
                        Arrays.asList(n.left.element, n.right.element));
                n.left = null;
                n.right = null;
                return output;
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
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
     */
    @Override
    public boolean set(E e, E newElement) {
        Node<E> n = findNode(e, root);
        if (n != null) {
            n.element = newElement;
            return true;
        }
        return false;
    }

    /**
     * Retrieves the element stored as the root of the {@code Tree}.
     *
     * @return the element stored at the root
     * @since 1.1
     */
    @Override
    public E root() {
        if (root == null) {
            return null;
        }
        return root.element;
    }

    /**
     * Retrieves the parent of the first occurrence of {@code e}.
     *
     * <p> If {@code e} is the root, or if {@code e} is not found, then
     * {@code null} is returned.
     *
     * @param e the parent of the element to be retrieved
     * @return the element stored as the parent of {@code e}
     * @since 1.1
     */
    @Override
    public E parent(E e) {
        Node<E> n = findNode(e, root);
        if (n == root || n == null) {
            return null;
        }
        return n.parent.element;
    }

    /**
     * Retrieves a {@code Collection} of elements stored as the children of
     * {@code e}.
     *
     * <p> If the element {@code e} is not a parent, then an empty
     * {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * <p> If the {@code Tree} is empty, then an empty {@code Collection} is
     * returned.
     *
     * @param e the parent of the children to be retrieved
     * @return a {@code Collection} of elements stored as children of {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> children(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                LinkedHashSet<E> result = new LinkedHashSet<>();
                if (n.left != null) {
                    result.add(n.left.element);
                }
                if (n.right != null) {
                    result.add(n.right.element);
                }
                return result;
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Retrieves a {@code Collection} of elements stored at the level
     * {@code level} of the {@code Tree}.
     *
     * <p> If the {@code Tree} is empty or if the level {@code level} does not
     * exist, then an empty {@code Collection} will be returned.
     *
     * @param level the level of the {@code Tree} in which the elements to be
     *              returned are stored
     * @return a {@code Collection} of elements at {@code level}
     * @since 1.1
     */
    @Override
    public Collection<E> getNodesAtLevel(int level) {
        return getNodesAtLevel(level, root);
    }

    /**
     * A helper method to retrieve a {@code Collection} of elements stored at
     * the level {@code l} of the {@code Tree}.
     *
     * @param l the level of the {@code Tree} in which the elements to be
     *          returned are stored
     * @param n a cursor to the node the method is currently pointing to
     * @return a {@code Collection} of elements at {@code l}
     */
    private Collection<E> getNodesAtLevel(int l, Node<E> n) {
        Collection<E> c = new LinkedHashSet<>();
        if (n != null) {
            if (l == 0) {
                c.add(n.element);
            } else {
                c.addAll(getNodesAtLevel(l - 1, n.left));
                c.addAll(getNodesAtLevel(l - 1, n.right));
            }
        }
        return c;
    }

    /**
     * Returns a subtree rooted at element {@code e}.
     *
     * <p> Note that the elements returned will be in the traversal choice
     * specified in {@code traversalChoice}. Choices are listed as follows:
     * <pre>
     *     <ol>
     *         <li>Pre-order traversal</li>
     *         <li>Inorder traversal</li>
     *         <li>Post-order traversal</li>
     *         <li>Breadth-First search</li>
     *     </ol>
     * </pre>
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then an empty {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * <p> This method resembles calling any of the traversal methods provided
     * in this class. It is only an alternative method which provides access
     * to all the four traversal methods.
     *
     * @param e               the element to be rooted as the subtree
     * @param traversalChoice the traversal choice to be used
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> subtree(E e, int traversalChoice) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                switch (traversalChoice) {
                    case 1:
                        return preorder(n);
                    case 2:
                        return inorder(n);
                    case 3:
                        return postorder(n);
                    case 4:
                        return BFS(n);
                    default:
                        throw new IllegalArgumentException("traversal choice" +
                                "not recognized");
                }
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Retrieves the number of children owned by the element {@code e}.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then the method will return {@code 0}.
     *
     * <p> If element {@code e} does not exist, then it will return {@code -1}.
     *
     * @param e the element to be queried
     * @return the number of children owned by {@code e}
     * @since 1.1
     */
    @Override
    public int numChildren(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                return (n.left != null && n.right != null) ? 2 :
                        ((n.left != null || n.right != null) ? 1 : 0);
            }
            return -1;
        } catch (IllegalStateException ise) {
            return 0;
        }
    }

    /**
     * Retrieves the number of levels the {@code Tree} has.
     * <p>
     * If the tree is currently empty, then the tree is considered to have
     * {@code 0} levels.
     *
     * @return the number of levels in the {@code Tree}
     * @since 1.1
     */
    @Override
    public int level() {
        return level(root) + 1;
    }

    /**
     * A private helper method to retrieve the number of levels the {@code Tree}
     * has.
     *
     * @param n a cursor to the node the method is currently pointing to
     * @return the number of levels in the {@code Tree}
     * @since 1.1
     */
    private int level(Node<E> n) {
        if (n != null) {
            return Math.max(level(n.left), level(n.right)) + 1;
        }
        return -1;
    }

    /**
     * Indicates whether the element {@code e} is the root of the {@code Tree}.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} is the root of the {@code Tree}
     * @since 1.1
     */
    @Override
    public boolean isRoot(E e) {
        return root.element.equals(e);
    }

    /**
     * Indicates whether the element {@code e} is an internal element.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} has children
     * @since 1.1
     */
    @Override
    public boolean isInternal(E e) {
        Node<E> n = findNode(e, root);
        if (n != null) {
            return n.left != null || n.right != null;
        }
        return false;
    }

    /**
     * Indicates whether the element {@code e} is a leaf.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} has no children
     * @since 1.1
     */
    @Override
    public boolean isExternal(E e) {
        Node<E> n = findNode(e, root);
        if (n != null) {
            return n.parent != null;
        }
        return false;
    }

    /**
     * Retrieves the height of the element {@code e}.
     *
     * If the element does not exist, or if the tree is empty, then the method
     * will return {@code -1}.
     *
     * @param e the element to be queried
     * @return the height of the element {@code e}
     * @since 1.1
     */
    @Override
    public int height(E e) {
        try {
            return height(findNode(e, root));
        } catch (IllegalStateException ise) {
            return -1;
        }
    }

    /**
     * A private helper method to retrieve the height of the node {@code n}.
     *
     * If the element does not exist, or if the tree is empty, then the method
     * will return {@code -1}.
     *
     * @param n the node to be queried
     * @return the height of the node {@code n}
     * @since 1.1
     */
    private int height(Node<E> n) {
        if (n == null) {
            return -1;
        }
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    /**
     * Retrieves the depth of the element {@code e}.
     *
     * @param e the element to be queried
     * @return the depth of the element {@code e}
     * @since 1.1
     */
    @Override
    public int depth(E e) {
        try {
            return depth(findNode(e, root));
        } catch (IllegalStateException ise) {
            return -1;
        }
    }

    /**
     * A private helper method to retrieve the depth of the node {@code n}.
     *
     * @param n the node to be queried
     * @return the depth of the node {@code n}
     * @since 1.1
     */
    private int depth(Node<E> n) {
        if (n == null) {
            return -1;
        } else {
            return depth(n.parent) + 1;
        }
    }

    /**
     * Retrieves the number of elements currently stored in the {@code Tree}.
     *
     * @return the number of elements stored by the {@code Tree}
     * @since 1.1
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Indicates whether the element {@code e} exists in the {@code Tree}.
     *
     * @param e the element to be searched
     * @return {@code true} if the element {@code e} exists
     * @since 1.1
     */
    @Override
    public boolean contains(E e) {
        return findNode(e, root) != null;
    }

    /**
     * Indicates whether the {@code Tree} is currently storing any elements.
     *
     * @return {@code true} if the {@code Tree} is empty
     * @since 1.1
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the current {@code Tree} object.
     *
     * @since 1.1
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Retrieves a {@code Collection} of all the elements rooted at {@code e}
     * using pre-order traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then an empty {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * @param e the element where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> preorder(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                return preorder(n);
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Retrieves a {@code Collection} of all the elements rooted at {@code e}
     * using inorder traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then an empty {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * @param e the element where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> inorder(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                return inorder(n);
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Retrieves a {@code Collection} of all the elements rooted at {@code e}
     * using post-order traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then an empty {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * @param e the element where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> postorder(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                return postorder(n);
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Retrieves a {@code Collection} of all the elements rooted at {@code e}
     * using breadth-first search.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, then an empty {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * @param e the element where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    @Override
    public Collection<E> BFS(E e) {
        try {
            Node<E> n = findNode(e, root);
            if (n != null) {
                return BFS(n);
            }
            return null;
        } catch (IllegalStateException ise) {
            return new LinkedHashSet<>();
        }
    }

    /**
     * Returns an iterator over elements of type {@code E} arranged using a
     * breadth-first search traversal.
     *
     * @return an {@code Iterator}
     * @since 1.1
     */
    @Override
    public Iterator<E> iterator() {
        LinkedQueue<E> q = new LinkedQueue<>();
        Collection<E> c = BFS(root);
        for (E e : c) {
            q.add(e);
        }
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !q.isEmpty();
            }

            @Override
            public E next() {
                return q.poll();
            }
        };
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
    protected Node<E> findNode(E e, Node<E> n) {
        if (root == null) {
            throw new IllegalStateException("tree has no root");
        }
        if (n == null) {
            return null;
        } else if (Objects.equals(e, n.element)) {
            return n;
        } else {
            Node<E> l = findNode(e, n.left);
            Node<E> r = findNode(e, n.right);
            return l == null ? r : l;
        }
    }

    /**
     * A private helper method to retrieve a {@code Collection} of all the
     * elements rooted at the node {@code n} using pre-order traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, or if the node {@code n} is {@code null,} then an empty
     * {@code Collection} will be returned.
     *
     * @param n the node where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code n}
     * @since 1.1
     */
    private Collection<E> preorder(Node<E> n) {
        LinkedHashSet<E> c = new LinkedHashSet<>();
        if (n != null) {
            c.add(n.element);
            c.addAll(preorder(n.left));
            c.addAll(preorder(n.right));
        }
        return c;
    }

    /**
     * A private helper method to retrieve a {@code Collection} of all the
     * elements rooted at the node {@code n} using inorder traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, or if the node {@code n} is {@code null,} then an empty
     * {@code Collection} will be returned.
     *
     * @param n the node where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code n}
     * @since 1.1
     */
    private Collection<E> inorder(Node<E> n) {
        LinkedHashSet<E> c = new LinkedHashSet<>();
        if (n.left != null) {
            c.addAll(inorder(n.left));
        }
        c.add(n.element);
        if (n.right != null) {
            c.addAll(inorder(n.right));
        }
        return c;
    }

    /**
     * A private helper method to retrieve a {@code Collection} of all the
     * elements rooted at the node {@code n} using post-order traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, or if the node {@code n} is {@code null,} then an empty
     * {@code Collection} will be returned.
     *
     * @param n the node where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code n}
     * @since 1.1
     */
    private Collection<E> postorder(Node<E> n) {
        LinkedHashSet<E> c = new LinkedHashSet<>();
        if (n != null) {
            c.addAll(postorder(n.left));
            c.addAll(postorder(n.right));
            c.add(n.element);
        }
        return c;
    }

    /**
     * A private helper method to retrieve a {@code Collection} of all the
     * elements rooted at the node {@code n} using breadth-first search
     * traversal.
     *
     * <p> If the element {@code e} is not a parent, or if the {@code Tree} is
     * empty, or if the node {@code n} is {@code null,} then an empty
     * {@code Collection} will be returned.
     *
     * @param n the node where the traversal will start
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code n}
     * @since 1.1
     */
    private Collection<E> BFS(Node<E> n) {
        LinkedHashSet<E> c = new LinkedHashSet<>();
        if (n != null) {
            LinkedQueue<Node<E>> q = new LinkedQueue<>();
            q.add(n);
            while (!q.isEmpty()) {
                Node<E> cur = q.remove();
                c.add(cur.element);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return c;
    }

}
