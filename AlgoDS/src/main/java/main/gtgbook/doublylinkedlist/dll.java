package main.gtgbook.doublylinkedlist;

public class dll {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> intDL = new DoublyLinkedList<>();

        System.out.println("===int===");
        intDL.addFirst(3);
        intDL.addFirst(2);
        intDL.addFirst(1);
        intDL.addLast(4);
        intDL.addLast(5);

        System.out.println("Size = " + intDL.size() + "\n");

        for (int i = 0; i < 5; i++) {
            System.out.println(intDL.first());
            System.out.println(intDL.middle());
            System.out.println(intDL.last());

            intDL.removeFirst();
//            intDL.removeLast();

            System.out.println("---");
        }

        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> test2 = new DoublyLinkedList<>();
        test1.addFirst(3);
        test1.addFirst(2);
        test1.addFirst(1);
        test2.addFirst(3);
        test2.addFirst(2);
        test2.addFirst(1);

        System.out.println("\nEquals?: " + test1.equals(test2));

        try {
            DoublyLinkedList<Integer> cloned = intDL.clone();
            System.out.println("\nCloned Equals?: " + intDL.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
