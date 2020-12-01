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

        CircularLinkedList<Integer> intCLclone = new CircularLinkedList<>();
        intCLclone.addFirst(3);
        intCLclone.addFirst(2);
        intCLclone.addFirst(1);
        intCLclone.addLast(4);
        intCLclone.addLast(5);

        System.out.println("\nEquals?: " + intCL.equals(intCLclone));
    }
}
