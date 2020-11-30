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

        System.out.println("\nEquals?: " + intL.equals(dubL));

        SinglyLinkedList<Double> copyDubL = new SinglyLinkedList<>();
        copyDubL.addFirst(1.1);
        copyDubL.addFirst(99.89);
        copyDubL.addLast(6666666.3);
        copyDubL.addFirst(0.123);
        copyDubL.addLast(0.000005);
        copyDubL.removeFirst();
        copyDubL.removeFirst();

        System.out.println("\nCopies Equals?: " + dubL.equals(copyDubL));

        try {
            SinglyLinkedList<Double> anotherCopyDubL = dubL.clone();
            System.out.println("\nCloned Equals?: " + dubL.equals(anotherCopyDubL));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
