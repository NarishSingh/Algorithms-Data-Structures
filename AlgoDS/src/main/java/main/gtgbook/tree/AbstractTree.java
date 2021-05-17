package main.gtgbook.tree;

import main.gtgbook.positionallist.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An abstract class to implement behavior for all trees
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Get the depth of an element in tree
     *
     * @param p {Position} a position of an element in tree
     * @return {int} the number of levels from position to the root
     */
    public int depth(Position<E> p) {
        return isRoot(p) ? 0 : 1 + depth(parent(p));
    }

    /**
     * Get the height of an element in tree
     *
     * @param p {Position} a position of an element in tree
     * @return {int} the max of the depths of its positions
     */
    public int height(Position<E> p) {
        int h = 0; //base case if external

        //loop through the children of p and track the max amongst the heights of the subtrees (recursion)
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }

        return h;
    }

    /*-------TRAVERSAL ALGO'S-------*/
    @Override
    public Iterable<Position<E>> positions() {
        return preorder(); //by default will use the preorder traversal algo
    }

    /*PREORDER*/

    /**
     * Add a root, then add positions of the subtree to a snapshot - for recursion
     *
     * @param p        {Position} root for subtree
     * @param snapshot {List} a list of positions within the subtree
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); //since preorder, add position first
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    /**
     * Preorder traversal - visit root -> then visit subtrees recursively
     *
     * @return {Iterable} an iterable of all positions in tree
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot); //fills recursively
        }
        return snapshot;
    }

    /*POSTORDER*/

    /**
     * Add all positions of the subtrees for a root, then add root to snapshot
     *
     * @param p        {Position} root for subtree
     * @param snapshot {List} a list of positions within the subtree
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p); //since postorder, add after visits to subtrees
    }

    /**
     * Postorder traversal - visit all subtrees recursively -> visit root
     *
     * @return an iterable of all positions in tree
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    /*NESTED ELEMENT ITERATOR CLASS*/

    /**
     * Adapts the iteration produced in positions() to give the elements
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIter = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIter.hasNext();
        }

        @Override
        public E next() {
            return posIter.next().getElement();
        }

        public void remove() {
            posIter.remove();
        }
    }

    /**
     * Get an element iterator for tree
     *
     * @return {Iterator} a new ElementIterator for tree
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
