package main.gtgbook.tree.binaryTree;

import main.gtgbook.positionallist.Position;
import main.gtgbook.tree.AbstractTree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);

        if (parent == null) {
            return null; //p must be root
        }

        //each may be nullable, but simply return the other position
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int ct = 0;

        if (left(p) != null) {
            ct++;
        }

        if (right(p) != null) {
            ct++;
        }

        return ct;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2); //only a left and right element

        if (left(p) != null) {
            snapshot.add(left(p));
        }

        if (right(p) != null) {
            snapshot.add(right(p));
        }

        return snapshot;
    }
}
