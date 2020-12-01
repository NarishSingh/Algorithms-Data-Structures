package main.gtgbook.circularlinkedlist;

public class cll {

    public static void main(String[] args) {
        CircularLinkedList<Integer> intCL = new CircularLinkedList<>();

        System.out.println("===int===");
        intCL.addFirst(3);
        intCL.addFirst(2);
        intCL.addFirst(1);
        intCL.addLast(4);
        intCL.addLast(5);

        System.out.println("Size = " + intCL.size() + "\n");

        System.out.println(intCL.first().toString());
        System.out.println(intCL.last().toString());

        for (int i = 0; i < 5; i++) {
            System.out.println("***Rotating***");
            intCL.rotate();
            System.out.println(intCL.first().toString());
            System.out.println(intCL.last().toString());
        }

        CircularLinkedList<Integer> secondIntCL = new CircularLinkedList<>();
        secondIntCL.addFirst(3);
        secondIntCL.addFirst(2);
        secondIntCL.addFirst(1);
        secondIntCL.addLast(4);
        secondIntCL.addLast(5);

        System.out.println("\nEquals?: " + intCL.equals(secondIntCL));

        try {
            CircularLinkedList<Integer> cloned = intCL.clone();
            System.out.println("\nCloned Equals?: " + intCL.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
