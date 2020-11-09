package main.tree;

public class Tree {
    private class Node {
        //can have more but will have AT LEAST 3 fields
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    Node root; //like head, starting node, entry point for searches also

    public Tree() {
        this.root = null;
    }

    /**
     * Add a new node
     *
     * @param value {int}
     */
    public void add(int value) {
        root = addRecursive(this.root, value);
    }

    /**
     * Search the tree until find proper place to add node
     *
     * @param current  {Node} begins with root, and moves along tree recursively
     * @param newValue {int} new value to be added to tree
     * @return {Node}
     */
    private Node addRecursive(Node current, int newValue) {
        //if tree is empty/root null, just stick it in
        if (current == null) {
            return new Node(newValue);
        }

        //you want < nodes to the left and > nodes to the right
        //use recursion to build out the tree from root to leaves with new value
        //when it finds a node with an empty leaf in its proper range, add insertion as a child of that parent node
        if (newValue < current.value) {
            current.left = addRecursive(current.left, newValue);
        } else if (newValue > current.value) {
            current.right = addRecursive(current.right, newValue);
        } else {
            return current;
        }

        return current;
    }

    /*Recursive search*/

    /**
     * @param value
     * @return
     */
    public boolean findNode(int value) {
        return findNodeRecursive(this.root, value);
    }

    /**
     * @param current
     * @param value
     * @return
     */
    private boolean findNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? findNodeRecursive(current.left, value) : findNodeRecursive(current.right, value);
    }

    /*NON-RECURSIVE SEARCH*/
    Node findNodeNonRecu(int search) {
        Node current = this.root;

        //loop through tree until find the node
        while (current != null && current.value != search) {
            if (search < current.value) {
                current = current.left;
            } else{
                current = current.right;
            }
        }

        if (current == null){
            System.out.println("Node not in tree");
            return null;
        } else {
            return current;
        }
    }

    public static void main(String[] args) {
        Tree bt = new Tree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.println(bt.root.right.value);
    }
}
