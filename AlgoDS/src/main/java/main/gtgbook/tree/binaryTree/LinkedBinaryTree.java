package main.gtgbook.tree.binaryTree;

import main.gtgbook.positionallist.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    /*NESTED NODE CLASS*/
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        //ctor for node with element and all neighbors
        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
    }

    /*FACTORY PATTERN FUNCTION TO CREATE A NEW NODE*/
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    /*LINKED BINARY TREE PROPER*/
    protected Node<E> root = null;
    private int size = 0; //number of nodes in tree

    public LinkedBinaryTree() {
    }

    /**
     * Validates a position and returns node
     *
     * @param p {Position} a new position to be updated to the tree
     * @return {Node} a valid Node for the tree
     * @throws IllegalArgumentException if position is not a well formed Node, or position is no longer in tree
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }

        Node<E> node = (Node<E>) p; //safe cast
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p is no longer in tree");
        }

        return node;
    }

    /*Implementations*/
    //Accessor methods
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    //Update methods

    /**
     * Place new element at root of empty tree
     *
     * @param e {E} new element to be added
     * @return {Position} the position of the newly added position
     * @throws IllegalStateException if tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }

        this.root = createNode(e, null, null, null);
        this.size = 1;
        return root;
    }

    /**
     * Create left child for a position
     *
     * @param p {Position} position to become a parent
     * @param e {E} the element to be made a left child
     * @return {Position} successfully created left child
     * @throws IllegalArgumentException if position already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("Position p already has a left child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        this.size++;

        return child;
    }

    /**
     * Create right child for a position
     *
     * @param p {Position} position to become a parent
     * @param e {E} the element to be made a right child
     * @return {Position} successfully created right child
     * @throws IllegalArgumentException if position already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getRight() != null) {
            throw new IllegalArgumentException("Position p already has a right child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        this.size++;

        return child;
    }

    /**
     * Replaces element at position
     *
     * @param p {Position} position to be updated
     * @param e {E} new element to update
     * @return {E} returns the replaced element
     * @throws IllegalArgumentException if position fails validation
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    /**
     * Attaches two trees as left and right subtrees of an external position
     *
     * @param p  {Position} the external Position to receive the new subtrees
     * @param t1 {LinkedBinaryTree} a valid subtree
     * @param t2 {LinkedBinaryTree} a valid subtree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("Position p is not a leaf");
        }

        this.size += t1.size() + t2.size();

        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);

            //t1 is now attached, prep for garbage collection
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);

            //t2 is now attached, prep for garbage collection
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes node at position, replace with child if any
     *
     * @param p {Position} a valid position in tree
     * @return {E} the removed element
     * @throws IllegalArgumentException if position has 2 elements
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("Position p has 2 children");
        }

        //get child and attach it to node's parent in the place of the node
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());
        }

        //if removing root, set that child as new root
        if (node == root) {
            root = child;
        } else {
            //else, attach parent to new child
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        this.size--;

        //help garbage collection by nulling
        E removed = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(null);

        return removed;
    }
}
