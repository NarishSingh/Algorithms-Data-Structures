package main.gtgbook.tree.binaryTree;

import main.gtgbook.positionallist.Position;
import main.gtgbook.tree.Tree;

public interface BinaryTree<E> extends Tree<E> {

    /**
     * Get the left child of binary tree
     *
     * @param p {Position} position of an element in binary tree
     * @return {Position} position of the left child, null if none exist
     * @throws IllegalArgumentException if an invalid position is provided
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Get the right child of binary tree
     *
     * @param p {Position} position of an element in binary tree
     * @return {Position} position of the right child, null if none exist
     * @throws IllegalArgumentException if an invalid position is provided
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Get sibling of position regardless of directionality
     *
     * @param p {Position} position of an element in binary tree
     * @return {Position} position of the sibling element, null if none exist
     * @throws IllegalArgumentException if an invalid position is provided
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
