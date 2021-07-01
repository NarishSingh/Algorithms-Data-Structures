package main.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TreePreorder {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Find all children of a node
     *
     * @param n Node
     * @return list of nodes, left first then right
     */
    private static List<Node> children(Node n) {
        List<Node> nodes = new ArrayList<>(2);
        if (n.left != null) nodes.add(n.left);
        if (n.right != null) nodes.add(n.right);
        return nodes;
    }

    /**
     * Add root then all children to a snapshot for recursion
     *
     * @param subNode  root of subtree
     * @param snapshot list of Nodes
     */
    private static void preorderSub(Node subNode, List<Node> snapshot) {
        snapshot.add(subNode);
        for (Node n : children(subNode)) {
            preorderSub(n, snapshot);
        }
    }

    /**
     * Perform a preorder traveral on tree and print values
     *
     * @param root root Node of tree
     */
    private static void preOrder(Node root) {
        List<Node> nodes = new ArrayList<>();
        preorderSub(root, nodes); //fill list recursively

        for (Node n : nodes) {
            System.out.print(n.data + " ");
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);

        Node lvl2 = new Node(2);
        root1.right = lvl2;

        Node lvl3 = new Node(5);
        lvl2.right = lvl3;

        Node lvl4Left = new Node(3);
        Node lvl4Right = new Node(6);
        lvl3.left = lvl4Left;
        lvl3.right = lvl4Right;

        Node lvl5 = new Node(4);
        lvl4Left.right = lvl5;

        preOrder(root1);
    }
}
