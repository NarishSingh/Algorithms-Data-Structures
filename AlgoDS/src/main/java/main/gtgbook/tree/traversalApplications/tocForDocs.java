/*
Use preorder traversal to make a table of contents for documents

Article:
Paper
    Title
    Abstract
    §1
        §1.1
        §1.2
    §2
        §2.1
 */
package main.gtgbook.tree.traversalApplications;

import main.gtgbook.positionallist.Position;
import main.gtgbook.tree.Tree;

import java.util.ArrayList;

public class tocForDocs {

    /**
     * Get a string with spaces
     *
     * @param n {int} number of spaces required
     * @return {String} a string with n spaces only
     */
    public static String spaces(int n) {
        return " ".repeat(n);
    }

    /**
     * Print indentations for the table of contents
     *
     * @param t     {Tree} a tree to be printed
     * @param p     {Position} root of tree
     * @param depth {int} tree has this depth
     */
    public static <E> void printPreorderIndent(Tree<E> t, Position<E> p, int depth) {
        System.out.println(spaces(2 * depth) + p.getElement()); //indent based on depth * 2 spaces
        for (Position<E> c : t.children(p)) {
            printPreorderIndent(t, c, depth + 1); //recursion to do all children
        }
    }

    /**
     * Print numbered labels for a tree, with indentation
     *
     * @param t    a tree
     * @param p    Position of an element
     * @param path ArrayList of Integers, path from root to positions
     */
    public static <E> void printPreorderLabeled(Tree<E> t, Position<E> p, ArrayList<Integer> path) {
        int depth = path.size(); //depth is length of path

        //print the entry
        System.out.println(spaces(2 * depth));
        for (int i = 0; i < depth; i++) {
            System.out.println(path.get(i) + (i == depth - 1 ? " " : "."));
        }
        System.out.println(p.getElement());

        //add the new entry to end of list, then remove before making another recursive call
        path.add(1);
        for (Position<E> c : t.children(p)) {
            printPreorderLabeled(t, c, path);
            path.set(depth, 1 + path.get(depth));
        }
        path.remove(depth);
    }

    public static void main(String[] args) {
        //TODO implement a non-binary tree for this
    }
}
