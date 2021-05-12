package main.gtgbook.tree;

import main.gtgbook.positionallist.Position;

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
}
