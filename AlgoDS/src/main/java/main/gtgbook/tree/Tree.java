package main.gtgbook.tree;

import main.gtgbook.positionallist.Position;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    /**
     * Get the root of tree - topmost element
     *
     * @return {Position} the position of the root
     */
    Position<E> root();

    /**
     * Get the parent of a position in tree
     *
     * @param p {Position} a position for a element of tree
     * @return {Position} the parent of position p - null if p is root
     * @throws IllegalArgumentException if an invalid position is provided
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Get a collection of all children of a position
     *
     * @param p {Position} a position for a element of tree
     * @return {Iterable} an iterable collection of Positions containing all children of p
     * @throws IllegalArgumentException
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * Get the number of children of a position
     *
     * @param p {Position} a position for a element of tree
     * @return {int} the number of children of p
     * @throws IllegalArgumentException if an invalid position is provided
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Position of element is internal if it has at least 1 child
     *
     * @param p {Position} a position for a element of tree
     * @return {boolean} true if has >=1 child, false otherwise
     * @throws IllegalArgumentException if an invalid position is provided
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Position of element is external (a "leaf") if it has no children
     *
     * @param p {Position} a position for a element of tree
     * @return {true} if has no child and is external, false otherwise
     * @throws IllegalArgumentException if an invalid position is provided
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Return number of positions/elements of tree
     *
     * @return {int} number of elements in tree
     */
    int size();

    /**
     * Evaluates if tree is empty
     *
     * @return {boolean} true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Makes tree iterable
     *
     * @return {Iterator} an iterator for all elements in tree
     */
    Iterator<E> iterator();

    /**
     * Get a collection of all positions in tree
     *
     * @return {Iterable} an iterable collection of all positions
     */
    Iterable<Position<E>> positions();
}
