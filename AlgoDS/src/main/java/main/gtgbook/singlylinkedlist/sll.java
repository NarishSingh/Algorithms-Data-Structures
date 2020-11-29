package main.gtgbook.singlylinkedlist;

public class sll {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> intL = new SinglyLinkedList<>();

        System.out.println("===int===");
        intL.addFirst(1);
        intL.addLast(10);
        intL.addFirst(0);
        System.out.println("Original: " + intL.toString());

        intL.removeFirst();
        intL.removeFirst();
        System.out.println("Remove twice: " + intL.toString());

        SinglyLinkedList<Double> dubL = new SinglyLinkedList<>();

        System.out.println("\n===double===");
        dubL.addFirst(1.1);
        dubL.addFirst(99.89);
        dubL.addLast(6666666.3);
        dubL.addFirst(0.123);
        dubL.addLast(0.000005);
        System.out.println("Original: " + dubL.toString());

        dubL.removeFirst();
        dubL.removeFirst();
        System.out.println("Remove twice: " + dubL.toString());
    }
}
