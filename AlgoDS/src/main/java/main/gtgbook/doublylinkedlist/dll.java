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
    }
}
