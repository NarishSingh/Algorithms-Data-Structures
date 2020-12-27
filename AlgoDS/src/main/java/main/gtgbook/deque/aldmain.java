package main.gtgbook.deque;

public class aldmain {

    public static void main(String[] args) {
        ArrayListDeque<Integer> ald = new ArrayListDeque<>(2);
        ald.addFirst(0);
        ald.addLast(1);
        ald.addLast(2); //will resize to 4

        System.out.println("Size? = " + ald.size());
        System.out.println(ald.first());
        System.out.println(ald.last());
        System.out.println(ald.toString());

        ald.removeFirst();
        System.out.println("\n" + ald.first());

        ald.removeLast();
        System.out.println(ald.last());

        System.out.println(ald.toString());

        ald.addLast(2);
        ald.addLast(3);
        ald.addLast(4);
        ald.addLast(5);

        /*clone and equals*/
        try {
            ArrayListDeque<Integer> cloned = ald.clone();
            System.out.println("\n" + cloned.toString());
            System.out.println("Cloned equals?: " + ald.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
