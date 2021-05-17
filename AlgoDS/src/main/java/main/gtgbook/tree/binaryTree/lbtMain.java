/*
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Update:
         1
       /   \
      2     3
     / \   / \
    4   5 6   7
   /           \
  8             9/10
                /
               11
              /
             12/x
 */
package main.gtgbook.tree.binaryTree;

import main.gtgbook.positionallist.Position;

public class lbtMain {

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> numLbt = new LinkedBinaryTree<>();
        System.out.println("*New Tree*");
        System.out.println(numLbt.size());
        System.out.println(numLbt.isEmpty());

        Position<Integer> root = numLbt.addRoot(1);

        //left subtree
        Position<Integer> leftSubtreeRootLvl1 = numLbt.addLeft(root, 2);
        Position<Integer> lsrLeftLeafLvl2 = numLbt.addLeft(leftSubtreeRootLvl1, 3);
        Position<Integer> lsrRightLeafLvl2 = numLbt.addRight(leftSubtreeRootLvl1, 4);
        System.out.println("-----\nLeft Subtree");
        System.out.println("Root: " + leftSubtreeRootLvl1.getElement());
        System.out.print("Root's Children [" + numLbt.numChildren(leftSubtreeRootLvl1) + "]: ");
        numLbt.children(leftSubtreeRootLvl1)
                .forEach(c -> System.out.print(c.getElement() + " "));
        System.out.println(numLbt.isInternal(leftSubtreeRootLvl1) ? "\nParent is internal" : "Error...");
        System.out.println("Left Child: " + numLbt.left(leftSubtreeRootLvl1).getElement());
        System.out.println(numLbt.isExternal(lsrLeftLeafLvl2) ? "Left child is external" : "Child is not external");
        System.out.println("Right Child: " + numLbt.right(leftSubtreeRootLvl1).getElement());
        System.out.println("Left Child Parent: " + numLbt.parent(lsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Parent: " + numLbt.parent(lsrRightLeafLvl2).getElement());
        System.out.println("Left Child Sibling: " + numLbt.sibling(lsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Sibling: " + numLbt.sibling(lsrRightLeafLvl2).getElement());
        System.out.println("Depth of Right Child: " + numLbt.depth(lsrLeftLeafLvl2));
        System.out.println("Height of Right Child: " + numLbt.height(lsrLeftLeafLvl2));

        //right subtree
        Position<Integer> rightSubtreeRootLvl1 = numLbt.addRight(root, 5);
        Position<Integer> rsrLeftLeafLvl2 = numLbt.addLeft(rightSubtreeRootLvl1, 6);
        Position<Integer> rsrRightLeafLvl2 = numLbt.addRight(rightSubtreeRootLvl1, 7);
        System.out.println("-------\nRight Subtree");
        System.out.println("Root: " + rightSubtreeRootLvl1.getElement());
        System.out.print("Root's Children [" + numLbt.numChildren(rightSubtreeRootLvl1) + "]: ");
        numLbt.children(rightSubtreeRootLvl1)
                .forEach(c -> System.out.print(c.getElement() + " "));
        System.out.println(numLbt.isInternal(rightSubtreeRootLvl1) ? "\nParent is internal" : "Error...");
        System.out.println("Left Child: " + numLbt.left(rightSubtreeRootLvl1).getElement());
        System.out.println(numLbt.isExternal(rsrLeftLeafLvl2) ? "Left child is external" : "Child is not external");
        System.out.println("Right Child: " + numLbt.right(rightSubtreeRootLvl1).getElement());
        System.out.println("Left Child Parent: " + numLbt.parent(rsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Parent: " + numLbt.parent(rsrRightLeafLvl2).getElement());
        System.out.println("Left Child Sibling: " + numLbt.sibling(rsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Sibling: " + numLbt.sibling(rsrRightLeafLvl2).getElement());
        System.out.println("Depth of Right Child: " + numLbt.depth(rsrLeftLeafLvl2));
        System.out.println("Height of Right Child: " + numLbt.height(rsrLeftLeafLvl2));

        System.out.println("\nTree Size: " + numLbt.size());
        System.out.println(numLbt.isEmpty() ? "Is empty" : "Is not empty");

        //updates
        System.out.println("\n-------\nUpdated");
        Position<Integer> leftLeafLvl3 = numLbt.addLeft(lsrLeftLeafLvl2, 8);
        Position<Integer> rightLeafLvl3 = numLbt.addRight(rsrRightLeafLvl2, 9);
        System.out.println(numLbt.isExternal(lsrLeftLeafLvl2) ? "Leftmost Leaf - Still external" : "Leftmost Leaf - No longer external");
        System.out.print("Former Leftmost Leaf's Children [" + numLbt.numChildren(lsrLeftLeafLvl2) + "]: ");
        numLbt.children(lsrLeftLeafLvl2)
                .forEach(c -> System.out.print(c.getElement() + " "));
        System.out.println("\nLeaf is " + (numLbt.left(lsrLeftLeafLvl2) != null ? "Left" : "Right"));

        System.out.println(numLbt.isExternal(rsrRightLeafLvl2) ? "Rightmost Leaf - Still external" : "Rightmost Leaf - No longer external");
        System.out.print("Former Rightmost Leaf's Children [" + numLbt.numChildren(rsrRightLeafLvl2) + "]: ");
        numLbt.children(rsrRightLeafLvl2)
                .forEach(c -> System.out.print(c.getElement() + " "));
        System.out.println("\nLeaf is " + (numLbt.left(rsrRightLeafLvl2) != null ? "Left" : "Right"));

        //set 9 to 10
        System.out.println("\nReplaced number - rightmost leaf: " + numLbt.set(rightLeafLvl3, 10));
        System.out.println("New element: " + numLbt.right(rsrRightLeafLvl2).getElement());

        //attach a 11 - L 12 R null subtree to 10
        LinkedBinaryTree<Integer> newNumLbt = new LinkedBinaryTree<>();
        Position<Integer> otherRoot = newNumLbt.addRoot(11);
        Position<Integer> newTreeLeftChild = newNumLbt.addLeft(otherRoot, 12);

        numLbt.attach(rightLeafLvl3, newNumLbt, new LinkedBinaryTree<>()); //right is empty
        System.out.println("Rightmost (former) leaf's new child: " + numLbt.left(rightLeafLvl3).getElement());
        System.out.println(numLbt.isExternal(rightLeafLvl3) ? "Still external" : "No longer external");
        Position<Integer> deepestLeaf = numLbt.left(numLbt.left(rightLeafLvl3));
        System.out.println("Deepest leaf: " + deepestLeaf.getElement());
        System.out.println("Full tree depth: " + numLbt.depth(deepestLeaf));

        //remove
        System.out.println("\nRemove: " + numLbt.remove(deepestLeaf));
        System.out.println("Full depth after removal: " + numLbt.depth(numLbt.left(rightLeafLvl3)));

        //traversal
        Iterable<Position<Integer>> positionIterable = numLbt.positions(); //uses inorder traversal
        System.out.println("\nAll positions, traversed: ");
        positionIterable.forEach(p -> System.out.print(p.getElement() + " "));
    }
}
