package main.gtgbook.deque;

public class admain {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>(5);

        d.addFirst(1);
        d.addFirst(0);
        d.addLast(2);
        d.addLast(3);

        System.out.println("Size = " + d.size());
        System.out.println(d.first());
        System.out.println(d.last());

        d.removeFirst();
        System.out.println(d.first());

        d.addLast(4);
        System.out.println(d.last());

        d.addLast(5);
        System.out.println(d.last());
        d.removeLast();
        System.out.println(d.last());
    }
}
