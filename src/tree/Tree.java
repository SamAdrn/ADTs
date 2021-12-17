package tree;

import java.util.Collection;

/**
 * This interface represents the root interface of all {@code Tree} objects.
 *
 * <p> The tree resembles much like a linked list when it comes to storing
 * objects using nodes. However, the nodes are not stored in a linear fashion,
 * rather hierarchical. Each node can parent their own nodes, otherwise known as
 * children. The whole tree structure is represented by a single node at the top
 * of the tree known as the root. The bottom-most nodes are known as leaf nodes,
 * and they are nodes that have no children.
 *
 * <p> There are certain ways to traverse through a non-linear structure such
 * as a tree. The four traversals included in this interface are
 * {@link #preorder pre-order}, {@link #inorder}, {@link #postorder post-order},
 * and {@link #BFS breath-first search}. Each traversal is unique in the way it
 * chooses the path it goes through.
 *
 * @author Samuel Adrian Kosasih
 *
 * @param <E> generic type parameter determining the type of object the
 *            {@code Tree} would store.
 *
 * @version 1.1
 */
public interface Tree<E> extends Iterable<E> {

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
    E addRoot(E e);

    /**
     * Adds the element {@code newChild} as a child of {@code parent}.
     *
     * @param parent the parent of the new element to be added
     * @param newChild the new child element to be added
     * @return {@code true} if {@code newChild} is added successfully
     * @since 1.1
     */
    boolean addAsChild(E parent, E newChild);

    /**
     * Removes the element {@code e} from the {@code Tree}.
     *
     * <p> If the element {@code e} is a parent, then the parent of {@code e}
     * will inherit all children of {@code e}.
     *
     * @param e the element to be removed
     * @return {@code true} if {@code e} is removed successfully
     * @since 1.1
     */
    boolean remove(E e);

    /**
     * Removes all the children of {@code e}.
     *
     * <p> If the element {@code e} is not a parent, then an empty
     * {@code Collection} will be returned.
     *
     * <p> If element {@code e} does not exist, then it will return
     * {@code null}.
     *
     * @param e the parent of the children to be removed
     * @return a {@code Collection} of elements that were once children of
     * {@code e}
     * @since 1.1
     */
    Collection<E> removeChildren(E e);

    /**
     * Sets the first occurrence of element {@code e} to {@code newElement}.
     *
     * <p> Note that the pre-order traversal will be used for the {@code Tree}.
     * This ultimately means that traversals will start from the root, and
     * traverse deep down the left subtree before it gets to the right subtree.
     *
     * @param e the element to be replaced
     * @param newElement the element used to replace {@code e}
     * @return {@code true} if {@code e} is successfully replaced with
     * {@code newElement}
     * @since 1.1
     */
    boolean set(E e, E newElement);

    /**
     * Retrieves the element stored as the root of the {@code Tree}.
     *
     * @return the element stored at the root
     * @since 1.1
     */
    E root();

    /**
     * Retrieves the parent of the first occurrence of {@code e}.
     *
     * @param e the parent of the element to be retrieved
     * @return the element stored as the parent of {@code e}
     * @since 1.1
     */
    E parent(E e);

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
     * @param e the parent of the children to be retrieved
     * @return a {@code Collection} of elements stored as children of {@code e}
     * @since 1.1
     */
    Collection<E> children(E e);

    /**
     * Retrieves a {@code Collection} of elements stored at the level
     * {@code level} of the {@code Tree}.
     *
     * <p> If the {@code Tree} is empty, then an empty {@code Collection} will
     * be returned.
     *
     * <p> If the level {@code level} does not exist, then the method will
     * return {@code null}.
     *
     * @param level the level of the {@code Tree} in which the elements to be
     *              returned are stored
     * @return a {@code Collection} of elements at {@code level}
     * @since 1.1
     */
    Collection<E> getNodesAtLevel(int level);

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
     * @param e the element to be rooted as the subtree
     * @param traversalChoice the traversal choice to be used
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    Collection<E> subtree(E e, int traversalChoice);

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
    int numChildren(E e);

    /**
     * Retrieves the number of levels the {@code Tree} has.
     *
     * @return the number of levels in the {@code Tree}
     * @since 1.1
     */
    int level();

    /**
     * Indicates whether the element {@code e} is the root of the {@code Tree}.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} is the root of the {@code Tree}
     * @since 1.1
     */
    boolean isRoot(E e);

    /**
     * Indicates whether the element {@code e} is an internal element.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} has children
     * @since 1.1
     */
    boolean isInternal(E e);

    /**
     * Indicates whether the element {@code e} is a leaf.
     *
     * @param e the element to be queried
     * @return {@code true} if {@code e} has no children
     * @since 1.1
     */
    boolean isExternal(E e);

    /**
     * Retrieves the height of the element {@code e}.
     *
     * @param e the element to be queried
     * @return the height of the element {@code e}
     * @since 1.1
     */
    int height(E e);

    /**
     * Retrieves the depth of the element {@code e}.
     *
     * @param e the element to be queried
     * @return the depth of the element {@code e}
     * @since 1.1
     */
    int depth(E e);

    /**
     * Retrieves the number of elements currently stored in the {@code Tree}.
     *
     * @return the number of elements stored by the {@code Tree}
     * @since 1.1
     */
    int size();

    /**
     * Indicates whether the element {@code e} exists in the {@code Tree}.
     *
     * @param e the element to be searched
     * @return {@code true} if the element {@code e} exists
     * @since 1.1
     */
    boolean contains(E e);

    /**
     * Indicates whether the {@code Tree} is currently storing any elements.
     *
     * @return {@code true} if the {@code Tree} is empty
     * @since 1.1
     */
    boolean isEmpty();

    /**
     * Clears the current {@code Tree} object.
     * @since 1.1
     */
    void clear();

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
     * @param e the root of the traversal
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    Collection<E> preorder(E e);

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
     * @param e the root of the traversal
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    Collection<E> inorder(E e);

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
     * @param e the root of the traversal
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    Collection<E> postorder(E e);

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
     * @param e the root of the traversal
     * @return a {@code Collection} of elements in the subtree rooted at
     * {@code e}
     * @since 1.1
     */
    Collection<E> BFS(E e);

}
