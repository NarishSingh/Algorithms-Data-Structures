/*
     1
   /   \
  2     3
 / \   / \
4   5 6   7
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
        System.out.println("\nLeft Child: " + numLbt.left(leftSubtreeRootLvl1).getElement());
        System.out.println("Right Child: " + numLbt.right(leftSubtreeRootLvl1).getElement());
        System.out.println("Left Child Parent: " + numLbt.parent(lsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Parent: " + numLbt.parent(lsrRightLeafLvl2).getElement());
        System.out.println("Left Child Sibling: " + numLbt.sibling(lsrLeftLeafLvl2).getElement());
        System.out.println("Right Child Sibling: " + numLbt.sibling(lsrRightLeafLvl2).getElement());

        //right subtree
        Position<Integer> rightSubtreeRootLvl1 = numLbt.addRight(root, 5);
        Position<Integer> rsrLeftLeafLvl2 = numLbt.addLeft(rightSubtreeRootLvl1, 6);
        Position<Integer> rsrRightLeafLvl2 = numLbt.addRight(rightSubtreeRootLvl1, 7);
        System.out.println("-----\nRight Subtree");

        //TODO do for right subtree
        //TODO try the update methods
    }
}
